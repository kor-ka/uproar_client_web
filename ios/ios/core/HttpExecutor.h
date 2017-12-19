//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: ../runtime/src/main/java/ru/korinc/runtime/network/HttpExecutor.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_HttpExecutor")
#ifdef RESTRICT_HttpExecutor
#define INCLUDE_ALL_HttpExecutor 0
#else
#define INCLUDE_ALL_HttpExecutor 1
#endif
#undef RESTRICT_HttpExecutor

#if !defined (RuKorincRuntimeNetworkHttpExecutor_) && (INCLUDE_ALL_HttpExecutor || defined(INCLUDE_RuKorincRuntimeNetworkHttpExecutor))
#define RuKorincRuntimeNetworkHttpExecutor_

@class IOSObjectArray;
@class RuKorincRuntimeNetworkHttpCallback;

@protocol RuKorincRuntimeNetworkHttpExecutor < JavaObject >

- (void)getMethodWithUrl:(NSString *)url
             WithHeaders:(IOSObjectArray *)headers
            WithCallback:(RuKorincRuntimeNetworkHttpCallback *)callback;

- (void)putMethodWithUrl:(NSString *)url
             WithContent:(NSString *)contents
             WithHeaders:(IOSObjectArray *)headers
            WithCallback:(RuKorincRuntimeNetworkHttpCallback *)callback;

@end

J2OBJC_EMPTY_STATIC_INIT(RuKorincRuntimeNetworkHttpExecutor)

J2OBJC_TYPE_LITERAL_HEADER(RuKorincRuntimeNetworkHttpExecutor)

#endif

#pragma pop_macro("INCLUDE_ALL_HttpExecutor")
