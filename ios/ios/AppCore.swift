//
//  AppCore.swift
//  ios
//
//  Created by g.putintsev on 17.04.17.
//  Copyright © 2017 korinc. All rights reserved.
//

import Foundation

@objc open class AppCore: NSObject {
    
    

    open var model: RuKorincCoreModel?
    
    fileprivate(set) open var isStarted = false

    
    fileprivate static let shared =  AppCore()
    
    open static func sharedActor() -> AppCore {
        return shared
    }
    open func initCore()-> RuKorincCoreModel {
            
        if isStarted {
            return model!
        }
        
        model = RuKorincCoreModel(ruKorincRuntimeRuntimeConfiguration: RuKorincRuntimeRuntimeConfiguration()
            .setLogWith(LogSwift())
            .setRxProviderWith(RxProvider())
            .setTimeoutProviderWith(TimeoutSwift())
            .setJsonWith(JsonProviderSwift())
            .setHttpWith(HttpProviderSwift())
            .setEncoderWith(UrlEncoderProvider())
        );
                isStarted = true

        return model!
        
    }
    
    
}
