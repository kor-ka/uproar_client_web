//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: ../core/src/main/java/google/j2objc/annotations/Property.java
//

#include "IOSClass.h"
#include "IOSObjectArray.h"
#include "J2ObjC_source.h"
#include "Property.h"
#include "java/lang/annotation/Annotation.h"
#include "java/lang/annotation/ElementType.h"
#include "java/lang/annotation/Retention.h"
#include "java/lang/annotation/RetentionPolicy.h"
#include "java/lang/annotation/Target.h"

@interface GoogleJ2objcAnnotationsProperty : NSObject

@end

__attribute__((unused)) static IOSObjectArray *GoogleJ2objcAnnotationsProperty__Annotations$0();

@implementation GoogleJ2objcAnnotationsProperty

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, "LNSString;", 0x401, -1, -1, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  methods[0].selector = @selector(value);
  #pragma clang diagnostic pop
  static const void *ptrTable[] = { (void *)&GoogleJ2objcAnnotationsProperty__Annotations$0 };
  static const J2ObjcClassInfo _GoogleJ2objcAnnotationsProperty = { "Property", "google.j2objc.annotations", ptrTable, methods, NULL, 7, 0x2609, 1, 0, -1, -1, -1, -1, 0 };
  return &_GoogleJ2objcAnnotationsProperty;
}

@end

IOSObjectArray *GoogleJ2objcAnnotationsProperty__Annotations$0() {
  return [IOSObjectArray arrayWithObjects:(id[]){ create_JavaLangAnnotationRetention(JreLoadEnum(JavaLangAnnotationRetentionPolicy, SOURCE)), create_JavaLangAnnotationTarget([IOSObjectArray arrayWithObjects:(id[]){ JreLoadEnum(JavaLangAnnotationElementType, FIELD) } count:1 type:JavaLangAnnotationElementType_class_()]) } count:2 type:JavaLangAnnotationAnnotation_class_()];
}

J2OBJC_INTERFACE_TYPE_LITERAL_SOURCE(GoogleJ2objcAnnotationsProperty)
