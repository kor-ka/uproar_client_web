//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: ../core/src/main/java/ru/korinc/runtime/network/HttpObserver.java
//

#include "Emitter.h"
#include "Function.h"
#include "HttpExecutor.h"
#include "HttpObserver.h"
#include "HttpProvider.h"
#include "HttpResponse.h"
#include "IOSObjectArray.h"
#include "J2ObjC_source.h"
#include "LogProvider.h"
#include "ObservableOnSubscribe.h"
#include "ObservableWrapper.h"
#include "RuntimeConfiguration.h"
#include "RxProvider.h"
#include "java/lang/Exception.h"

#pragma clang diagnostic ignored "-Wprotocol"

@interface RuKorincRuntimeNetworkHttpObserver_$Lambda$1 : NSObject < RuKorincRuntimeRxObservableOnSubscribe > {
 @public
  NSString *val$url_;
  IOSObjectArray *val$headers_;
}

- (void)subscribeWithRuKorincRuntimeRxEmitter:(id<RuKorincRuntimeRxEmitter>)e;

@end

J2OBJC_EMPTY_STATIC_INIT(RuKorincRuntimeNetworkHttpObserver_$Lambda$1)

__attribute__((unused)) static void RuKorincRuntimeNetworkHttpObserver_$Lambda$1_initWithNSString_withNSStringArray_(RuKorincRuntimeNetworkHttpObserver_$Lambda$1 *self, NSString *capture$0, IOSObjectArray *capture$1);

__attribute__((unused)) static RuKorincRuntimeNetworkHttpObserver_$Lambda$1 *new_RuKorincRuntimeNetworkHttpObserver_$Lambda$1_initWithNSString_withNSStringArray_(NSString *capture$0, IOSObjectArray *capture$1) NS_RETURNS_RETAINED;

__attribute__((unused)) static RuKorincRuntimeNetworkHttpObserver_$Lambda$1 *create_RuKorincRuntimeNetworkHttpObserver_$Lambda$1_initWithNSString_withNSStringArray_(NSString *capture$0, IOSObjectArray *capture$1);

@interface RuKorincRuntimeNetworkHttpObserver_$Lambda$2 : NSObject < RuKorincRuntimeRxFunction >

- (id)applyWithId:(id<RuKorincRuntimeRxObservableWrapper>)throwableObservableWrapper;

@end

J2OBJC_STATIC_INIT(RuKorincRuntimeNetworkHttpObserver_$Lambda$2)

inline RuKorincRuntimeNetworkHttpObserver_$Lambda$2 *RuKorincRuntimeNetworkHttpObserver_$Lambda$2_get_instance();
static RuKorincRuntimeNetworkHttpObserver_$Lambda$2 *RuKorincRuntimeNetworkHttpObserver_$Lambda$2_instance;
J2OBJC_STATIC_FIELD_OBJ_FINAL(RuKorincRuntimeNetworkHttpObserver_$Lambda$2, instance, RuKorincRuntimeNetworkHttpObserver_$Lambda$2 *)

__attribute__((unused)) static void RuKorincRuntimeNetworkHttpObserver_$Lambda$2_init(RuKorincRuntimeNetworkHttpObserver_$Lambda$2 *self);

__attribute__((unused)) static RuKorincRuntimeNetworkHttpObserver_$Lambda$2 *new_RuKorincRuntimeNetworkHttpObserver_$Lambda$2_init() NS_RETURNS_RETAINED;

__attribute__((unused)) static RuKorincRuntimeNetworkHttpObserver_$Lambda$2 *create_RuKorincRuntimeNetworkHttpObserver_$Lambda$2_init();

@interface RuKorincRuntimeNetworkHttpObserver_$Lambda$3 : NSObject < RuKorincRuntimeRxObservableOnSubscribe > {
 @public
  NSString *val$url_;
  NSString *val$data_;
  IOSObjectArray *val$headers_;
}

- (void)subscribeWithRuKorincRuntimeRxEmitter:(id<RuKorincRuntimeRxEmitter>)e;

@end

