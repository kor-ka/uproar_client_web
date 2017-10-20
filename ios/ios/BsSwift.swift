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
    
    
    func getValue() -> Any! {
        do{
            return try sourceRs?.value()
        } catch {
            return nil
        }
        
    }
    
    
    
    override func onNext(withId value: Any!) {
        sourceRs?.onNext(value)
    }
    
    override func onComplete() {
        sourceRs?.onCompleted()
    }
    
    override func onError(with error: JavaLangThrowable!) {
        sourceRs?.onError(JavaError())
    }
    
}
