//
//  SubjectSfift.swift
//  ios
//
//  Created by g.putintsev on 17.04.17.
//  Copyright © 2017 korinc. All rights reserved.
//

import Foundation
import RxSwift

class PsSwift: ObservableSwift, RuKorincRuntimeRxSubjectPublishSubjectWrapper{
    
    
    var sourceRs: PublishSubject<Any>?
    
    init(obs: PublishSubject<Any>) {
        super.init(obs: obs);
        self.sourceRs = obs;
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
