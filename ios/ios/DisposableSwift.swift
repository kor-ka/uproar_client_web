//
//  DisposableSwift.swift
//  ios
//
//  Created by g.putintsev on 17.04.17.
//  Copyright © 2017 korinc. All rights reserved.
//

import Foundation
import RxSwift

class DisposableSwift: NSObject, RuKorincRuntimeRxDisposableWrapper
{
    var d:Disposable?
    
    init(d: Disposable) {
        self.d = d;
    }
    
    func dispose() {
        d?.dispose()
    }
}
