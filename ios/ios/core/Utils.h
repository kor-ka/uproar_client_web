//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: ../core/src/main/java/ru/korinc/utils/Utils.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_Utils")
#ifdef RESTRICT_Utils
#define INCLUDE_ALL_Utils 0
#else
#define INCLUDE_ALL_Utils 1
#endif
#undef RESTRICT_Utils

#if !defined (RuKorincUtilsUtils_) && (INCLUDE_ALL_Utils || defined(INCLUDE_RuKorincUtilsUtils))
#define RuKorincUtilsUtils_

@class JavaUtilArrayList;
@class RuKorincUtilsUtils_SearchResult;
@protocol JavaLangIterable;
@protocol RuKorincUtilsUtils_Action;
@protocol RuKorincUtilsUtils_Apply;
@protocol RuKorincUtilsUtils_ApplySearchResult;
@protocol RuKorincUtilsUtils_Matcher;

@interface RuKorincUtilsUtils : NSObject

#pragma mark Public

- (instancetype)init;

+ (void)applyWithJavaLangIterable:(id<JavaLangIterable>)source
     withRuKorincUtilsUtils_Apply:(id<RuKorincUtilsUtils_Apply>)action;

+ (void)applyWithJavaLangIterable:(id<JavaLangIterable>)source
   withRuKorincUtilsUtils_Matcher:(id<RuKorincUtilsUtils_Matcher>)matcher
     withRuKorincUtilsUtils_Apply:(id<RuKorincUtilsUtils_Apply>)action;

+ (void)applyWithJavaLangIterable:(id<JavaLangIterable>)source
   withRuKorincUtilsUtils_Matcher:(id<RuKorincUtilsUtils_Matcher>)matcher
   withRuKorincUtilsUtils_Matcher:(id<RuKorincUtilsUtils_Matcher>)breakOn
     withRuKorincUtilsUtils_Apply:(id<RuKorincUtilsUtils_Apply>)action;

+ (RuKorincUtilsUtils_SearchResult *)arrayListFirstWithJavaUtilArrayList:(JavaUtilArrayList *)source
                                          withRuKorincUtilsUtils_Matcher:(id<RuKorincUtilsUtils_Matcher>)condition
                                withRuKorincUtilsUtils_ApplySearchResult:(id<RuKorincUtilsUtils_ApplySearchResult>)ifFound;

+ (RuKorincUtilsUtils_SearchResult *)arrayListFirstWithJavaUtilArrayList:(JavaUtilArrayList *)source
                                          withRuKorincUtilsUtils_Matcher:(id<RuKorincUtilsUtils_Matcher>)condition
                                withRuKorincUtilsUtils_ApplySearchResult:(id<RuKorincUtilsUtils_ApplySearchResult>)ifFound
                                           withRuKorincUtilsUtils_Action:(id<RuKorincUtilsUtils_Action>)not_;

@end

J2OBJC_EMPTY_STATIC_INIT(RuKorincUtilsUtils)

FOUNDATION_EXPORT void RuKorincUtilsUtils_init(RuKorincUtilsUtils *self);

FOUNDATION_EXPORT RuKorincUtilsUtils *new_RuKorincUtilsUtils_init() NS_RETURNS_RETAINED;

FOUNDATION_EXPORT RuKorincUtilsUtils *create_RuKorincUtilsUtils_init();

FOUNDATION_EXPORT void RuKorincUtilsUtils_applyWithJavaLangIterable_withRuKorincUtilsUtils_Matcher_withRuKorincUtilsUtils_Apply_(id<JavaLangIterable> source, id<RuKorincUtilsUtils_Matcher> matcher, id<RuKorincUtilsUtils_Apply> action);

FOUNDATION_EXPORT void RuKorincUtilsUtils_applyWithJavaLangIterable_withRuKorincUtilsUtils_Apply_(id<JavaLangIterable> source, id<RuKorincUtilsUtils_Apply> action);

FOUNDATION_EXPORT void RuKorincUtilsUtils_applyWithJavaLangIterable_withRuKorincUtilsUtils_Matcher_withRuKorincUtilsUtils_Matcher_withRuKorincUtilsUtils_Apply_(id<JavaLangIterable> source, id<RuKorincUtilsUtils_Matcher> matcher, id<RuKorincUtilsUtils_Matcher> breakOn, id<RuKorincUtilsUtils_Apply> action);

FOUNDATION_EXPORT RuKorincUtilsUtils_SearchResult *RuKorincUtilsUtils_arrayListFirstWithJavaUtilArrayList_withRuKorincUtilsUtils_Matcher_withRuKorincUtilsUtils_ApplySearchResult_(JavaUtilArrayList *source, id<RuKorincUtilsUtils_Matcher> condition, id<RuKorincUtilsUtils_ApplySearchResult> ifFound);

