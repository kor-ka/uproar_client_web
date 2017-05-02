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
    
    var sourceRs: BehaviorSubject<Any>?
    
    init(obs: BehaviorSubject<Any>) {
        super.init(obs: obs);
        self.sourceRs = obs;
    }
    
    func onNext(withId t: Any!) {
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
        do{
            return try sourceRs?.value()
        } catch {
            return nil
        }
        
    }
    
    
}
