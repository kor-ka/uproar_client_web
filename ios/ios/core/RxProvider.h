//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: ../runtime/src/main/java/ru/korinc/runtime/rx/RxProvider.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_RxProvider")
#ifdef RESTRICT_RxProvider
#define INCLUDE_ALL_RxProvider 0
#else
#define INCLUDE_ALL_RxProvider 1
#endif
#undef RESTRICT_RxProvider

#if !defined (RuKorincRuntimeRxRxProvider_) && (INCLUDE_ALL_RxProvider || defined(INCLUDE_RuKorincRuntimeRxRxProvider))
#define RuKorincRuntimeRxRxProvider_

@protocol RuKorincRuntimeRxBackgroundSchedulerWrapper;
@protocol RuKorincRuntimeRxObservableOnSubscribe;
@protocol RuKorincRuntimeRxObservableWrapper;
@protocol RuKorincRuntimeRxSubjectBSWrapper;
@protocol RuKorincRuntimeRxSubjectPublishSubjectWrapper;

@protocol RuKorincRuntimeRxRxProvider < JavaObject >

- (id<RuKorincRuntimeRxObservableWrapper>)observableCreateWithSource:(id<RuKorincRuntimeRxObservableOnSubscribe>)observableOnSubscribe;

- (id<RuKorincRuntimeRxSubjectBSWrapper>)bsWithId:(id)defaultValue;

- (id<RuKorincRuntimeRxSubjectPublishSubjectWrapper>)ps;

- (id<RuKorincRuntimeRxBackgroundSchedulerWrapper>)scheduler;

@end

J2OBJC_EMPTY_STATIC_INIT(RuKorincRuntimeRxRxProvider)

J2OBJC_TYPE_LITERAL_HEADER(RuKorincRuntimeRxRxProvider)

#endif

#pragma pop_macro("INCLUDE_ALL_RxProvider")