FOUNDATION_EXPORT RuKorincUtilsUtils_SearchResult *RuKorincUtilsUtils_arrayListFirstWithJavaUtilArrayList_withRuKorincUtilsUtils_Matcher_withRuKorincUtilsUtils_ApplySearchResult_withRuKorincUtilsUtils_Action_(JavaUtilArrayList *source, id<RuKorincUtilsUtils_Matcher> condition, id<RuKorincUtilsUtils_ApplySearchResult> ifFound, id<RuKorincUtilsUtils_Action> not_);

J2OBJC_TYPE_LITERAL_HEADER(RuKorincUtilsUtils)

#endif

#if !defined (RuKorincUtilsUtils_SearchResult_) && (INCLUDE_ALL_Utils || defined(INCLUDE_RuKorincUtilsUtils_SearchResult))
#define RuKorincUtilsUtils_SearchResult_

@interface RuKorincUtilsUtils_SearchResult : NSObject

#pragma mark Public

- (instancetype)initWithInt:(jint)position
                     withId:(id)item;

- (id)getItem;

- (jint)getPosition;

// Disallowed inherited constructors, do not use.

- (instancetype)init NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(RuKorincUtilsUtils_SearchResult)

FOUNDATION_EXPORT void RuKorincUtilsUtils_SearchResult_initWithInt_withId_(RuKorincUtilsUtils_SearchResult *self, jint position, id item);

FOUNDATION_EXPORT RuKorincUtilsUtils_SearchResult *new_RuKorincUtilsUtils_SearchResult_initWithInt_withId_(jint position, id item) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT RuKorincUtilsUtils_SearchResult *create_RuKorincUtilsUtils_SearchResult_initWithInt_withId_(jint position, id item);

J2OBJC_TYPE_LITERAL_HEADER(RuKorincUtilsUtils_SearchResult)

#endif

#if !defined (RuKorincUtilsUtils_Matcher_) && (INCLUDE_ALL_Utils || defined(INCLUDE_RuKorincUtilsUtils_Matcher))
#define RuKorincUtilsUtils_Matcher_

@protocol RuKorincUtilsUtils_Matcher < JavaObject >

- (jboolean)matchWithId:(id)val;

@end

J2OBJC_EMPTY_STATIC_INIT(RuKorincUtilsUtils_Matcher)

J2OBJC_TYPE_LITERAL_HEADER(RuKorincUtilsUtils_Matcher)

#endif

#if !defined (RuKorincUtilsUtils_ApplySearchResult_) && (INCLUDE_ALL_Utils || defined(INCLUDE_RuKorincUtilsUtils_ApplySearchResult))
#define RuKorincUtilsUtils_ApplySearchResult_

@class RuKorincUtilsUtils_SearchResult;

@protocol RuKorincUtilsUtils_ApplySearchResult < JavaObject >

- (void)applyWithRuKorincUtilsUtils_SearchResult:(RuKorincUtilsUtils_SearchResult *)val;

@end

J2OBJC_EMPTY_STATIC_INIT(RuKorincUtilsUtils_ApplySearchResult)

J2OBJC_TYPE_LITERAL_HEADER(RuKorincUtilsUtils_ApplySearchResult)

#endif

#if !defined (RuKorincUtilsUtils_Apply_) && (INCLUDE_ALL_Utils || defined(INCLUDE_RuKorincUtilsUtils_Apply))
#define RuKorincUtilsUtils_Apply_

@protocol JavaUtilIterator;

@protocol RuKorincUtilsUtils_Apply < JavaObject >

- (void)applyWithJavaUtilIterator:(id<JavaUtilIterator>)iterator
                           withId:(id)val;

@end

J2OBJC_EMPTY_STATIC_INIT(RuKorincUtilsUtils_Apply)

J2OBJC_TYPE_LITERAL_HEADER(RuKorincUtilsUtils_Apply)

#endif

#if !defined (RuKorincUtilsUtils_Action_) && (INCLUDE_ALL_Utils || defined(INCLUDE_RuKorincUtilsUtils_Action))
#define RuKorincUtilsUtils_Action_

@protocol RuKorincUtilsUtils_Action < JavaObject >

- (void)call;

@end

J2OBJC_EMPTY_STATIC_INIT(RuKorincUtilsUtils_Action)

J2OBJC_TYPE_LITERAL_HEADER(RuKorincUtilsUtils_Action)

#endif

#pragma pop_macro("INCLUDE_ALL_Utils")
