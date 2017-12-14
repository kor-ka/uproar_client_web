//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: ../runtime/src/main/java/ru/korinc/runtime/rx/casthell/TypedObservable.java
//

#include "BackgroundSchedulerWrapper.h"
#include "Consumer.h"
#include "DisposableWrapper.h"
#include "Function.h"
#include "J2ObjC_source.h"
#include "ObservableWrapper.h"
#include "TypedObservable.h"
#include "java/lang/RuntimeException.h"

@interface RuKorincRuntimeRxCasthellTypedObservable () {
 @public
  id<RuKorincRuntimeRxObservableWrapper> source_;
}

@end

J2OBJC_FIELD_SETTER(RuKorincRuntimeRxCasthellTypedObservable, source_, id<RuKorincRuntimeRxObservableWrapper>)

@implementation RuKorincRuntimeRxCasthellTypedObservable

- (instancetype)initWithRuKorincRuntimeRxObservableWrapper:(id<RuKorincRuntimeRxObservableWrapper>)source {
  RuKorincRuntimeRxCasthellTypedObservable_initWithRuKorincRuntimeRxObservableWrapper_(self, source);
  return self;
}

- (RuKorincRuntimeRxCasthellTypedObservable *)fromInternalWithRuKorincRuntimeRxObservableWrapper:(id<RuKorincRuntimeRxObservableWrapper>)source {
  // can't call an abstract method
  [self doesNotRecognizeSelector:_cmd];
  return 0;
}

- (id<RuKorincRuntimeRxObservableWrapper>)observeOnMain {
  return [self fromInternalWithRuKorincRuntimeRxObservableWrapper:[((id<RuKorincRuntimeRxObservableWrapper>) nil_chk(source_)) observeOnMain]];
}

- (id<RuKorincRuntimeRxObservableWrapper>)observeOnWithScheduler:(id<RuKorincRuntimeRxBackgroundSchedulerWrapper>)scheduler {
  return [self fromInternalWithRuKorincRuntimeRxObservableWrapper:[((id<RuKorincRuntimeRxObservableWrapper>) nil_chk(source_)) observeOnWithScheduler:scheduler]];
}

- (id<RuKorincRuntimeRxObservableWrapper>)subscribeOnWithScheduler:(id<RuKorincRuntimeRxBackgroundSchedulerWrapper>)scheduler {
  return [self fromInternalWithRuKorincRuntimeRxObservableWrapper:[((id<RuKorincRuntimeRxObservableWrapper>) nil_chk(source_)) subscribeOnWithScheduler:scheduler]];
}

- (id<RuKorincRuntimeRxDisposableWrapper>)subscribeWithConsumer:(id<RuKorincRuntimeRxConsumer>)consumer {
  return [((id<RuKorincRuntimeRxObservableWrapper>) nil_chk(source_)) subscribeWithConsumer:consumer];
}

- (id<RuKorincRuntimeRxObservableWrapper>)mapWithFunc:(id<RuKorincRuntimeRxFunction>)func1 {
  return nil;
}

- (id<RuKorincRuntimeRxObservableWrapper>)flatMapWithFunc:(id<RuKorincRuntimeRxFunction>)mapper {
  return nil;
}

- (id<RuKorincRuntimeRxObservableWrapper>)throttleLastWithWindowMillis:(jlong)windowMillis {
  return [self fromInternalWithRuKorincRuntimeRxObservableWrapper:[((id<RuKorincRuntimeRxObservableWrapper>) nil_chk(source_)) throttleLastWithWindowMillis:windowMillis]];
}

- (id<RuKorincRuntimeRxObservableWrapper>)delayWithWindowMillis:(jlong)millis {
  return [self fromInternalWithRuKorincRuntimeRxObservableWrapper:[((id<RuKorincRuntimeRxObservableWrapper>) nil_chk(source_)) delayWithWindowMillis:millis]];
}

- (id<RuKorincRuntimeRxObservableWrapper>)retryWhenWithWindowMillis:(id<RuKorincRuntimeRxFunction>)handler {
  return [self fromInternalWithRuKorincRuntimeRxObservableWrapper:[((id<RuKorincRuntimeRxObservableWrapper>) nil_chk(source_)) retryWhenWithWindowMillis:handler]];
}

- (id<RuKorincRuntimeRxObservableWrapper>)timerWithWindowMillis:(jlong)millis {
  return [((id<RuKorincRuntimeRxObservableWrapper>) nil_chk(source_)) timerWithWindowMillis:millis];
}

- (id<RuKorincRuntimeRxObservableWrapper>)switchOnNextWithSources:(id<RuKorincRuntimeRxObservableWrapper>)sources {
  @throw new_JavaLangRuntimeException_initWithNSString_(@"switchOnNext not implemented for TypedObservableWrappers");
}

