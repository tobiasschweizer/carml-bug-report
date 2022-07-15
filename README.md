# CARML Bug Report

This repo documents a bug I have encountered when using CARML.

Steps to reproduce:
- adapt `basePath` in `src/main/java/org/example/Main.java` (absolute path to this repo on local file system)
- run `src/main/java/org/example/Main.java`: 
```
Exception in thread "main" java.lang.NullPointerException
	at io.carml.engine.rdf.RdfTermGeneratorFactory.createNaturalRdfLexicalForm(RdfTermGeneratorFactory.java:481)
	at io.carml.engine.rdf.RdfTermGeneratorFactory.lambda$unpackEvaluatedExpression$27(RdfTermGeneratorFactory.java:446)
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
	at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
	at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
	at io.carml.engine.rdf.RdfTermGeneratorFactory.unpackEvaluatedExpression(RdfTermGeneratorFactory.java:447)
	at io.carml.engine.rdf.RdfTermGeneratorFactory.lambda$generateValues$6(RdfTermGeneratorFactory.java:200)
	at java.base/java.util.Optional.map(Optional.java:265)
	at io.carml.engine.rdf.RdfTermGeneratorFactory.generateValues(RdfTermGeneratorFactory.java:200)
	at io.carml.engine.rdf.RdfTermGeneratorFactory.lambda$getGenerator$4(RdfTermGeneratorFactory.java:153)
	at io.carml.engine.rdf.RdfSubjectMapper.map(RdfSubjectMapper.java:66)
	at io.carml.engine.rdf.RdfTriplesMapper.lambda$mapEvaluation$7(RdfTriplesMapper.java:159)
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
	at java.base/java.util.Iterator.forEachRemaining(Iterator.java:133)
	at java.base/java.util.Spliterators$IteratorSpliterator.forEachRemaining(Spliterators.java:1801)
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
	at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
	at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
	at io.carml.engine.rdf.RdfTriplesMapper.mapEvaluation(RdfTriplesMapper.java:160)
	at io.carml.engine.rdf.RdfTriplesMapper.map(RdfTriplesMapper.java:152)
	at io.carml.engine.RmlMapper.lambda$mapTriples$5(RmlMapper.java:148)
	at reactor.core.publisher.FluxFlatMap$FlatMapMain.onNext(FluxFlatMap.java:386)
	at reactor.core.publisher.FluxIterable$IterableSubscription.slowPath(FluxIterable.java:272)
	at reactor.core.publisher.FluxIterable$IterableSubscription.request(FluxIterable.java:230)
	at reactor.core.publisher.FluxFlatMap$FlatMapMain.onSubscribe(FluxFlatMap.java:371)
	at reactor.core.publisher.FluxIterable.subscribe(FluxIterable.java:165)
	at reactor.core.publisher.FluxIterable.subscribe(FluxIterable.java:87)
	at reactor.core.publisher.Flux.subscribe(Flux.java:8466)
	at reactor.core.publisher.FluxFlatMap$FlatMapMain.onNext(FluxFlatMap.java:426)
	at reactor.core.publisher.FluxCreate$BufferAsyncSink.drain(FluxCreate.java:814)
	at reactor.core.publisher.FluxCreate$BufferAsyncSink.next(FluxCreate.java:739)
	at reactor.core.publisher.FluxCreate$SerializedFluxSink.next(FluxCreate.java:161)
	at io.carml.logicalsourceresolver.JsonPathResolver.lambda$bridgeAndListen$5(JsonPathResolver.java:135)
	at org.jsfr.json.DispatchUtil.dispatchValueToListeners(DispatchUtil.java:37)
	at org.jsfr.json.JsonCollector.endObject(JsonCollector.java:47)
	at org.jsfr.json.ContentDispatcher.endObject(ContentDispatcher.java:87)
	at org.jsfr.json.SurfingContext.endObject(SurfingContext.java:247)
	at org.jsfr.json.JacksonParser$JacksonResumableParser.doPare(JacksonParser.java:167)
	at org.jsfr.json.JacksonParser$JacksonResumableParser.parse(JacksonParser.java:145)
	at org.jsfr.json.JacksonParser$JacksonNonblockingParser.feed(JacksonParser.java:58)
	at io.carml.logicalsourceresolver.JsonPathResolver.readSource(JsonPathResolver.java:161)
	at io.carml.logicalsourceresolver.JsonPathResolver.lambda$getObjectFlux$4(JsonPathResolver.java:123)
	at reactor.core.publisher.FluxCreate.subscribe(FluxCreate.java:95)
	at reactor.core.publisher.Flux.subscribe(Flux.java:8466)
	at reactor.core.publisher.FluxFlatMap.trySubscribeScalarMap(FluxFlatMap.java:200)
	at reactor.core.publisher.FluxFlatMap.subscribeOrReturn(FluxFlatMap.java:93)
	at reactor.core.publisher.Flux.subscribe(Flux.java:8452)
	at reactor.core.publisher.FluxFlatMap$FlatMapMain.onNext(FluxFlatMap.java:426)
	at reactor.core.publisher.FluxIterable$IterableSubscription.slowPath(FluxIterable.java:272)
	at reactor.core.publisher.FluxIterable$IterableSubscription.request(FluxIterable.java:230)
	at reactor.core.publisher.FluxFlatMap$FlatMapMain.onSubscribe(FluxFlatMap.java:371)
	at reactor.core.publisher.FluxIterable.subscribe(FluxIterable.java:165)
	at reactor.core.publisher.FluxIterable.subscribe(FluxIterable.java:87)
	at reactor.core.publisher.Flux.subscribe(Flux.java:8466)
	at reactor.core.publisher.FluxConcatArray$ConcatArraySubscriber.onComplete(FluxConcatArray.java:258)
	at reactor.core.publisher.FluxConcatArray.subscribe(FluxConcatArray.java:78)
	at reactor.core.publisher.Mono.subscribe(Mono.java:4397)
	at reactor.core.publisher.Mono.block(Mono.java:1730)
	at io.carml.engine.rdf.RdfRmlMapper.toModel(RdfRmlMapper.java:338)
	at io.carml.engine.rdf.RdfRmlMapper.mapToModel(RdfRmlMapper.java:305)
	at org.example.Main.main(Main.java:52)
	Suppressed: java.lang.Exception: #block terminated with an error
		at reactor.core.publisher.BlockingSingleSubscriber.blockingGet(BlockingSingleSubscriber.java:139)
		at reactor.core.publisher.Mono.block(Mono.java:1731)
		... 3 more

Process finished with exit code 1
```

## Further Information

When running the example above, the mapping is applied to the institutions contained in `test-data/data2.json`: 
`id` for the subject map and `country_code` in an object map.

These can be null in JSON.

Change the file in `test-data/mapping.ttl` to `data1.json`. This works as expected since the named properties are not null.