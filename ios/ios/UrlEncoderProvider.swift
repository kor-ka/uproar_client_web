//
//  UrlEncoderProvider.swift
//  ios
//
//  Created by g.putintsev on 14.12.17.
//  Copyright © 2017 korinc. All rights reserved.
//

import Foundation

class UrlEncoderProvider: NSObject, RuKorincRuntimeUtilsUrlEncoderProvider {
    func encodeQueryString(with s: String!) -> String! {
        print(s.addingPercentEncoding(withAllowedCharacters: .urlHostAllowed))
        return s.addingPercentEncoding(withAllowedCharacters: .urlHostAllowed)
    }
}
