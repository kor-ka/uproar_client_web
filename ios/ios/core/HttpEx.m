//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: ../core/src/main/java/ru/korinc/runtime/network/HttpEx.java
//

#include "HttpEx.h"
#include "J2ObjC_source.h"

@interface RuKorincRuntimeNetworkHttpEx : NSObject

@end

@implementation RuKorincRuntimeNetworkHttpEx

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, "LNSString;", 0x401, 0, 1, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x401, 2, 3, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  methods[0].selector = @selector(getWithNSString:);
  methods[1].selector = @selector(putWithNSString:withJavaLangByteArray:);
  #pragma clang diagnostic pop
  static const void *ptrTable[] = { "get", "LNSString;", "put", "LNSString;[LJavaLangByte;" };
  static const J2ObjcClassInfo _RuKorincRuntimeNetworkHttpEx = { "HttpEx", "ru.korinc.runtime.network", ptrTable, methods, NULL, 7, 0x609, 2, 0, -1, -1, -1, -1, -1 };
  return &_RuKorincRuntimeNetworkHttpEx;
}

@end

J2OBJC_INTERFACE_TYPE_LITERAL_SOURCE(RuKorincRuntimeNetworkHttpEx)
