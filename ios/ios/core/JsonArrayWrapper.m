//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: ../runtime/src/main/java/ru/korinc/runtime/json/JsonArrayWrapper.java
//

#include "J2ObjC_source.h"
#include "JsonArrayWrapper.h"

@interface RuKorincRuntimeJsonJsonArrayWrapper : NSObject

@end

@implementation RuKorincRuntimeJsonJsonArrayWrapper

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, "I", 0x401, -1, -1, -1, -1, -1, -1 },
    { NULL, "LRuKorincRuntimeJsonJsonObjectWrapper;", 0x401, 0, 1, -1, -1, -1, -1 },
    { NULL, "LRuKorincRuntimeJsonJsonArrayWrapper;", 0x401, 2, 1, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x401, 3, 1, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  methods[0].selector = @selector(length);
  methods[1].selector = @selector(getJsonObjectWrapperWithInt:);
  methods[2].selector = @selector(getJsonArrayWrapperWithInt:);
  methods[3].selector = @selector(getStringWithInt:);
  #pragma clang diagnostic pop
  static const void *ptrTable[] = { "getJsonObjectWrapper", "I", "getJsonArrayWrapper", "getString" };
  static const J2ObjcClassInfo _RuKorincRuntimeJsonJsonArrayWrapper = { "JsonArrayWrapper", "ru.korinc.runtime.json", ptrTable, methods, NULL, 7, 0x609, 4, 0, -1, -1, -1, -1, -1 };
  return &_RuKorincRuntimeJsonJsonArrayWrapper;
}

@end

J2OBJC_INTERFACE_TYPE_LITERAL_SOURCE(RuKorincRuntimeJsonJsonArrayWrapper)
