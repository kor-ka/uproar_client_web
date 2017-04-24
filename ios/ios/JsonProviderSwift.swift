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
        return JsonObjectWrapperSwift(source: source);
    }
    
    func getJsonArray(with spurce: String!) -> RuKorincRuntimeJsonJsonArrayWrapper! {
        return nil;
    }
}
