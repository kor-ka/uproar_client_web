//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: ../core/src/main/java/ru/korinc/core/modules/SearchModule.java
//

#include "BSWrapper.h"
#include "BackgroundSchedulerWrapper.h"
#include "Consumer.h"
#include "DisposableWrapper.h"
#include "Function.h"
#include "HttpObserver.h"
#include "HttpResponse.h"
#include "IOSClass.h"
#include "IOSObjectArray.h"
#include "J2ObjC_source.h"
#include "JsonArrayWrapper.h"
#include "JsonObjectWrapper.h"
#include "JsonProvider.h"
#include "Load.h"
#include "LogProvider.h"
#include "ModuleBase.h"
#include "ModulesContext.h"
#include "Movie.h"
#include "ObservableWrapper.h"
#include "Query.h"
#include "QueryList.h"
#include "RuntimeConfiguration.h"
#include "RxProvider.h"
#include "SearchModule.h"
#include "Touple.h"
#include "java/util/ArrayList.h"

#pragma clang diagnostic ignored "-Wprotocol"

@interface RuKorincCoreModulesSearchModule () {
 @public
  id<RuKorincRuntimeRxSubjectBSWrapper> input_;
  id<RuKorincRuntimeRxSubjectBSWrapper> searchResults_;
  jint generation_;
  RuKorincCoreEntityQuery *lastQuery_;
}

@end

J2OBJC_FIELD_SETTER(RuKorincCoreModulesSearchModule, input_, id<RuKorincRuntimeRxSubjectBSWrapper>)
J2OBJC_FIELD_SETTER(RuKorincCoreModulesSearchModule, searchResults_, id<RuKorincRuntimeRxSubjectBSWrapper>)
J2OBJC_FIELD_SETTER(RuKorincCoreModulesSearchModule, lastQuery_, RuKorincCoreEntityQuery *)

@interface RuKorincCoreModulesSearchModule_$Lambda$2 : NSObject < RuKorincRuntimeRxFunction > {
 @public
  RuKorincCoreEntityQuery *val$s_;
}

- (id)applyWithId:(RuKorincRuntimeNetworkHttpResponse *)httpResponse;

@end

J2OBJC_EMPTY_STATIC_INIT(RuKorincCoreModulesSearchModule_$Lambda$2)

__attribute__((unused)) static void RuKorincCoreModulesSearchModule_$Lambda$2_initWithRuKorincCoreEntityQuery_(RuKorincCoreModulesSearchModule_$Lambda$2 *self, RuKorincCoreEntityQuery *capture$0);

__attribute__((unused)) static RuKorincCoreModulesSearchModule_$Lambda$2 *new_RuKorincCoreModulesSearchModule_$Lambda$2_initWithRuKorincCoreEntityQuery_(RuKorincCoreEntityQuery *capture$0) NS_RETURNS_RETAINED;

__attribute__((unused)) static RuKorincCoreModulesSearchModule_$Lambda$2 *create_RuKorincCoreModulesSearchModule_$Lambda$2_initWithRuKorincCoreEntityQuery_(RuKorincCoreEntityQuery *capture$0);

@interface RuKorincCoreModulesSearchModule_$Lambda$3 : NSObject < RuKorincRuntimeRxFunction >

- (id)applyWithId:(RuKorincCoreUtilsTouple *)respAndQuery;

@end

J2OBJC_STATIC_INIT(RuKorincCoreModulesSearchModule_$Lambda$3)

inline RuKorincCoreModulesSearchModule_$Lambda$3 *RuKorincCoreModulesSearchModule_$Lambda$3_get_instance();
static RuKorincCoreModulesSearchModule_$Lambda$3 *RuKorincCoreModulesSearchModule_$Lambda$3_instance;
J2OBJC_STATIC_FIELD_OBJ_FINAL(RuKorincCoreModulesSearchModule_$Lambda$3, instance, RuKorincCoreModulesSearchModule_$Lambda$3 *)

__attribute__((unused)) static void RuKorincCoreModulesSearchModule_$Lambda$3_init(RuKorincCoreModulesSearchModule_$Lambda$3 *self);

