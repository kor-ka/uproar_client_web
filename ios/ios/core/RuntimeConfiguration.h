//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: ../core/src/main/java/ru/korinc/runtime/RuntimeConfiguration.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_RuntimeConfiguration")
#ifdef RESTRICT_RuntimeConfiguration
#define INCLUDE_ALL_RuntimeConfiguration 0
#else
#define INCLUDE_ALL_RuntimeConfiguration 1
#endif
#undef RESTRICT_RuntimeConfiguration

#if !defined (RuKorincRuntimeRuntimeConfiguration_) && (INCLUDE_ALL_RuntimeConfiguration || defined(INCLUDE_RuKorincRuntimeRuntimeConfiguration))
#define RuKorincRuntimeRuntimeConfiguration_

@protocol RuKorincRuntimeJsonJsonProvider;
@protocol RuKorincRuntimeLoggingLogProvider;
@protocol RuKorincRuntimeNetworkHttpProvider;
@protocol RuKorincRuntimeRxRxProvider;
@protocol RuKorincRuntimeTimeoutTimeoutProvider;

@interface RuKorincRuntimeRuntimeConfiguration : NSObject

#pragma mark Public

- (instancetype)initWithRuKorincRuntimeRxRxProvider:(id<RuKorincRuntimeRxRxProvider>)rxProvider
          withRuKorincRuntimeTimeoutTimeoutProvider:(id<RuKorincRuntimeTimeoutTimeoutProvider>)timeoutProvider
              withRuKorincRuntimeLoggingLogProvider:(id<RuKorincRuntimeLoggingLogProvider>)logProvider
             withRuKorincRuntimeNetworkHttpProvider:(id<RuKorincRuntimeNetworkHttpProvider>)httpProvider
                withRuKorincRuntimeJsonJsonProvider:(id<RuKorincRuntimeJsonJsonProvider>)jsonProvider;

+ (id<RuKorincRuntimeJsonJsonProvider>)getJson;

- (id<RuKorincRuntimeLoggingLogProvider>)getLogProvider;

- (id<RuKorincRuntimeRxRxProvider>)getRxProvider;

- (id<RuKorincRuntimeTimeoutTimeoutProvider>)getTimeoutProvider;

@end

J2OBJC_EMPTY_STATIC_INIT(RuKorincRuntimeRuntimeConfiguration)

inline id<RuKorincRuntimeRxRxProvider> RuKorincRuntimeRuntimeConfiguration_get_rxProvider();
inline id<RuKorincRuntimeRxRxProvider> RuKorincRuntimeRuntimeConfiguration_set_rxProvider(id<RuKorincRuntimeRxRxProvider> value);
/*! INTERNAL ONLY - Use accessor function from above. */
FOUNDATION_EXPORT id<RuKorincRuntimeRxRxProvider> RuKorincRuntimeRuntimeConfiguration_rxProvider;
J2OBJC_STATIC_FIELD_OBJ(RuKorincRuntimeRuntimeConfiguration, rxProvider, id<RuKorincRuntimeRxRxProvider>)

inline id<RuKorincRuntimeTimeoutTimeoutProvider> RuKorincRuntimeRuntimeConfiguration_get_timeoutProvider();
inline id<RuKorincRuntimeTimeoutTimeoutProvider> RuKorincRuntimeRuntimeConfiguration_set_timeoutProvider(id<RuKorincRuntimeTimeoutTimeoutProvider> value);
/*! INTERNAL ONLY - Use accessor function from above. */
FOUNDATION_EXPORT id<RuKorincRuntimeTimeoutTimeoutProvider> RuKorincRuntimeRuntimeConfiguration_timeoutProvider;
J2OBJC_STATIC_FIELD_OBJ(RuKorincRuntimeRuntimeConfiguration, timeoutProvider, id<RuKorincRuntimeTimeoutTimeoutProvider>)

inline id<RuKorincRuntimeLoggingLogProvider> RuKorincRuntimeRuntimeConfiguration_get_log();
inline id<RuKorincRuntimeLoggingLogProvider> RuKorincRuntimeRuntimeConfiguration_set_log(id<RuKorincRuntimeLoggingLogProvider> value);
/*! INTERNAL ONLY - Use accessor function from above. */
FOUNDATION_EXPORT id<RuKorincRuntimeLoggingLogProvider> RuKorincRuntimeRuntimeConfiguration_log;
J2OBJC_STATIC_FIELD_OBJ(RuKorincRuntimeRuntimeConfiguration, log, id<RuKorincRuntimeLoggingLogProvider>)

