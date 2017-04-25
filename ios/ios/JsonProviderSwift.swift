//
//  JsonProviderSwift.swift
//  ios
//
//  Created by g.putintsev on 24.04.17.
//  Copyright © 2017 korinc. All rights reserved.
//

import Foundation

class JsonProviderSwift: NSObject, RuKorincRuntimeJsonJsonProvider {
    func getJsonWith(_ source: String!) -> RuKorincRuntimeJsonJsonObjectWrapper! {
        return JsonObjectWrapperSwift(source: convertToDictionary(text: source)!);
    }
    
    func getJsonArray(with spurce: String!) -> RuKorincRuntimeJsonJsonArrayWrapper! {
        return nil;
    }
    
    func convertToDictionary(text: String) -> [String: AnyObject]? {
        if let data = text.data(using: .utf8) {
            do {
                return try JSONSerialization.jsonObject(with: data, options: []) as? [String: AnyObject]
            } catch {
                print(error.localizedDescription)
            }
        }
        return nil
    }
    

}
