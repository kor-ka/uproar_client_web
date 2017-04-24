//
//  LogSwift.swift
//  ios
//
//  Created by g.putintsev on 18.04.17.
//  Copyright © 2017 korinc. All rights reserved.
//

import Foundation

class LogSwift: NSObject, RuKorincRuntimeLoggingLogProvider {
    public func e(with throwable: NSException!) {
        print(throwable)
    }

    func d(with tag: String!, with msg: String!) {
        print(Thread.current ,tag, msg)
    }
}