J2OBJC_EMPTY_STATIC_INIT(RuKorincRuntimeNetworkHttpObserver_$Lambda$3)

__attribute__((unused)) static void RuKorincRuntimeNetworkHttpObserver_$Lambda$3_initWithNSString_withNSString_withNSStringArray_(RuKorincRuntimeNetworkHttpObserver_$Lambda$3 *self, NSString *capture$0, NSString *capture$1, IOSObjectArray *capture$2);

__attribute__((unused)) static RuKorincRuntimeNetworkHttpObserver_$Lambda$3 *new_RuKorincRuntimeNetworkHttpObserver_$Lambda$3_initWithNSString_withNSString_withNSStringArray_(NSString *capture$0, NSString *capture$1, IOSObjectArray *capture$2) NS_RETURNS_RETAINED;

__attribute__((unused)) static RuKorincRuntimeNetworkHttpObserver_$Lambda$3 *create_RuKorincRuntimeNetworkHttpObserver_$Lambda$3_initWithNSString_withNSString_withNSStringArray_(NSString *capture$0, NSString *capture$1, IOSObjectArray *capture$2);

@interface RuKorincRuntimeNetworkHttpObserver_$Lambda$4 : NSObject < RuKorincRuntimeRxFunction >

- (id)applyWithId:(id<RuKorincRuntimeRxObservableWrapper>)throwableObservableWrapper;

@end

J2OBJC_STATIC_INIT(RuKorincRuntimeNetworkHttpObserver_$Lambda$4)

inline RuKorincRuntimeNetworkHttpObserver_$Lambda$4 *RuKorincRuntimeNetworkHttpObserver_$Lambda$4_get_instance();
static RuKorincRuntimeNetworkHttpObserver_$Lambda$4 *RuKorincRuntimeNetworkHttpObserver_$Lambda$4_instance;
J2OBJC_STATIC_FIELD_OBJ_FINAL(RuKorincRuntimeNetworkHttpObserver_$Lambda$4, instance, RuKorincRuntimeNetworkHttpObserver_$Lambda$4 *)

__attribute__((unused)) static void RuKorincRuntimeNetworkHttpObserver_$Lambda$4_init(RuKorincRuntimeNetworkHttpObserver_$Lambda$4 *self);

__attribute__((unused)) static RuKorincRuntimeNetworkHttpObserver_$Lambda$4 *new_RuKorincRuntimeNetworkHttpObserver_$Lambda$4_init() NS_RETURNS_RETAINED;

__attribute__((unused)) static RuKorincRuntimeNetworkHttpObserver_$Lambda$4 *create_RuKorincRuntimeNetworkHttpObserver_$Lambda$4_init();

@implementation RuKorincRuntimeNetworkHttpObserver

J2OBJC_IGNORE_DESIGNATED_BEGIN
- (instancetype)init {
  RuKorincRuntimeNetworkHttpObserver_init(self);
  return self;
}
J2OBJC_IGNORE_DESIGNATED_END

+ (id<RuKorincRuntimeRxObservableWrapper>)getWithNSString:(NSString *)url
                                        withNSStringArray:(IOSObjectArray *)headers {
  return RuKorincRuntimeNetworkHttpObserver_getWithNSString_withNSStringArray_(url, headers);
}