__attribute__((unused)) static RuKorincCoreModulesSearchModule_$Lambda$3 *new_RuKorincCoreModulesSearchModule_$Lambda$3_init() NS_RETURNS_RETAINED;

__attribute__((unused)) static RuKorincCoreModulesSearchModule_$Lambda$3 *create_RuKorincCoreModulesSearchModule_$Lambda$3_init();

@interface RuKorincCoreModulesSearchModule_$Lambda$1 : NSObject < RuKorincRuntimeRxFunction > {
 @public
  RuKorincCoreModulesSearchModule *this$0_;
}

- (id)applyWithId:(RuKorincCoreEntityQuery *)s;

@end

J2OBJC_EMPTY_STATIC_INIT(RuKorincCoreModulesSearchModule_$Lambda$1)

__attribute__((unused)) static void RuKorincCoreModulesSearchModule_$Lambda$1_initWithRuKorincCoreModulesSearchModule_(RuKorincCoreModulesSearchModule_$Lambda$1 *self, RuKorincCoreModulesSearchModule *outer$);

__attribute__((unused)) static RuKorincCoreModulesSearchModule_$Lambda$1 *new_RuKorincCoreModulesSearchModule_$Lambda$1_initWithRuKorincCoreModulesSearchModule_(RuKorincCoreModulesSearchModule *outer$) NS_RETURNS_RETAINED;

__attribute__((unused)) static RuKorincCoreModulesSearchModule_$Lambda$1 *create_RuKorincCoreModulesSearchModule_$Lambda$1_initWithRuKorincCoreModulesSearchModule_(RuKorincCoreModulesSearchModule *outer$);

@interface RuKorincCoreModulesSearchModule_$Lambda$4 : NSObject < RuKorincRuntimeRxConsumer > {
 @public
  RuKorincCoreModulesSearchModule *this$0_;
}

- (void)acceptWithId:(RuKorincCoreModulesQueryList *)res;

@end

J2OBJC_EMPTY_STATIC_INIT(RuKorincCoreModulesSearchModule_$Lambda$4)

__attribute__((unused)) static void RuKorincCoreModulesSearchModule_$Lambda$4_initWithRuKorincCoreModulesSearchModule_(RuKorincCoreModulesSearchModule_$Lambda$4 *self, RuKorincCoreModulesSearchModule *outer$);

__attribute__((unused)) static RuKorincCoreModulesSearchModule_$Lambda$4 *new_RuKorincCoreModulesSearchModule_$Lambda$4_initWithRuKorincCoreModulesSearchModule_(RuKorincCoreModulesSearchModule *outer$) NS_RETURNS_RETAINED;

__attribute__((unused)) static RuKorincCoreModulesSearchModule_$Lambda$4 *create_RuKorincCoreModulesSearchModule_$Lambda$4_initWithRuKorincCoreModulesSearchModule_(RuKorincCoreModulesSearchModule *outer$);

@implementation RuKorincCoreModulesSearchModule

- (instancetype)initWithRuKorincCoreModulesModulesContext:(RuKorincCoreModulesModulesContext *)context {
  RuKorincCoreModulesSearchModule_initWithRuKorincCoreModulesModulesContext_(self, context);
  return self;
}

- (void)run {
  RuKorincCoreModulesQueryList *defaultValue = new_RuKorincCoreModulesQueryList_init();
  [defaultValue addWithId:new_RuKorincCoreEntityMovie_initWithNSString_withNSString_(@"search some movies!", @"")];
  searchResults_ = [((id<RuKorincRuntimeRxRxProvider>) nil_chk(mRxProvider_)) bsWithId:defaultValue];
}

- (void)queryWithNSString:(NSString *)query {
  [self queryWithRuKorincCoreEntityQuery:[new_RuKorincCoreEntityQuery_initWithInt_withNSString_(1, query) setGenerationWithInt:++generation_]];
}

