//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: ../runtime/src/main/java/ru/korinc/runtime/rx/casthell/StringObservable.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_StringObservable")
#ifdef RESTRICT_StringObservable
#define INCLUDE_ALL_StringObservable 0
#else
#define INCLUDE_ALL_StringObservable 1
#endif
#undef RESTRICT_StringObservable

#if !defined (RuKorincRuntimeRxCasthellStringObservable_) && (INCLUDE_ALL_StringObservable || defined(INCLUDE_RuKorincRuntimeRxCasthellStringObservable))
#define RuKorincRuntimeRxCasthellStringObservable_

#define RESTRICT_TypedObservable 1
#define INCLUDE_RuKorincRuntimeRxCasthellTypedObservable 1
#include "TypedObservable.h"

@protocol RuKorincRuntimeRxObservableWrapper;

@interface RuKorincRuntimeRxCasthellStringObservable : RuKorincRuntimeRxCasthellTypedObservable

#pragma mark Public

- (instancetype)initWithRuKorincRuntimeRxObservableWrapper:(id<RuKorincRuntimeRxObservableWrapper>)source;

+ (RuKorincRuntimeRxCasthellStringObservable *)fromWithRuKorincRuntimeRxObservableWrapper:(id<RuKorincRuntimeRxObservableWrapper>)source;

#pragma mark Protected

- (RuKorincRuntimeRxCasthellTypedObservable *)fromInternalWithRuKorincRuntimeRxObservableWrapper:(id<RuKorincRuntimeRxObservableWrapper>)source;

@end

J2OBJC_EMPTY_STATIC_INIT(RuKorincRuntimeRxCasthellStringObservable)

FOUNDATION_EXPORT void RuKorincRuntimeRxCasthellStringObservable_initWithRuKorincRuntimeRxObservableWrapper_(RuKorincRuntimeRxCasthellStringObservable *self, id<RuKorincRuntimeRxObservableWrapper> source);

FOUNDATION_EXPORT RuKorincRuntimeRxCasthellStringObservable *new_RuKorincRuntimeRxCasthellStringObservable_initWithRuKorincRuntimeRxObservableWrapper_(id<RuKorincRuntimeRxObservableWrapper> source) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT RuKorincRuntimeRxCasthellStringObservable *create_RuKorincRuntimeRxCasthellStringObservable_initWithRuKorincRuntimeRxObservableWrapper_(id<RuKorincRuntimeRxObservableWrapper> source);

FOUNDATION_EXPORT RuKorincRuntimeRxCasthellStringObservable *RuKorincRuntimeRxCasthellStringObservable_fromWithRuKorincRuntimeRxObservableWrapper_(id<RuKorincRuntimeRxObservableWrapper> source);

J2OBJC_TYPE_LITERAL_HEADER(RuKorincRuntimeRxCasthellStringObservable)

#endif

#pragma pop_macro("INCLUDE_ALL_StringObservable")