+ (id<RuKorincRuntimeRxObservableWrapper>)putWithNSString:(NSString *)url
                                             withNSString:(NSString *)data
                                        withNSStringArray:(IOSObjectArray *)headers {
  return RuKorincRuntimeNetworkHttpObserver_putWithNSString_withNSString_withNSStringArray_(url, data, headers);
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "LRuKorincRuntimeRxObservableWrapper;", 0x89, 0, 1, -1, 2, -1, -1 },
    { NULL, "LRuKorincRuntimeRxObservableWrapper;", 0x89, 3, 4, -1, 5, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  methods[0].selector = @selector(init);
  methods[1].selector = @selector(getWithNSString:withNSStringArray:);
  methods[2].selector = @selector(putWithNSString:withNSString:withNSStringArray:);
  #pragma clang diagnostic pop
  static const void *ptrTable[] = { "get", "LNSString;[LNSString;", "(Ljava/lang/String;[Ljava/lang/String;)Lru/korinc/runtime/rx/ObservableWrapper<Lru/korinc/runtime/network/HttpResponse;>;", "put", "LNSString;LNSString;[LNSString;", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Lru/korinc/runtime/rx/ObservableWrapper<Lru/korinc/runtime/network/HttpResponse;>;" };
  static const J2ObjcClassInfo _RuKorincRuntimeNetworkHttpObserver = { "HttpObserver", "ru.korinc.runtime.network", ptrTable, methods, NULL, 7, 0x1, 3, 0, -1, -1, -1, -1, -1 };
  return &_RuKorincRuntimeNetworkHttpObserver;
}

@end

void RuKorincRuntimeNetworkHttpObserver_init(RuKorincRuntimeNetworkHttpObserver *self) {
  NSObject_init(self);
}

RuKorincRuntimeNetworkHttpObserver *new_RuKorincRuntimeNetworkHttpObserver_init() {
  J2OBJC_NEW_IMPL(RuKorincRuntimeNetworkHttpObserver, init)
}

RuKorincRuntimeNetworkHttpObserver *create_RuKorincRuntimeNetworkHttpObserver_init() {
  J2OBJC_CREATE_IMPL(RuKorincRuntimeNetworkHttpObserver, init)
}

id<RuKorincRuntimeRxObservableWrapper> RuKorincRuntimeNetworkHttpObserver_getWithNSString_withNSStringArray_(NSString *url, IOSObjectArray *headers) {
  RuKorincRuntimeNetworkHttpObserver_initialize();
  return [((id<RuKorincRuntimeRxObservableWrapper>) nil_chk([((id<RuKorincRuntimeRxRxProvider>) nil_chk(JreLoadStatic(RuKorincRuntimeRuntimeConfiguration, rxProvider))) observableCreateWithSource:new_RuKorincRuntimeNetworkHttpObserver_$Lambda$1_initWithNSString_withNSStringArray_(url, headers)])) retryWhenWithWindowMillis:JreLoadStatic(RuKorincRuntimeNetworkHttpObserver_$Lambda$2, instance)];
}

id<RuKorincRuntimeRxObservableWrapper> RuKorincRuntimeNetworkHttpObserver_putWithNSString_withNSString_withNSStringArray_(NSString *url, NSString *data, IOSObjectArray *headers) {
  RuKorincRuntimeNetworkHttpObserver_initialize();
  return [((id<RuKorincRuntimeRxObservableWrapper>) nil_chk([((id<RuKorincRuntimeRxRxProvider>) nil_chk(JreLoadStatic(RuKorincRuntimeRuntimeConfiguration, rxProvider))) observableCreateWithSource:new_RuKorincRuntimeNetworkHttpObserver_$Lambda$3_initWithNSString_withNSString_withNSStringArray_(url, data, headers)])) retryWhenWithWindowMillis:JreLoadStatic(RuKorincRuntimeNetworkHttpObserver_$Lambda$4, instance)];
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(RuKorincRuntimeNetworkHttpObserver)

@implementation RuKorincRuntimeNetworkHttpObserver_$Lambda$1

- (void)subscribeWithRuKorincRuntimeRxEmitter:(id<RuKorincRuntimeRxEmitter>)e {
  @try {
    RuKorincRuntimeNetworkHttpResponse *response = [((id<RuKorincRuntimeNetworkHttpExecutor>) nil_chk([((id<RuKorincRuntimeNetworkHttpProvider>) nil_chk(JreLoadStatic(RuKorincRuntimeRuntimeConfiguration, http))) getExecutor])) getMethodWithUrl:val$url_ WithHeaders:val$headers_];
    if ([((RuKorincRuntimeNetworkHttpResponse *) nil_chk(response)) getCode] / 100 == 2) {
      [((id<RuKorincRuntimeRxEmitter>) nil_chk(e)) onNextWithId:response];
      [e onComplete];
    }
    else {
      [((id<RuKorincRuntimeRxEmitter>) nil_chk(e)) onErrorWithNSException:new_JavaLangException_initWithNSString_(JreStrcat("$$$I", @"URL: ", val$url_, @"\nHttp error code", [response getCode]))];
    }
  }
  @catch (JavaLangException *ex) {
    [((id<RuKorincRuntimeLoggingLogProvider>) nil_chk(JreLoadStatic(RuKorincRuntimeRuntimeConfiguration, log))) eWithNSException:ex];
    [((id<RuKorincRuntimeRxEmitter>) nil_chk(e)) onErrorWithNSException:ex];
  }
}

@end

void RuKorincRuntimeNetworkHttpObserver_$Lambda$1_initWithNSString_withNSStringArray_(RuKorincRuntimeNetworkHttpObserver_$Lambda$1 *self, NSString *capture$0, IOSObjectArray *capture$1) {
  self->val$url_ = capture$0;
  self->val$headers_ = capture$1;
  NSObject_init(self);
}

RuKorincRuntimeNetworkHttpObserver_$Lambda$1 *new_RuKorincRuntimeNetworkHttpObserver_$Lambda$1_initWithNSString_withNSStringArray_(NSString *capture$0, IOSObjectArray *capture$1) {
  J2OBJC_NEW_IMPL(RuKorincRuntimeNetworkHttpObserver_$Lambda$1, initWithNSString_withNSStringArray_, capture$0, capture$1)
}

RuKorincRuntimeNetworkHttpObserver_$Lambda$1 *create_RuKorincRuntimeNetworkHttpObserver_$Lambda$1_initWithNSString_withNSStringArray_(NSString *capture$0, IOSObjectArray *capture$1) {
  J2OBJC_CREATE_IMPL(RuKorincRuntimeNetworkHttpObserver_$Lambda$1, initWithNSString_withNSStringArray_, capture$0, capture$1)
}

J2OBJC_INITIALIZED_DEFN(RuKorincRuntimeNetworkHttpObserver_$Lambda$2)

@implementation RuKorincRuntimeNetworkHttpObserver_$Lambda$2

- (id)applyWithId:(id<RuKorincRuntimeRxObservableWrapper>)throwableObservableWrapper {
  return [((id<RuKorincRuntimeRxObservableWrapper>) nil_chk(throwableObservableWrapper)) delayWithWindowMillis:5000];
}

+ (void)initialize {
  if (self == [RuKorincRuntimeNetworkHttpObserver_$Lambda$2 class]) {
    RuKorincRuntimeNetworkHttpObserver_$Lambda$2_instance = new_RuKorincRuntimeNetworkHttpObserver_$Lambda$2_init();
    J2OBJC_SET_INITIALIZED(RuKorincRuntimeNetworkHttpObserver_$Lambda$2)
  }
}

@end

void RuKorincRuntimeNetworkHttpObserver_$Lambda$2_init(RuKorincRuntimeNetworkHttpObserver_$Lambda$2 *self) {
  NSObject_init(self);
}

RuKorincRuntimeNetworkHttpObserver_$Lambda$2 *new_RuKorincRuntimeNetworkHttpObserver_$Lambda$2_init() {
  J2OBJC_NEW_IMPL(RuKorincRuntimeNetworkHttpObserver_$Lambda$2, init)
}

RuKorincRuntimeNetworkHttpObserver_$Lambda$2 *create_RuKorincRuntimeNetworkHttpObserver_$Lambda$2_init() {
  J2OBJC_CREATE_IMPL(RuKorincRuntimeNetworkHttpObserver_$Lambda$2, init)
}

@implementation RuKorincRuntimeNetworkHttpObserver_$Lambda$3

- (void)subscribeWithRuKorincRuntimeRxEmitter:(id<RuKorincRuntimeRxEmitter>)e {
  @try {
    RuKorincRuntimeNetworkHttpResponse *response = [((id<RuKorincRuntimeNetworkHttpExecutor>) nil_chk([((id<RuKorincRuntimeNetworkHttpProvider>) nil_chk(JreLoadStatic(RuKorincRuntimeRuntimeConfiguration, http))) getExecutor])) putMethodWithUrl:val$url_ WithContent:val$data_ WithHeaders:val$headers_];
    if ([((RuKorincRuntimeNetworkHttpResponse *) nil_chk(response)) getCode] / 100 == 2) {
      [((id<RuKorincRuntimeRxEmitter>) nil_chk(e)) onNextWithId:response];
      [e onComplete];
    }
    else {
      [((id<RuKorincRuntimeRxEmitter>) nil_chk(e)) onErrorWithNSException:new_JavaLangException_initWithNSString_(JreStrcat("$$$I", @"URL: ", val$url_, @"\nHttp error code", [response getCode]))];
    }
  }
  @catch (JavaLangException *ex) {
    [((id<RuKorincRuntimeLoggingLogProvider>) nil_chk(JreLoadStatic(RuKorincRuntimeRuntimeConfiguration, log))) eWithNSException:ex];
    [((id<RuKorincRuntimeRxEmitter>) nil_chk(e)) onErrorWithNSException:ex];
  }
}

@end

void RuKorincRuntimeNetworkHttpObserver_$Lambda$3_initWithNSString_withNSString_withNSStringArray_(RuKorincRuntimeNetworkHttpObserver_$Lambda$3 *self, NSString *capture$0, NSString *capture$1, IOSObjectArray *capture$2) {
  self->val$url_ = capture$0;
  self->val$data_ = capture$1;
  self->val$headers_ = capture$2;
  NSObject_init(self);
}

RuKorincRuntimeNetworkHttpObserver_$Lambda$3 *new_RuKorincRuntimeNetworkHttpObserver_$Lambda$3_initWithNSString_withNSString_withNSStringArray_(NSString *capture$0, NSString *capture$1, IOSObjectArray *capture$2) {
  J2OBJC_NEW_IMPL(RuKorincRuntimeNetworkHttpObserver_$Lambda$3, initWithNSString_withNSString_withNSStringArray_, capture$0, capture$1, capture$2)
}

RuKorincRuntimeNetworkHttpObserver_$Lambda$3 *create_RuKorincRuntimeNetworkHttpObserver_$Lambda$3_initWithNSString_withNSString_withNSStringArray_(NSString *capture$0, NSString *capture$1, IOSObjectArray *capture$2) {
  J2OBJC_CREATE_IMPL(RuKorincRuntimeNetworkHttpObserver_$Lambda$3, initWithNSString_withNSString_withNSStringArray_, capture$0, capture$1, capture$2)
}

J2OBJC_INITIALIZED_DEFN(RuKorincRuntimeNetworkHttpObserver_$Lambda$4)

@implementation RuKorincRuntimeNetworkHttpObserver_$Lambda$4

- (id)applyWithId:(id<RuKorincRuntimeRxObservableWrapper>)throwableObservableWrapper {
  return [((id<RuKorincRuntimeRxObservableWrapper>) nil_chk(throwableObservableWrapper)) delayWithWindowMillis:5000];
}

+ (void)initialize {
  if (self == [RuKorincRuntimeNetworkHttpObserver_$Lambda$4 class]) {
    RuKorincRuntimeNetworkHttpObserver_$Lambda$4_instance = new_RuKorincRuntimeNetworkHttpObserver_$Lambda$4_init();
    J2OBJC_SET_INITIALIZED(RuKorincRuntimeNetworkHttpObserver_$Lambda$4)
  }
}

@end

void RuKorincRuntimeNetworkHttpObserver_$Lambda$4_init(RuKorincRuntimeNetworkHttpObserver_$Lambda$4 *self) {
  NSObject_init(self);
}

RuKorincRuntimeNetworkHttpObserver_$Lambda$4 *new_RuKorincRuntimeNetworkHttpObserver_$Lambda$4_init() {
  J2OBJC_NEW_IMPL(RuKorincRuntimeNetworkHttpObserver_$Lambda$4, init)
}

RuKorincRuntimeNetworkHttpObserver_$Lambda$4 *create_RuKorincRuntimeNetworkHttpObserver_$Lambda$4_init() {
  J2OBJC_CREATE_IMPL(RuKorincRuntimeNetworkHttpObserver_$Lambda$4, init)
}
