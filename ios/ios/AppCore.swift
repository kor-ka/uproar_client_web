//
//  AppCore.swift
//  ios
//
//  Created by g.putintsev on 17.04.17.
//  Copyright © 2017 korinc. All rights reserved.
//

import Foundation

@objc open class AppCore: NSObject {
    
    

    open var model: RuKorincModel?
    
    fileprivate(set) open var isStarted = false

    
    fileprivate static let shared =  AppCore()
    
    open static func sharedActor() -> AppCore {
        return shared
    }
    open func initCore()-> RuKorincModel {
            
        if isStarted {
            return model!
        }
        
        model = RuKorincModel(ruKorincRuntimeRuntimeConfiguration: RuKorincRuntimeRuntimeConfiguration(ruKorincRuntimeRxRxProvider: RxProvider(), with: TimeoutSwift(), with: LogSwift()));

        isStarted = true

        return model!
        
    }
    
    
}
