//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: ../core/src/main/java/ru/korinc/runtime/timeout/TimeoutProvider.java
//

#include "J2ObjC_source.h"
#include "TimeoutProvider.h"

@interface RuKorincRuntimeTimeoutTimeoutProvider : NSObject

@end

@implementation RuKorincRuntimeTimeoutTimeoutProvider

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, "V", 0x401, 0, 1, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  methods[0].selector = @selector(sleepWithInt:);
  #pragma clang diagnostic pop
  static const void *ptrTable[] = { "sleep", "I" };
  static const J2ObjcClassInfo _RuKorincRuntimeTimeoutTimeoutProvider = { "TimeoutProvider", "ru.korinc.runtime.timeout", ptrTable, methods, NULL, 7, 0x609, 1, 0, -1, -1, -1, -1, -1 };
  return &_RuKorincRuntimeTimeoutTimeoutProvider;
}

@end

J2OBJC_INTERFACE_TYPE_LITERAL_SOURCE(RuKorincRuntimeTimeoutTimeoutProvider)
