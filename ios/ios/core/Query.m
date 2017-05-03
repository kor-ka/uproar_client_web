//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: ../core/src/main/java/ru/korinc/core/entity/Query.java
//

#include "J2ObjC_source.h"
#include "Query.h"
#include "java/io/UnsupportedEncodingException.h"
#include "java/net/URLEncoder.h"
#include "java/util/ArrayList.h"

@interface RuKorincCoreEntityQuery () {
 @public
  jint page_;
  NSString *title_;
  JavaUtilArrayList *oldResults_;
}

@end

J2OBJC_FIELD_SETTER(RuKorincCoreEntityQuery, title_, NSString *)
J2OBJC_FIELD_SETTER(RuKorincCoreEntityQuery, oldResults_, JavaUtilArrayList *)

@implementation RuKorincCoreEntityQuery

- (instancetype)initWithInt:(jint)page
               withNSString:(NSString *)title {
  RuKorincCoreEntityQuery_initWithInt_withNSString_(self, page, title);
  return self;
}

- (JavaUtilArrayList *)getOldResults {
  return oldResults_;
}

- (RuKorincCoreEntityQuery *)setOldResultsWithJavaUtilArrayList:(JavaUtilArrayList *)oldResults {
  self->oldResults_ = oldResults;
  return self;
}

- (jint)getPage {
  return page_;
}

- (RuKorincCoreEntityQuery *)setPageWithInt:(jint)page {
  self->page_ = page;
  return self;
}

- (NSString *)getTitle {
  return title_;
}

- (RuKorincCoreEntityQuery *)setTitleWithNSString:(NSString *)title {
  self->title_ = title;
  return self;
}

- (NSString *)description {
  @try {
    return JreStrcat("$$$I", @"http://www.omdbapi.com/?s=", JavaNetURLEncoder_encodeWithNSString_withNSString_(title_, @"UTF-8"), @"&page=", page_);
  }
  @catch (JavaIoUnsupportedEncodingException *e) {
    return @"";
  }
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x1, -1, 0, -1, -1, -1, -1 },
    { NULL, "LJavaUtilArrayList;", 0x1, -1, -1, -1, 1, -1, -1 },
    { NULL, "LRuKorincCoreEntityQuery;", 0x1, 2, 3, -1, 4, -1, -1 },
    { NULL, "I", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "LRuKorincCoreEntityQuery;", 0x1, 5, 6, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "LRuKorincCoreEntityQuery;", 0x1, 7, 8, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, 9, -1, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  methods[0].selector = @selector(initWithInt:withNSString:);
  methods[1].selector = @selector(getOldResults);
  methods[2].selector = @selector(setOldResultsWithJavaUtilArrayList:);
  methods[3].selector = @selector(getPage);
  methods[4].selector = @selector(setPageWithInt:);
  methods[5].selector = @selector(getTitle);
  methods[6].selector = @selector(setTitleWithNSString:);
  methods[7].selector = @selector(description);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "page_", "I", .constantValue.asLong = 0, 0x2, -1, -1, -1, -1 },
    { "title_", "LNSString;", .constantValue.asLong = 0, 0x2, -1, -1, -1, -1 },
    { "oldResults_", "LJavaUtilArrayList;", .constantValue.asLong = 0, 0x2, -1, -1, 10, -1 },
  };
  static const void *ptrTable[] = { "ILNSString;", "()Ljava/util/ArrayList<Lru/korinc/core/entity/SearchEntity;>;", "setOldResults", "LJavaUtilArrayList;", "(Ljava/util/ArrayList<Lru/korinc/core/entity/SearchEntity;>;)Lru/korinc/core/entity/Query;", "setPage", "I", "setTitle", "LNSString;", "toString", "Ljava/util/ArrayList<Lru/korinc/core/entity/SearchEntity;>;" };
  static const J2ObjcClassInfo _RuKorincCoreEntityQuery = { "Query", "ru.korinc.core.entity", ptrTable, methods, fields, 7, 0x1, 8, 3, -1, -1, -1, -1, -1 };
  return &_RuKorincCoreEntityQuery;
}

@end

void RuKorincCoreEntityQuery_initWithInt_withNSString_(RuKorincCoreEntityQuery *self, jint page, NSString *title) {
  NSObject_init(self);
  self->page_ = 1;
  self->title_ = @"";
  self->oldResults_ = new_JavaUtilArrayList_init();
  self->page_ = page;
  self->title_ = title;
}

RuKorincCoreEntityQuery *new_RuKorincCoreEntityQuery_initWithInt_withNSString_(jint page, NSString *title) {
  J2OBJC_NEW_IMPL(RuKorincCoreEntityQuery, initWithInt_withNSString_, page, title)
}

RuKorincCoreEntityQuery *create_RuKorincCoreEntityQuery_initWithInt_withNSString_(jint page, NSString *title) {
  J2OBJC_CREATE_IMPL(RuKorincCoreEntityQuery, initWithInt_withNSString_, page, title)
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(RuKorincCoreEntityQuery)
