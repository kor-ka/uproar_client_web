//
//  Scheduler.swift
//  ios
//
//  Created by g.putintsev on 19.04.17.
//  Copyright © 2017 korinc. All rights reserved.
//

import Foundation
import RxSwift

class SchedulerSwift: NSObject, RuKorincRuntimeRxBackgroundSchedulerWrapper{
    open let scheduler: SerialDispatchQueueScheduler
    
    override init() {
        scheduler = SerialDispatchQueueScheduler.init(qos: .default)
    }
}
