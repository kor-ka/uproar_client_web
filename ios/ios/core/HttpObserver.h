//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: ../core/src/main/java/ru/korinc/runtime/network/HttpObserver.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_HttpObserver")
#ifdef RESTRICT_HttpObserver
#define INCLUDE_ALL_HttpObserver 0
#else
#define INCLUDE_ALL_HttpObserver 1
#endif
#undef RESTRICT_HttpObserver

#if !defined (RuKorincRuntimeNetworkHttpObserver_) && (INCLUDE_ALL_HttpObserver || defined(INCLUDE_RuKorincRuntimeNetworkHttpObserver))
#define RuKorincRuntimeNetworkHttpObserver_

@class IOSObjectArray;
@protocol RuKorincRuntimeRxObservableWrapper;

@interface RuKorincRuntimeNetworkHttpObserver : NSObject

#pragma mark Public

- (instancetype)init;

+ (id<RuKorincRuntimeRxObservableWrapper>)getWithNSString:(NSString *)url
                                        withNSStringArray:(IOSObjectArray *)headers;

+ (id<RuKorincRuntimeRxObservableWrapper>)putWithNSString:(NSString *)url
                                             withNSString:(NSString *)data
                                        withNSStringArray:(IOSObjectArray *)headers;

@end

J2OBJC_EMPTY_STATIC_INIT(RuKorincRuntimeNetworkHttpObserver)

FOUNDATION_EXPORT void RuKorincRuntimeNetworkHttpObserver_init(RuKorincRuntimeNetworkHttpObserver *self);

FOUNDATION_EXPORT RuKorincRuntimeNetworkHttpObserver *new_RuKorincRuntimeNetworkHttpObserver_init() NS_RETURNS_RETAINED;

FOUNDATION_EXPORT RuKorincRuntimeNetworkHttpObserver *create_RuKorincRuntimeNetworkHttpObserver_init();

FOUNDATION_EXPORT id<RuKorincRuntimeRxObservableWrapper> RuKorincRuntimeNetworkHttpObserver_getWithNSString_withNSStringArray_(NSString *url, IOSObjectArray *headers);

FOUNDATION_EXPORT id<RuKorincRuntimeRxObservableWrapper> RuKorincRuntimeNetworkHttpObserver_putWithNSString_withNSString_withNSStringArray_(NSString *url, NSString *data, IOSObjectArray *headers);

J2OBJC_TYPE_LITERAL_HEADER(RuKorincRuntimeNetworkHttpObserver)

#endif

#pragma pop_macro("INCLUDE_ALL_HttpObserver")
