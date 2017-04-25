//
//  JsonArraySwift.swift
//  ios
//
//  Created by g.putintsev on 24.04.17.
//  Copyright © 2017 korinc. All rights reserved.
//

import Foundation
class JsonArraySwift: NSObject, RuKorincRuntimeJsonJsonArrayWrapper{
    let source:Array<AnyObject>!
    
    init(source: Array<AnyObject>) {
        self.source = source
    }
    
    func length() -> jint {
        return 1
    }
    
    func getStringWith(_ position: jint) -> String! {
        return ""
    }
    
    func getJsonObjectWrapper(with position: jint) -> RuKorincRuntimeJsonJsonObjectWrapper! {
        return nil
    }
    
    func getWith(_ position: jint) -> RuKorincRuntimeJsonJsonArrayWrapper! {
        return nil
    }
}
