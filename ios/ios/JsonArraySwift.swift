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
        return jint(self.source.count)
    }
    
    func getStringWith(_ position: jint) -> String! {
        return ""
    }
    
    func getJsonObjectWrapper(with position: jint) -> RuKorincRuntimeJsonJsonObjectWrapper! {
        return JsonObjectWrapperSwift(source: self.source![Int(position)] as! [String : AnyObject])
    }
    
    func getWith(_ position: jint) -> RuKorincRuntimeJsonJsonArrayWrapper! {
        return nil
    }
}