- (void)queryWithRuKorincCoreEntityQuery:(RuKorincCoreEntityQuery *)query {
  [((id<RuKorincRuntimeLoggingLogProvider>) nil_chk(JreLoadStatic(RuKorincRuntimeRuntimeConfiguration, log))) dWithNSString:@"SearchModule" withNSString:JreStrcat("$$", @"new query:", [((RuKorincCoreEntityQuery *) nil_chk(query)) description])];
  if (lastQuery_ != nil && [query getPage] > 1 && ![((NSString *) nil_chk([query getTitle])) java_hasSuffix:[((RuKorincCoreEntityQuery *) nil_chk(lastQuery_)) getTitle]]) {
    return;
  }
  if (lastQuery_ == nil || ![((NSString *) nil_chk([lastQuery_ getTitle])) isEqual:[query getTitle]]) {
    RuKorincCoreModulesQueryList *empty = new_RuKorincCoreModulesQueryList_init();
    [empty addWithId:new_RuKorincCoreEntityMovie_initWithNSString_withNSString_(@"Loading...", @"")];
    [((id<RuKorincRuntimeRxSubjectBSWrapper>) nil_chk(searchResults_)) onNextWithId:empty];
  }
  lastQuery_ = query;
  if (input_ == nil) {
    [((id<RuKorincRuntimeLoggingLogProvider>) nil_chk(JreLoadStatic(RuKorincRuntimeRuntimeConfiguration, log))) dWithNSString:@"SearchModule" withNSString:@"create bs"];
    input_ = [((id<RuKorincRuntimeRxRxProvider>) nil_chk(mRxProvider_)) bsWithId:query];
    [((id<RuKorincRuntimeLoggingLogProvider>) nil_chk(JreLoadStatic(RuKorincRuntimeRuntimeConfiguration, log))) dWithNSString:@"SearchModule" withNSString:@"bs created"];
    [((id<RuKorincRuntimeLoggingLogProvider>) nil_chk(JreLoadStatic(RuKorincRuntimeRuntimeConfiguration, log))) dWithNSString:@"SearchModule" withNSString:@"switchOnNext"];
    id<RuKorincRuntimeRxObservableWrapper> httpResponseObservableWrapper = [((id<RuKorincRuntimeRxSubjectBSWrapper>) nil_chk(input_)) switchOnNextWithSources:[((id<RuKorincRuntimeRxObservableWrapper>) nil_chk([input_ throttleLastWithWindowMillis:500])) mapWithFunc:new_RuKorincCoreModulesSearchModule_$Lambda$1_initWithRuKorincCoreModulesSearchModule_(self)]];
    [((id<RuKorincRuntimeLoggingLogProvider>) nil_chk(JreLoadStatic(RuKorincRuntimeRuntimeConfiguration, log))) dWithNSString:@"SearchModule" withNSString:@"switchOnNext created"];
    (void) [((id<RuKorincRuntimeRxObservableWrapper>) nil_chk([((id<RuKorincRuntimeRxObservableWrapper>) nil_chk(httpResponseObservableWrapper)) subscribeOnWithScheduler:[((id<RuKorincRuntimeRxRxProvider>) nil_chk(mRxProvider_)) scheduler]])) subscribeWithConsumer:new_RuKorincCoreModulesSearchModule_$Lambda$4_initWithRuKorincCoreModulesSearchModule_(self)];
  }
  else {
    [((id<RuKorincRuntimeLoggingLogProvider>) nil_chk(JreLoadStatic(RuKorincRuntimeRuntimeConfiguration, log))) dWithNSString:@"SearchModule" withNSString:JreStrcat("$$", @"new input:", [query description])];
    [((id<RuKorincRuntimeRxSubjectBSWrapper>) nil_chk(input_)) onNextWithId:query];
  }
}

