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
        print(url)
        let request = NSURLRequest(url: URL(string: url)!)
        var response: URLResponse?
        do {
            let data = try NSURLConnection.sendSynchronousRequest(request as URLRequest, returning: &response)
            // делаю строку из Data, чтобы потом из строки сделать Data xD 
            let str = String(data: data, encoding: String.Encoding.utf8)
            return RuKorincRuntimeNetworkHttpResponse(int: 200, with: str, with: url)
        } catch {
            print(error)
        }
        return nil
    }
    
    func putMethod(withUrl url: String!, withContent contents: String!, withHeaders headers: IOSObjectArray!) -> RuKorincRuntimeNetworkHttpResponse! {
        return nil
    }
}
