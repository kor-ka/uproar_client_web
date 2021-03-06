//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: ../runtime/src/main/java/ru/korinc/runtime/rx/casthell/TypedObservable.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_TypedObservable")
#ifdef RESTRICT_TypedObservable
#define INCLUDE_ALL_TypedObservable 0
#else
#define INCLUDE_ALL_TypedObservable 1
#endif
#undef RESTRICT_TypedObservable

#if !defined (RuKorincRuntimeRxCasthellTypedObservable_) && (INCLUDE_ALL_TypedObservable || defined(INCLUDE_RuKorincRuntimeRxCasthellTypedObservable))
#define RuKorincRuntimeRxCasthellTypedObservable_

#define RESTRICT_ObservableWrapper 1
#define INCLUDE_RuKorincRuntimeRxObservableWrapper 1
#include "ObservableWrapper.h"

@protocol RuKorincRuntimeRxBackgroundSchedulerWrapper;
@protocol RuKorincRuntimeRxConsumer;
@protocol RuKorincRuntimeRxDisposableWrapper;
@protocol RuKorincRuntimeRxFunction;

@interface RuKorincRuntimeRxCasthellTypedObservable : NSObject < RuKorincRuntimeRxObservableWrapper >

#pragma mark Public

- (instancetype)initWithRuKorincRuntimeRxObservableWrapper:(id<RuKorincRuntimeRxObservableWrapper>)source;

- (id<RuKorincRuntimeRxObservableWrapper>)delayWithWindowMillis:(jlong)millis;

- (id<RuKorincRuntimeRxObservableWrapper>)flatMapWithFunc:(id<RuKorincRuntimeRxFunction>)mapper;

- (id<RuKorincRuntimeRxObservableWrapper>)getSource;

- (id<RuKorincRuntimeRxObservableWrapper>)mapWithFunc:(id<RuKorincRuntimeRxFunction>)func1;

- (id<RuKorincRuntimeRxObservableWrapper>)observeOnWithScheduler:(id<RuKorincRuntimeRxBackgroundSchedulerWrapper>)scheduler;

- (id<RuKorincRuntimeRxObservableWrapper>)observeOnMain;

- (id<RuKorincRuntimeRxObservableWrapper>)retryWhenWithWindowMillis:(id<RuKorincRuntimeRxFunction>)handler;

- (id<RuKorincRuntimeRxDisposableWrapper>)subscribeWithConsumer:(id<RuKorincRuntimeRxConsumer>)consumer;

- (id<RuKorincRuntimeRxObservableWrapper>)subscribeOnWithScheduler:(id<RuKorincRuntimeRxBackgroundSchedulerWrapper>)scheduler;

- (id<RuKorincRuntimeRxObservableWrapper>)switchOnNextWithSources:(id<RuKorincRuntimeRxObservableWrapper>)sources;

- (id<RuKorincRuntimeRxObservableWrapper>)throttleLastWithWindowMillis:(jlong)windowMillis;

- (id<RuKorincRuntimeRxObservableWrapper>)timerWithWindowMillis:(jlong)millis;

#pragma mark Protected

- (RuKorincRuntimeRxCasthellTypedObservable *)fromInternalWithRuKorincRuntimeRxObservableWrapper:(id<RuKorincRuntimeRxObservableWrapper>)source;

@end

J2OBJC_EMPTY_STATIC_INIT(RuKorincRuntimeRxCasthellTypedObservable)

FOUNDATION_EXPORT void RuKorincRuntimeRxCasthellTypedObservable_initWithRuKorincRuntimeRxObservableWrapper_(RuKorincRuntimeRxCasthellTypedObservable *self, id<RuKorincRuntimeRxObservableWrapper> source);

J2OBJC_TYPE_LITERAL_HEADER(RuKorincRuntimeRxCasthellTypedObservable)

#endif

#pragma pop_macro("INCLUDE_ALL_TypedObservable")
