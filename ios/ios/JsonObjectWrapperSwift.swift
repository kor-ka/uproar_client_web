//
//  JsonObjectWrapperSwift.swift
//  ios
//
//  Created by g.putintsev on 24.04.17.
//  Copyright © 2017 korinc. All rights reserved.
//

import Foundation

class JsonObjectWrapperSwift: NSObject, RuKorincRuntimeJsonJsonObjectWrapper {
    var source:[String: AnyObject]?
    
    init(source:[String: AnyObject]) {
        super.init()
        
    }
    
    public func getStringWith(_ key: String!, with defaultValue: String!) -> String! {
        return self.source![key] as! String
    }

    public func getStringWith(_ key: String!) -> String! {
        return self.source![key] as! String
    }

    public func getJsonArray(with key: String) -> RuKorincRuntimeJsonJsonArrayWrapper! {
       return JsonArraySwift(source: self.source![key] as! Array<AnyObject>)
    }

    public func getJsonObject(with key: String) -> RuKorincRuntimeJsonJsonObjectWrapper! {
       return JsonObjectWrapperSwift(source: self.source![key] as! [String : AnyObject] )
    }
}
