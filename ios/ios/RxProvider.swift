//
//  RxProvider.swift
//  ios
//
//  Created by g.putintsev on 14.04.17.
//  Copyright © 2017 korinc. All rights reserved.
//

import Foundation
import RxSwift

class RxProvider: NSObject, RuKorincRuntimeRxRxProvider{
    func observableCreate(withSource observableOnSubscribe: RuKorincRuntimeRxObservableOnSubscribe) -> RuKorincRuntimeRxObservableWrapper {
        
        
        let emitter: Em<Any> = Em<Any>()
        let res = Observable<Any>.create{ (observer) -> Disposable in
            emitter.ao = observer
            observableOnSubscribe.subscribe(with:emitter)
            
            return Disposables.create()
        }
        return ObservableSwift(obs: res);
    }
    
    func bs(withId defaultValue: Any!) -> RuKorincRuntimeRxSubjectBSWrapper! {
        
        let res = BsSwift(obs:BehaviorSubject(value: defaultValue))
        return res;
    }
    
    func bs() -> RuKorincRuntimeRxSubjectBSWrapper! {
        return nil    }
    
    func scheduler() -> RuKorincRuntimeRxBackgroundSchedulerWrapper! {
        return SchedulerSwift()
    }
    
}

class Em<T>: NSObject,  RuKorincRuntimeRxEmitter{
    open var ao:AnyObserver<T>?
    
    func onNext(withId value: Any!) {
        ao?.onNext(value as! T)
    }
    
    func onComplete() {
        ao?.onCompleted()
    }
    
    func onError(with error: JavaLangThrowable!) {
        ao?.onError(JavaError())
    }
}

class JavaError: Error {
  }

