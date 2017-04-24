//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: ../core/src/main/java/ru/korinc/runtime/RuntimeConfiguration.java
//

#include "HttpProvider.h"
#include "J2ObjC_source.h"
#include "JsonProvider.h"
#include "LogProvider.h"
#include "RuntimeConfiguration.h"
#include "RxProvider.h"
#include "TimeoutProvider.h"

id<RuKorincRuntimeRxRxProvider> RuKorincRuntimeRuntimeConfiguration_rxProvider;
id<RuKorincRuntimeTimeoutTimeoutProvider> RuKorincRuntimeRuntimeConfiguration_timeoutProvider;
id<RuKorincRuntimeLoggingLogProvider> RuKorincRuntimeRuntimeConfiguration_log;
id<RuKorincRuntimeNetworkHttpProvider> RuKorincRuntimeRuntimeConfiguration_http;
id<RuKorincRuntimeJsonJsonProvider> RuKorincRuntimeRuntimeConfiguration_json;

@implementation RuKorincRuntimeRuntimeConfiguration

- (instancetype)initWithRuKorincRuntimeRxRxProvider:(id<RuKorincRuntimeRxRxProvider>)rxProvider
          withRuKorincRuntimeTimeoutTimeoutProvider:(id<RuKorincRuntimeTimeoutTimeoutProvider>)timeoutProvider
              withRuKorincRuntimeLoggingLogProvider:(id<RuKorincRuntimeLoggingLogProvider>)logProvider
             withRuKorincRuntimeNetworkHttpProvider:(id<RuKorincRuntimeNetworkHttpProvider>)httpProvider
                withRuKorincRuntimeJsonJsonProvider:(id<RuKorincRuntimeJsonJsonProvider>)jsonProvider {
  RuKorincRuntimeRuntimeConfiguration_initWithRuKorincRuntimeRxRxProvider_withRuKorincRuntimeTimeoutTimeoutProvider_withRuKorincRuntimeLoggingLogProvider_withRuKorincRuntimeNetworkHttpProvider_withRuKorincRuntimeJsonJsonProvider_(self, rxProvider, timeoutProvider, logProvider, httpProvider, jsonProvider);
  return self;
}

- (id<RuKorincRuntimeRxRxProvider>)getRxProvider {
  return RuKorincRuntimeRuntimeConfiguration_rxProvider;
}

- (id<RuKorincRuntimeTimeoutTimeoutProvider>)getTimeoutProvider {
  return RuKorincRuntimeRuntimeConfiguration_timeoutProvider;
}

- (id<RuKorincRuntimeLoggingLogProvider>)getLogProvider {
  return RuKorincRuntimeRuntimeConfiguration_log;
}

+ (id<RuKorincRuntimeJsonJsonProvider>)getJson {
  return RuKorincRuntimeRuntimeConfiguration_getJson();
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x1, -1, 0, -1, -1, -1, -1 },
    { NULL, "LRuKorincRuntimeRxRxProvider;", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "LRuKorincRuntimeTimeoutTimeoutProvider;", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "LRuKorincRuntimeLoggingLogProvider;", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "LRuKorincRuntimeJsonJsonProvider;", 0x9, -1, -1, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  methods[0].selector = @selector(initWithRuKorincRuntimeRxRxProvider:withRuKorincRuntimeTimeoutTimeoutProvider:withRuKorincRuntimeLoggingLogProvider:withRuKorincRuntimeNetworkHttpProvider:withRuKorincRuntimeJsonJsonProvider:);
  methods[1].selector = @selector(getRxProvider);
  methods[2].selector = @selector(getTimeoutProvider);
  methods[3].selector = @selector(getLogProvider);
  methods[4].selector = @selector(getJson);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "rxProvider", "LRuKorincRuntimeRxRxProvider;", .constantValue.asLong = 0, 0x9, -1, 1, -1, -1 },
    { "timeoutProvider", "LRuKorincRuntimeTimeoutTimeoutProvider;", .constantValue.asLong = 0, 0x9, -1, 2, -1, -1 },
    { "log", "LRuKorincRuntimeLoggingLogProvider;", .constantValue.asLong = 0, 0x9, -1, 3, -1, -1 },
    { "http", "LRuKorincRuntimeNetworkHttpProvider;", .constantValue.asLong = 0, 0x9, -1, 4, -1, -1 },
    { "json", "LRuKorincRuntimeJsonJsonProvider;", .constantValue.asLong = 0, 0x9, -1, 5, -1, -1 },
  };
  static const void *ptrTable[] = { "LRuKorincRuntimeRxRxProvider;LRuKorincRuntimeTimeoutTimeoutProvider;LRuKorincRuntimeLoggingLogProvider;LRuKorincRuntimeNetworkHttpProvider;LRuKorincRuntimeJsonJsonProvider;", &RuKorincRuntimeRuntimeConfiguration_rxProvider, &RuKorincRuntimeRuntimeConfiguration_timeoutProvider, &RuKorincRuntimeRuntimeConfiguration_log, &RuKorincRuntimeRuntimeConfiguration_http, &RuKorincRuntimeRuntimeConfiguration_json };
  static const J2ObjcClassInfo _RuKorincRuntimeRuntimeConfiguration = { "RuntimeConfiguration", "ru.korinc.runtime", ptrTable, methods, fields, 7, 0x1, 5, 5, -1, -1, -1, -1, -1 };
  return &_RuKorincRuntimeRuntimeConfiguration;
}