- (id<RuKorincRuntimeRxObservableWrapper>)getSearchResults {
  return searchResults_;
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x1, -1, 0, -1, -1, -1, -1 },
    { NULL, "V", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 1, 2, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 1, 3, -1, -1, -1, -1 },
    { NULL, "LRuKorincRuntimeRxObservableWrapper;", 0x1, -1, -1, -1, 4, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  methods[0].selector = @selector(initWithRuKorincCoreModulesModulesContext:);
  methods[1].selector = @selector(run);
  methods[2].selector = @selector(queryWithNSString:);
  methods[3].selector = @selector(queryWithRuKorincCoreEntityQuery:);
  methods[4].selector = @selector(getSearchResults);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "input_", "LRuKorincRuntimeRxSubjectBSWrapper;", .constantValue.asLong = 0, 0x2, -1, -1, 5, -1 },
    { "searchResults_", "LRuKorincRuntimeRxSubjectBSWrapper;", .constantValue.asLong = 0, 0x2, -1, -1, 6, -1 },
    { "generation_", "I", .constantValue.asLong = 0, 0x2, -1, -1, -1, -1 },
    { "lastQuery_", "LRuKorincCoreEntityQuery;", .constantValue.asLong = 0, 0x2, -1, -1, -1, -1 },
  };
  static const void *ptrTable[] = { "LRuKorincCoreModulesModulesContext;", "query", "LNSString;", "LRuKorincCoreEntityQuery;", "()Lru/korinc/runtime/rx/ObservableWrapper<Lru/korinc/core/modules/QueryList;>;", "Lru/korinc/runtime/rx/subject/BSWrapper<Lru/korinc/core/entity/Query;>;", "Lru/korinc/runtime/rx/subject/BSWrapper<Lru/korinc/core/modules/QueryList;>;" };
  static const J2ObjcClassInfo _RuKorincCoreModulesSearchModule = { "SearchModule", "ru.korinc.core.modules", ptrTable, methods, fields, 7, 0x1, 5, 4, -1, -1, -1, -1, -1 };
  return &_RuKorincCoreModulesSearchModule;
}

@end

void RuKorincCoreModulesSearchModule_initWithRuKorincCoreModulesModulesContext_(RuKorincCoreModulesSearchModule *self, RuKorincCoreModulesModulesContext *context) {
  RuKorincCoreModulesModuleBase_initWithRuKorincCoreModulesModulesContext_(self, context);
  self->generation_ = 0;
}

RuKorincCoreModulesSearchModule *new_RuKorincCoreModulesSearchModule_initWithRuKorincCoreModulesModulesContext_(RuKorincCoreModulesModulesContext *context) {
  J2OBJC_NEW_IMPL(RuKorincCoreModulesSearchModule, initWithRuKorincCoreModulesModulesContext_, context)
}

