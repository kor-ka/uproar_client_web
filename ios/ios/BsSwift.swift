//
//  SubjectSfift.swift
//  ios
//
//  Created by g.putintsev on 17.04.17.
//  Copyright © 2017 korinc. All rights reserved.
//

import Foundation
import RxSwift

class BsSwift: ObservableSwift, RuKorincRuntimeRxSubjectBSWrapper{
    
    var sourceRs: ReplaySubject<Any>?
    
    var las: Any?
    
    init(obs: ReplaySubject<Any>) {
        super.init(obs: obs);
        self.sourceRs = obs;
    }
    
    func onNext(withId t: Any!) {
        if las != nil {
            las = t
        }
        if sourceRs != nil {
            sourceRs?.onNext(t)
        }
        
    }
    
    func onComplete() {
        if sourceRs != nil {
            sourceRs?.onCompleted()
        }
    }
    
    func onError(with e: NSException!) {
        
        if sourceRs != nil {
            sourceRs?.onError(e as! Error)
        }
    }
    
    func getValue() -> Any! {
        return las
    }
    
    
}