- (id<RuKorincRuntimeRxObservableWrapper>)getSource {
  return source_;
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x1, -1, 0, -1, 1, -1, -1 },
    { NULL, "LRuKorincRuntimeRxCasthellTypedObservable;", 0x404, 2, 0, -1, 3, -1, -1 },
    { NULL, "LRuKorincRuntimeRxObservableWrapper;", 0x1, -1, -1, -1, 4, -1, -1 },
    { NULL, "LRuKorincRuntimeRxObservableWrapper;", 0x1, 5, 6, -1, 7, -1, -1 },
    { NULL, "LRuKorincRuntimeRxObservableWrapper;", 0x1, 8, 6, -1, 7, -1, -1 },
    { NULL, "LRuKorincRuntimeRxDisposableWrapper;", 0x1, 9, 10, -1, 11, -1, -1 },
    { NULL, "LRuKorincRuntimeRxObservableWrapper;", 0x1, 12, 13, -1, 14, -1, -1 },
    { NULL, "LRuKorincRuntimeRxObservableWrapper;", 0x1, 15, 13, -1, 16, -1, -1 },
    { NULL, "LRuKorincRuntimeRxObservableWrapper;", 0x1, 17, 18, -1, 19, -1, -1 },
    { NULL, "LRuKorincRuntimeRxObservableWrapper;", 0x1, 20, 18, -1, 19, -1, -1 },
    { NULL, "LRuKorincRuntimeRxObservableWrapper;", 0x1, 21, 13, -1, 22, -1, -1 },
    { NULL, "LRuKorincRuntimeRxObservableWrapper;", 0x1, 23, 18, -1, 24, -1, -1 },
    { NULL, "LRuKorincRuntimeRxObservableWrapper;", 0x1, 25, 0, -1, 26, -1, -1 },
    { NULL, "LRuKorincRuntimeRxObservableWrapper;", 0x1, -1, -1, -1, 4, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  methods[0].selector = @selector(initWithRuKorincRuntimeRxObservableWrapper:);
  methods[1].selector = @selector(fromInternalWithRuKorincRuntimeRxObservableWrapper:);
  methods[2].selector = @selector(observeOnMain);
  methods[3].selector = @selector(observeOnWithScheduler:);
  methods[4].selector = @selector(subscribeOnWithScheduler:);
  methods[5].selector = @selector(subscribeWithConsumer:);
  methods[6].selector = @selector(mapWithFunc:);
  methods[7].selector = @selector(flatMapWithFunc:);
  methods[8].selector = @selector(throttleLastWithWindowMillis:);
  methods[9].selector = @selector(delayWithWindowMillis:);
  methods[10].selector = @selector(retryWhenWithWindowMillis:);
  methods[11].selector = @selector(timerWithWindowMillis:);
  methods[12].selector = @selector(switchOnNextWithSources:);
  methods[13].selector = @selector(getSource);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "source_", "LRuKorincRuntimeRxObservableWrapper;", .constantValue.asLong = 0, 0x2, -1, -1, 27, -1 },
  };
  static const void *ptrTable[] = { "LRuKorincRuntimeRxObservableWrapper;", "(Lru/korinc/runtime/rx/ObservableWrapper<TT;>;)V", "fromInternal", "(Lru/korinc/runtime/rx/ObservableWrapper<TT;>;)Lru/korinc/runtime/rx/casthell/TypedObservable<TT;>;", "()Lru/korinc/runtime/rx/ObservableWrapper<TT;>;", "observeOn", "LRuKorincRuntimeRxBackgroundSchedulerWrapper;", "(Lru/korinc/runtime/rx/BackgroundSchedulerWrapper;)Lru/korinc/runtime/rx/ObservableWrapper<TT;>;", "subscribeOn", "subscribe", "LRuKorincRuntimeRxConsumer;", "(Lru/korinc/runtime/rx/Consumer<TT;>;)Lru/korinc/runtime/rx/DisposableWrapper;", "map", "LRuKorincRuntimeRxFunction;", "<R:Ljava/lang/Object;>(Lru/korinc/runtime/rx/Function<-TT;+TR;>;)Lru/korinc/runtime/rx/ObservableWrapper<TR;>;", "flatMap", "<R:Ljava/lang/Object;>(Lru/korinc/runtime/rx/Function<-TT;+Lru/korinc/runtime/rx/ObservableWrapper<+TR;>;>;)Lru/korinc/runtime/rx/ObservableWrapper<TR;>;", "throttleLast", "J", "(J)Lru/korinc/runtime/rx/ObservableWrapper<TT;>;", "delay", "retryWhen", "(Lru/korinc/runtime/rx/Function<-Lru/korinc/runtime/rx/ObservableWrapper<Ljava/lang/Throwable;>;+Lru/korinc/runtime/rx/ObservableWrapper<*>;>;)Lru/korinc/runtime/rx/ObservableWrapper<TT;>;", "timer", "(J)Lru/korinc/runtime/rx/ObservableWrapper<Ljava/lang/Long;>;", "switchOnNext", "<S:Ljava/lang/Object;>(Lru/korinc/runtime/rx/ObservableWrapper<+Lru/korinc/runtime/rx/ObservableWrapper<+TS;>;>;)Lru/korinc/runtime/rx/ObservableWrapper<TS;>;", "Lru/korinc/runtime/rx/ObservableWrapper<TT;>;", "<T:Ljava/lang/Object;>Ljava/lang/Object;Lru/korinc/runtime/rx/ObservableWrapper<TT;>;" };
  static const J2ObjcClassInfo _RuKorincRuntimeRxCasthellTypedObservable = { "TypedObservable", "ru.korinc.runtime.rx.casthell", ptrTable, methods, fields, 7, 0x401, 14, 1, -1, -1, -1, 28, -1 };
  return &_RuKorincRuntimeRxCasthellTypedObservable;
}

@end

void RuKorincRuntimeRxCasthellTypedObservable_initWithRuKorincRuntimeRxObservableWrapper_(RuKorincRuntimeRxCasthellTypedObservable *self, id<RuKorincRuntimeRxObservableWrapper> source) {
  NSObject_init(self);
  self->source_ = source;
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(RuKorincRuntimeRxCasthellTypedObservable)