RuKorincCoreModulesSearchModule *create_RuKorincCoreModulesSearchModule_initWithRuKorincCoreModulesModulesContext_(RuKorincCoreModulesModulesContext *context) {
  J2OBJC_CREATE_IMPL(RuKorincCoreModulesSearchModule, initWithRuKorincCoreModulesModulesContext_, context)
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(RuKorincCoreModulesSearchModule)

@implementation RuKorincCoreModulesSearchModule_$Lambda$2

- (id)applyWithId:(RuKorincRuntimeNetworkHttpResponse *)httpResponse {
  return new_RuKorincCoreUtilsTouple_initWithId_withId_(val$s_, httpResponse);
}

@end

void RuKorincCoreModulesSearchModule_$Lambda$2_initWithRuKorincCoreEntityQuery_(RuKorincCoreModulesSearchModule_$Lambda$2 *self, RuKorincCoreEntityQuery *capture$0) {
  self->val$s_ = capture$0;
  NSObject_init(self);
}

RuKorincCoreModulesSearchModule_$Lambda$2 *new_RuKorincCoreModulesSearchModule_$Lambda$2_initWithRuKorincCoreEntityQuery_(RuKorincCoreEntityQuery *capture$0) {
  J2OBJC_NEW_IMPL(RuKorincCoreModulesSearchModule_$Lambda$2, initWithRuKorincCoreEntityQuery_, capture$0)
}

RuKorincCoreModulesSearchModule_$Lambda$2 *create_RuKorincCoreModulesSearchModule_$Lambda$2_initWithRuKorincCoreEntityQuery_(RuKorincCoreEntityQuery *capture$0) {
  J2OBJC_CREATE_IMPL(RuKorincCoreModulesSearchModule_$Lambda$2, initWithRuKorincCoreEntityQuery_, capture$0)
}

J2OBJC_INITIALIZED_DEFN(RuKorincCoreModulesSearchModule_$Lambda$3)

@implementation RuKorincCoreModulesSearchModule_$Lambda$3

- (id)applyWithId:(RuKorincCoreUtilsTouple *)respAndQuery {
  RuKorincCoreModulesQueryList *res = new_RuKorincCoreModulesQueryList_initWithRuKorincCoreEntityQuery_([((RuKorincCoreUtilsTouple *) nil_chk(respAndQuery)) getA]);
  id<RuKorincRuntimeJsonJsonArrayWrapper> resp = [((id<RuKorincRuntimeJsonJsonObjectWrapper>) nil_chk([((id<RuKorincRuntimeJsonJsonProvider>) nil_chk(JreLoadStatic(RuKorincRuntimeRuntimeConfiguration, json))) getJsonWithNSString:[((RuKorincRuntimeNetworkHttpResponse *) nil_chk([respAndQuery getB])) getContent]])) getJsonArrayWithNSString:@"Search"];
  [((id<RuKorincRuntimeLoggingLogProvider>) nil_chk(JreLoadStatic(RuKorincRuntimeRuntimeConfiguration, log))) dWithNSString:@"SearchModule" withNSString:JreStrcat("$@", @"resp:", resp)];
  if (resp == nil) {
    [res addAllWithJavaUtilCollection:[((RuKorincCoreEntityQuery *) nil_chk([respAndQuery getA])) getOldResults]];
    if ([res size] == 0) {
      [res addWithId:new_RuKorincCoreEntityMovie_initWithNSString_withNSString_(@"Movie not found :'(", @"")];
    }
    return res;
  }
  id<RuKorincRuntimeJsonJsonObjectWrapper> movieJson;
  for (jint i = 0; i < [resp length]; i++) {
    RuKorincCoreEntityMovie *movieInfo;
    movieJson = [resp getJsonObjectWrapperWithInt:i];
    NSString *subtitle = JreStrcat("$$$", [((id<RuKorincRuntimeJsonJsonObjectWrapper>) nil_chk(movieJson)) getStringWithNSString:@"Year"], @" | ", [movieJson getStringWithNSString:@"Type"]);
    movieInfo = new_RuKorincCoreEntityMovie_initWithNSString_withNSString_([movieJson getStringWithNSString:@"Title"], subtitle);
    [res addWithId:movieInfo];
  }
  [res addAllWithInt:0 withJavaUtilCollection:[((RuKorincCoreEntityQuery *) nil_chk([respAndQuery getA])) getOldResults]];
  RuKorincCoreEntityQuery *q = [respAndQuery getA];
  (void) [((RuKorincCoreEntityQuery *) nil_chk(q)) setPageWithInt:[((RuKorincCoreEntityQuery *) nil_chk([respAndQuery getA])) getPage] + 1];
  JavaUtilArrayList *oldResults = new_JavaUtilArrayList_initWithJavaUtilCollection_(res);
  (void) [q setOldResultsWithJavaUtilArrayList:oldResults];
  [res addWithId:new_RuKorincCoreEntityLoad_initWithRuKorincCoreEntityQuery_(q)];
  return res;
}

+ (void)initialize {
  if (self == [RuKorincCoreModulesSearchModule_$Lambda$3 class]) {
    RuKorincCoreModulesSearchModule_$Lambda$3_instance = new_RuKorincCoreModulesSearchModule_$Lambda$3_init();
    J2OBJC_SET_INITIALIZED(RuKorincCoreModulesSearchModule_$Lambda$3)
  }
}

@end

void RuKorincCoreModulesSearchModule_$Lambda$3_init(RuKorincCoreModulesSearchModule_$Lambda$3 *self) {
  NSObject_init(self);
}

RuKorincCoreModulesSearchModule_$Lambda$3 *new_RuKorincCoreModulesSearchModule_$Lambda$3_init() {
  J2OBJC_NEW_IMPL(RuKorincCoreModulesSearchModule_$Lambda$3, init)
}

RuKorincCoreModulesSearchModule_$Lambda$3 *create_RuKorincCoreModulesSearchModule_$Lambda$3_init() {
  J2OBJC_CREATE_IMPL(RuKorincCoreModulesSearchModule_$Lambda$3, init)
}

@implementation RuKorincCoreModulesSearchModule_$Lambda$1

- (id)applyWithId:(RuKorincCoreEntityQuery *)s {
  return [((id<RuKorincRuntimeRxObservableWrapper>) nil_chk([((id<RuKorincRuntimeRxObservableWrapper>) nil_chk([((id<RuKorincRuntimeRxObservableWrapper>) nil_chk(RuKorincRuntimeNetworkHttpObserver_getWithNSString_withNSStringArray_([((RuKorincCoreEntityQuery *) nil_chk(s)) description], [IOSObjectArray newArrayWithObjects:(id[]){  } count:0 type:NSString_class_()]))) mapWithFunc:new_RuKorincCoreModulesSearchModule_$Lambda$2_initWithRuKorincCoreEntityQuery_(s)])) mapWithFunc:JreLoadStatic(RuKorincCoreModulesSearchModule_$Lambda$3, instance)])) subscribeOnWithScheduler:[((id<RuKorincRuntimeRxRxProvider>) nil_chk(this$0_->mRxProvider_)) scheduler]];
}

@end

void RuKorincCoreModulesSearchModule_$Lambda$1_initWithRuKorincCoreModulesSearchModule_(RuKorincCoreModulesSearchModule_$Lambda$1 *self, RuKorincCoreModulesSearchModule *outer$) {
  self->this$0_ = outer$;
  NSObject_init(self);
}

RuKorincCoreModulesSearchModule_$Lambda$1 *new_RuKorincCoreModulesSearchModule_$Lambda$1_initWithRuKorincCoreModulesSearchModule_(RuKorincCoreModulesSearchModule *outer$) {
  J2OBJC_NEW_IMPL(RuKorincCoreModulesSearchModule_$Lambda$1, initWithRuKorincCoreModulesSearchModule_, outer$)
}

RuKorincCoreModulesSearchModule_$Lambda$1 *create_RuKorincCoreModulesSearchModule_$Lambda$1_initWithRuKorincCoreModulesSearchModule_(RuKorincCoreModulesSearchModule *outer$) {
  J2OBJC_CREATE_IMPL(RuKorincCoreModulesSearchModule_$Lambda$1, initWithRuKorincCoreModulesSearchModule_, outer$)
}

@implementation RuKorincCoreModulesSearchModule_$Lambda$4

- (void)acceptWithId:(RuKorincCoreModulesQueryList *)res {
  [((id<RuKorincRuntimeRxSubjectBSWrapper>) nil_chk(this$0_->searchResults_)) onNextWithId:res];
}

@end

void RuKorincCoreModulesSearchModule_$Lambda$4_initWithRuKorincCoreModulesSearchModule_(RuKorincCoreModulesSearchModule_$Lambda$4 *self, RuKorincCoreModulesSearchModule *outer$) {
  self->this$0_ = outer$;
  NSObject_init(self);
}

RuKorincCoreModulesSearchModule_$Lambda$4 *new_RuKorincCoreModulesSearchModule_$Lambda$4_initWithRuKorincCoreModulesSearchModule_(RuKorincCoreModulesSearchModule *outer$) {
  J2OBJC_NEW_IMPL(RuKorincCoreModulesSearchModule_$Lambda$4, initWithRuKorincCoreModulesSearchModule_, outer$)
}

RuKorincCoreModulesSearchModule_$Lambda$4 *create_RuKorincCoreModulesSearchModule_$Lambda$4_initWithRuKorincCoreModulesSearchModule_(RuKorincCoreModulesSearchModule *outer$) {
  J2OBJC_CREATE_IMPL(RuKorincCoreModulesSearchModule_$Lambda$4, initWithRuKorincCoreModulesSearchModule_, outer$)
}
