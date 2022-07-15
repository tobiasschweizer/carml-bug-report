package org.example;

import io.carml.engine.rdf.RdfRmlMapper;
import io.carml.logicalsourceresolver.CsvResolver;
import io.carml.logicalsourceresolver.JsonPathResolver;
import io.carml.logicalsourceresolver.XPathResolver;
import io.carml.model.TriplesMap;
import io.carml.util.RmlMappingLoader;
import io.carml.vocab.Rdf;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.impl.ValidatingValueFactory;
import org.eclipse.rdf4j.rio.RDFFormat;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        String basePath = "absolute/path/to/repo";

        Set<TriplesMap> mapping = RmlMappingLoader.build()
                .load(RDFFormat.TURTLE, Paths.get(basePath + "mapping.ttl"));

        RdfRmlMapper mapper = RdfRmlMapper.builder()
                // add mappings
                .triplesMaps(mapping)
                // Add the resolvers to suit your need
                .setLogicalSourceResolver(Rdf.Ql.JsonPath, JsonPathResolver::getInstance)
                .setLogicalSourceResolver(Rdf.Ql.XPath, XPathResolver::getInstance)
                .setLogicalSourceResolver(Rdf.Ql.Csv, CsvResolver::getInstance)
                //-- optional: --
                // specify IRI unicode normalization form (default = NFC)
                // see http://www.unicode.org/unicode/reports/tr15/tr15-23.html
                .iriUnicodeNormalization(Normalizer.Form.NFKC)
                // set file directory for sources in mapping
                .fileResolver(new File(basePath).toPath())
                // set classpath basepath for sources in mapping
                .classPathResolver("")
                // specify casing of hex numbers in IRI percent encoding (default = true)
                // added for backwards compatibility with IRI encoding up until v0.2.3
                .iriUpperCasePercentEncoding(false)
                // Specify a custom value factory supplier
                .valueFactorySupplier(ValidatingValueFactory::new)
                //---------------

                .build();

        Model result = mapper.mapToModel();

        System.out.println(result);
    }
}