inline id<RuKorincRuntimeNetworkHttpProvider> RuKorincRuntimeRuntimeConfiguration_get_http();
inline id<RuKorincRuntimeNetworkHttpProvider> RuKorincRuntimeRuntimeConfiguration_set_http(id<RuKorincRuntimeNetworkHttpProvider> value);
/*! INTERNAL ONLY - Use accessor function from above. */
FOUNDATION_EXPORT id<RuKorincRuntimeNetworkHttpProvider> RuKorincRuntimeRuntimeConfiguration_http;
J2OBJC_STATIC_FIELD_OBJ(RuKorincRuntimeRuntimeConfiguration, http, id<RuKorincRuntimeNetworkHttpProvider>)

inline id<RuKorincRuntimeJsonJsonProvider> RuKorincRuntimeRuntimeConfiguration_get_json();
inline id<RuKorincRuntimeJsonJsonProvider> RuKorincRuntimeRuntimeConfiguration_set_json(id<RuKorincRuntimeJsonJsonProvider> value);
/*! INTERNAL ONLY - Use accessor function from above. */
FOUNDATION_EXPORT id<RuKorincRuntimeJsonJsonProvider> RuKorincRuntimeRuntimeConfiguration_json;
J2OBJC_STATIC_FIELD_OBJ(RuKorincRuntimeRuntimeConfiguration, json, id<RuKorincRuntimeJsonJsonProvider>)

FOUNDATION_EXPORT void RuKorincRuntimeRuntimeConfiguration_initWithRuKorincRuntimeRxRxProvider_withRuKorincRuntimeTimeoutTimeoutProvider_withRuKorincRuntimeLoggingLogProvider_withRuKorincRuntimeNetworkHttpProvider_withRuKorincRuntimeJsonJsonProvider_(RuKorincRuntimeRuntimeConfiguration *self, id<RuKorincRuntimeRxRxProvider> rxProvider, id<RuKorincRuntimeTimeoutTimeoutProvider> timeoutProvider, id<RuKorincRuntimeLoggingLogProvider> logProvider, id<RuKorincRuntimeNetworkHttpProvider> httpProvider, id<RuKorincRuntimeJsonJsonProvider> jsonProvider);

FOUNDATION_EXPORT RuKorincRuntimeRuntimeConfiguration *new_RuKorincRuntimeRuntimeConfiguration_initWithRuKorincRuntimeRxRxProvider_withRuKorincRuntimeTimeoutTimeoutProvider_withRuKorincRuntimeLoggingLogProvider_withRuKorincRuntimeNetworkHttpProvider_withRuKorincRuntimeJsonJsonProvider_(id<RuKorincRuntimeRxRxProvider> rxProvider, id<RuKorincRuntimeTimeoutTimeoutProvider> timeoutProvider, id<RuKorincRuntimeLoggingLogProvider> logProvider, id<RuKorincRuntimeNetworkHttpProvider> httpProvider, id<RuKorincRuntimeJsonJsonProvider> jsonProvider) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT RuKorincRuntimeRuntimeConfiguration *create_RuKorincRuntimeRuntimeConfiguration_initWithRuKorincRuntimeRxRxProvider_withRuKorincRuntimeTimeoutTimeoutProvider_withRuKorincRuntimeLoggingLogProvider_withRuKorincRuntimeNetworkHttpProvider_withRuKorincRuntimeJsonJsonProvider_(id<RuKorincRuntimeRxRxProvider> rxProvider, id<RuKorincRuntimeTimeoutTimeoutProvider> timeoutProvider, id<RuKorincRuntimeLoggingLogProvider> logProvider, id<RuKorincRuntimeNetworkHttpProvider> httpProvider, id<RuKorincRuntimeJsonJsonProvider> jsonProvider);

FOUNDATION_EXPORT id<RuKorincRuntimeJsonJsonProvider> RuKorincRuntimeRuntimeConfiguration_getJson();

J2OBJC_TYPE_LITERAL_HEADER(RuKorincRuntimeRuntimeConfiguration)

#endif

#pragma pop_macro("INCLUDE_ALL_RuntimeConfiguration")
