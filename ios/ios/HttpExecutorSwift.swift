//
//  HttpExecutor.swift
//  ios
//
//  Created by g.putintsev on 24.04.17.
//  Copyright © 2017 korinc. All rights reserved.
//

import Foundation
class HttpExecutorSwift: NSObject, RuKorincRuntimeNetworkHttpExecutor {
    func getMethodWithUrl(_ url: String!, withHeaders headers: IOSObjectArray!) -> RuKorincRuntimeNetworkHttpResponse! {
        var request = NSURLRequest(url: URL(string: url)!)
        var response: URLResponse?
        do{
            var data = try NSURLConnection.sendSynchronousRequest(request as URLRequest, returning: &response)
            var reply = NSString(data: data, encoding: String.Encoding.utf8.rawValue)
            return RuKorincRuntimeNetworkHttpResponse(int: 200, with: reply as String!, with: url)
        }catch{
            
        }
        return nil
    }
    
    func putMethod(withUrl url: String!, withContent contents: String!, withHeaders headers: IOSObjectArray!) -> RuKorincRuntimeNetworkHttpResponse! {
        return nil
    }
}
