//
//  JsonObjectWrapperSwift.swift
//  ios
//
//  Created by g.putintsev on 24.04.17.
//  Copyright © 2017 korinc. All rights reserved.
//

import Foundation

class JsonObjectWrapperSwift: NSObject, RuKorincRuntimeJsonJsonObjectWrapper {
    var source:[String: Any]?
    
    init(source:String) {
        super.init()
        self.source = convertToDictionary(text: source)
        
    }
    
    public func getStringWith(_ key: String!, with defaultValue: String!) -> String! {
        return self.source![key] as! String
    }

    public func getStringWith(_ key: String!) -> String! {
        return self.source![key] as! String
    }

    public func getJsonArray(with key: String!) -> RuKorincRuntimeJsonJsonArrayWrapper! {
       return JsonArraS self.source![key]
    }

    public func getJsonObject(with key: String!) -> RuKorincRuntimeJsonJsonObjectWrapper! {
       return self.source![key] as! RuKorincRuntimeJsonJsonArrayWrapper
    }
    
    func convertToDictionary(text: String) -> [String: Any]? {
        if let data = text.data(using: .utf8) {
            do {
                return try JSONSerialization.jsonObject(with: data, options: []) as? [String: Any]
            } catch {
                print(error.localizedDescription)
            }
        }
        return nil
    }

    
}
