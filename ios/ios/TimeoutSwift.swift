//
//  TimeoutSwift.swift
//  ios
//
//  Created by g.putintsev on 18.04.17.
//  Copyright © 2017 korinc. All rights reserved.
//

import Foundation

class TimeoutSwift:NSObject, RuKorincRuntimeTimeoutTimeoutProvider{
    func sleep(with millis: jint) {
       
        usleep(useconds_t(Int32(millis.littleEndian) * 1000))
    }
}
