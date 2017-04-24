//
//  HttpProviderSwift.swift
//  ios
//
//  Created by g.putintsev on 24.04.17.
//  Copyright © 2017 korinc. All rights reserved.
//

import Foundation
class HttpProviderSwift: NSObject, RuKorincRuntimeNetworkHttpProvider{
    public func getExecutor() -> RuKorincRuntimeNetworkHttpExecutor! {
        return HttpExecutorSwift()
    }

    
}
