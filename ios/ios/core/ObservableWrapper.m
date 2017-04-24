//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: ../core/src/main/java/ru/korinc/runtime/rx/ObservableWrapper.java
//

#include "J2ObjC_source.h"
#include "ObservableWrapper.h"

@interface RuKorincRuntimeRxObservableWrapper : NSObject

@end

@implementation RuKorincRuntimeRxObservableWrapper

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, "LRuKorincRuntimeRxObservableWrapper;", 0x401, -1, -1, -1, 0, -1, -1 },
    { NULL, "LRuKorincRuntimeRxObservableWrapper;", 0x401, 1, 2, -1, 3, -1, -1 },
    { NULL, "LRuKorincRuntimeRxObservableWrapper;", 0x401, 4, 2, -1, 3, -1, -1 },
    { NULL, "LRuKorincRuntimeRxDisposableWrapper;", 0x401, 5, 6, -1, 7, -1, -1 },
    { NULL, "LRuKorincRuntimeRxObservableWrapper;", 0x401, 8, 9, -1, 10, -1, -1 },
    { NULL, "LRuKorincRuntimeRxObservableWrapper;", 0x401, 11, 9, -1, 12, -1, -1 },
    { NULL, "LRuKorincRuntimeRxObservableWrapper;", 0x401, 13, 14, -1, 15, -1, -1 },
    { NULL, "LRuKorincRuntimeRxObservableWrapper;", 0x401, 16, 14, -1, 15, -1, -1 },
    { NULL, "LRuKorincRuntimeRxObservableWrapper;", 0x401, 17, 9, -1, 18, -1, -1 },
    { NULL, "LRuKorincRuntimeRxObservableWrapper;", 0x401, 19, 20, -1, 21, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  methods[0].selector = @selector(observeOnMain);
  methods[1].selector = @selector(observeOnWithScheduler:);
  methods[2].selector = @selector(subscribeOnWithScheduler:);
  methods[3].selector = @selector(subscribeWithConsumer:);
  methods[4].selector = @selector(mapWithFunc:);
  methods[5].selector = @selector(flatMapWithFunc:);
  methods[6].selector = @selector(throttleFirstWithWindowMillis:);
  methods[7].selector = @selector(delayWithWindowMillis:);
  methods[8].selector = @selector(retryWhenWithWindowMillis:);
  methods[9].selector = @selector(switchOnNextWithSources:);
  #pragma clang diagnostic pop
  static const void *ptrTable[] = { "()Lru/korinc/runtime/rx/ObservableWrapper<TT;>;", "observeOn", "LRuKorincRuntimeRxBackgroundSchedulerWrapper;", "(Lru/korinc/runtime/rx/BackgroundSchedulerWrapper;)Lru/korinc/runtime/rx/ObservableWrapper<TT;>;", "subscribeOn", "subscribe", "LRuKorincRuntimeRxConsumer;", "(Lru/korinc/runtime/rx/Consumer<TT;>;)Lru/korinc/runtime/rx/DisposableWrapper;", "map", "LRuKorincRuntimeRxFunction;", "<R:Ljava/lang/Object;>(Lru/korinc/runtime/rx/Function<-TT;+TR;>;)Lru/korinc/runtime/rx/ObservableWrapper<TR;>;", "flatMap", "<R:Ljava/lang/Object;>(Lru/korinc/runtime/rx/Function<-TT;+Lru/korinc/runtime/rx/ObservableWrapper<+TR;>;>;)Lru/korinc/runtime/rx/ObservableWrapper<TR;>;", "throttleLast", "J", "(J)Lru/korinc/runtime/rx/ObservableWrapper<TT;>;", "delay", "retryWhen", "(Lru/korinc/runtime/rx/Function<-Lru/korinc/runtime/rx/ObservableWrapper<Ljava/lang/Throwable;>;+Lru/korinc/runtime/rx/ObservableWrapper<*>;>;)Lru/korinc/runtime/rx/ObservableWrapper<TT;>;", "switchOnNext", "LRuKorincRuntimeRxObservableWrapper;", "<S:Ljava/lang/Object;>(Lru/korinc/runtime/rx/ObservableWrapper<+Lru/korinc/runtime/rx/ObservableWrapper<+TS;>;>;)Lru/korinc/runtime/rx/ObservableWrapper<TS;>;", "<T:Ljava/lang/Object;>Ljava/lang/Object;" };
  static const J2ObjcClassInfo _RuKorincRuntimeRxObservableWrapper = { "ObservableWrapper", "ru.korinc.runtime.rx", ptrTable, methods, NULL, 7, 0x609, 10, 0, -1, -1, -1, 22, -1 };
  return &_RuKorincRuntimeRxObservableWrapper;
}

@end

J2OBJC_INTERFACE_TYPE_LITERAL_SOURCE(RuKorincRuntimeRxObservableWrapper)
