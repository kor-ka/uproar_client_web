//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: ../core/src/main/java/ru/korinc/core/modules/PlayerModule.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_PlayerModule")
#ifdef RESTRICT_PlayerModule
#define INCLUDE_ALL_PlayerModule 0
#else
#define INCLUDE_ALL_PlayerModule 1
#endif
#undef RESTRICT_PlayerModule

#if !defined (RuKorincCoreModulesPlayerModule_) && (INCLUDE_ALL_PlayerModule || defined(INCLUDE_RuKorincCoreModulesPlayerModule))
#define RuKorincCoreModulesPlayerModule_

#define RESTRICT_ModuleBase 1
#define INCLUDE_RuKorincCoreModulesModuleBase 1
#include "ModuleBase.h"

@class RuKorincCoreModulesModulesContext;

@interface RuKorincCoreModulesPlayerModule : RuKorincCoreModulesModuleBase

#pragma mark Public

- (instancetype)initWithRuKorincCoreModulesModulesContext:(RuKorincCoreModulesModulesContext *)context;

- (void)run;

@end

J2OBJC_EMPTY_STATIC_INIT(RuKorincCoreModulesPlayerModule)

FOUNDATION_EXPORT void RuKorincCoreModulesPlayerModule_initWithRuKorincCoreModulesModulesContext_(RuKorincCoreModulesPlayerModule *self, RuKorincCoreModulesModulesContext *context);

FOUNDATION_EXPORT RuKorincCoreModulesPlayerModule *new_RuKorincCoreModulesPlayerModule_initWithRuKorincCoreModulesModulesContext_(RuKorincCoreModulesModulesContext *context) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT RuKorincCoreModulesPlayerModule *create_RuKorincCoreModulesPlayerModule_initWithRuKorincCoreModulesModulesContext_(RuKorincCoreModulesModulesContext *context);

J2OBJC_TYPE_LITERAL_HEADER(RuKorincCoreModulesPlayerModule)

#endif

#pragma pop_macro("INCLUDE_ALL_PlayerModule")