@end

void RuKorincRuntimeRuntimeConfiguration_initWithRuKorincRuntimeRxRxProvider_withRuKorincRuntimeTimeoutTimeoutProvider_withRuKorincRuntimeLoggingLogProvider_withRuKorincRuntimeNetworkHttpProvider_withRuKorincRuntimeJsonJsonProvider_(RuKorincRuntimeRuntimeConfiguration *self, id<RuKorincRuntimeRxRxProvider> rxProvider, id<RuKorincRuntimeTimeoutTimeoutProvider> timeoutProvider, id<RuKorincRuntimeLoggingLogProvider> logProvider, id<RuKorincRuntimeNetworkHttpProvider> httpProvider, id<RuKorincRuntimeJsonJsonProvider> jsonProvider) {
  NSObject_init(self);
  RuKorincRuntimeRuntimeConfiguration_rxProvider = rxProvider;
  RuKorincRuntimeRuntimeConfiguration_timeoutProvider = timeoutProvider;
  RuKorincRuntimeRuntimeConfiguration_log = logProvider;
  RuKorincRuntimeRuntimeConfiguration_http = httpProvider;
  RuKorincRuntimeRuntimeConfiguration_json = jsonProvider;
}

RuKorincRuntimeRuntimeConfiguration *new_RuKorincRuntimeRuntimeConfiguration_initWithRuKorincRuntimeRxRxProvider_withRuKorincRuntimeTimeoutTimeoutProvider_withRuKorincRuntimeLoggingLogProvider_withRuKorincRuntimeNetworkHttpProvider_withRuKorincRuntimeJsonJsonProvider_(id<RuKorincRuntimeRxRxProvider> rxProvider, id<RuKorincRuntimeTimeoutTimeoutProvider> timeoutProvider, id<RuKorincRuntimeLoggingLogProvider> logProvider, id<RuKorincRuntimeNetworkHttpProvider> httpProvider, id<RuKorincRuntimeJsonJsonProvider> jsonProvider) {
  J2OBJC_NEW_IMPL(RuKorincRuntimeRuntimeConfiguration, initWithRuKorincRuntimeRxRxProvider_withRuKorincRuntimeTimeoutTimeoutProvider_withRuKorincRuntimeLoggingLogProvider_withRuKorincRuntimeNetworkHttpProvider_withRuKorincRuntimeJsonJsonProvider_, rxProvider, timeoutProvider, logProvider, httpProvider, jsonProvider)
}

RuKorincRuntimeRuntimeConfiguration *create_RuKorincRuntimeRuntimeConfiguration_initWithRuKorincRuntimeRxRxProvider_withRuKorincRuntimeTimeoutTimeoutProvider_withRuKorincRuntimeLoggingLogProvider_withRuKorincRuntimeNetworkHttpProvider_withRuKorincRuntimeJsonJsonProvider_(id<RuKorincRuntimeRxRxProvider> rxProvider, id<RuKorincRuntimeTimeoutTimeoutProvider> timeoutProvider, id<RuKorincRuntimeLoggingLogProvider> logProvider, id<RuKorincRuntimeNetworkHttpProvider> httpProvider, id<RuKorincRuntimeJsonJsonProvider> jsonProvider) {
  J2OBJC_CREATE_IMPL(RuKorincRuntimeRuntimeConfiguration, initWithRuKorincRuntimeRxRxProvider_withRuKorincRuntimeTimeoutTimeoutProvider_withRuKorincRuntimeLoggingLogProvider_withRuKorincRuntimeNetworkHttpProvider_withRuKorincRuntimeJsonJsonProvider_, rxProvider, timeoutProvider, logProvider, httpProvider, jsonProvider)
}

id<RuKorincRuntimeJsonJsonProvider> RuKorincRuntimeRuntimeConfiguration_getJson() {
  RuKorincRuntimeRuntimeConfiguration_initialize();
  return RuKorincRuntimeRuntimeConfiguration_json;
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(RuKorincRuntimeRuntimeConfiguration)
