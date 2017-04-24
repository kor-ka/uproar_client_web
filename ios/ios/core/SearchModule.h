//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: ../core/src/main/java/ru/korinc/core/modules/SearchModule.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_SearchModule")
#ifdef RESTRICT_SearchModule
#define INCLUDE_ALL_SearchModule 0
#else
#define INCLUDE_ALL_SearchModule 1
#endif
#undef RESTRICT_SearchModule

#if !defined (RuKorincCoreModulesSearchModule_) && (INCLUDE_ALL_SearchModule || defined(INCLUDE_RuKorincCoreModulesSearchModule))
#define RuKorincCoreModulesSearchModule_

#define RESTRICT_ModuleBase 1
#define INCLUDE_RuKorincCoreModulesModuleBase 1
#include "ModuleBase.h"

@class RuKorincCoreModulesModulesContext;
@protocol RuKorincRuntimeRxObservableWrapper;

@interface RuKorincCoreModulesSearchModule : RuKorincCoreModulesModuleBase

#pragma mark Public

- (instancetype)initWithRuKorincCoreModulesModulesContext:(RuKorincCoreModulesModulesContext *)context;

- (id<RuKorincRuntimeRxObservableWrapper>)getSearchResults;

- (void)queryWithNSString:(NSString *)query;

- (void)run;

@end

J2OBJC_EMPTY_STATIC_INIT(RuKorincCoreModulesSearchModule)

FOUNDATION_EXPORT void RuKorincCoreModulesSearchModule_initWithRuKorincCoreModulesModulesContext_(RuKorincCoreModulesSearchModule *self, RuKorincCoreModulesModulesContext *context);

FOUNDATION_EXPORT RuKorincCoreModulesSearchModule *new_RuKorincCoreModulesSearchModule_initWithRuKorincCoreModulesModulesContext_(RuKorincCoreModulesModulesContext *context) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT RuKorincCoreModulesSearchModule *create_RuKorincCoreModulesSearchModule_initWithRuKorincCoreModulesModulesContext_(RuKorincCoreModulesModulesContext *context);

J2OBJC_TYPE_LITERAL_HEADER(RuKorincCoreModulesSearchModule)

#endif

#pragma pop_macro("INCLUDE_ALL_SearchModule")
