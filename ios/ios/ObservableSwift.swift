//
//  ObservableSwift.swift
//  ios
//
//  Created by g.putintsev on 17.04.17.
//  Copyright © 2017 korinc. All rights reserved.
//

import Foundation
import RxSwift

class ObservableSwift: NSObject, RuKorincRuntimeRxObservableWrapper{
    public func switchOnNext(withSources sources: RuKorincRuntimeRxObservableWrapper!) -> RuKorincRuntimeRxObservableWrapper! {
        let res:Observable<Observable<Any>> = ((sources as! ObservableSwift).obs as! Observable<ObservableSwift>).map { (o) -> Observable<Any> in
            return (o as ObservableSwift).obs
        }
        return ObservableSwift(obs: res.switchLatest())
    }

    public func retryWhen(withWindowMillis handler: RuKorincRuntimeRxFunction!) -> RuKorincRuntimeRxObservableWrapper! {
        return nil
    }

    public func delay(withWindowMillis millis: jlong) -> RuKorincRuntimeRxObservableWrapper! {
        return nil
    }

    public func throttleFirst(withWindowMillis windowMillis: jlong) -> RuKorincRuntimeRxObservableWrapper! {
        return nil
    }

    public func subscribeOn(withScheduler scheduler: RuKorincRuntimeRxBackgroundSchedulerWrapper!) -> RuKorincRuntimeRxObservableWrapper! {
        return ObservableSwift(obs: (obs.subscribeOn((scheduler as! SchedulerSwift).scheduler)))
    }

    
    public func observeOn(withScheduler scheduler: RuKorincRuntimeRxBackgroundSchedulerWrapper!) -> RuKorincRuntimeRxObservableWrapper! {
        return ObservableSwift(obs: (obs.observeOn((scheduler as! SchedulerSwift).scheduler)))
    }

    let obs: Observable<Any>
    
    
    init(obs: Observable<Any>) {
        self.obs = obs;
    }
    
    func observeOnMain() -> RuKorincRuntimeRxObservableWrapper! {
        return ObservableSwift(obs: (obs.observeOn(MainScheduler.instance)))
    }
    
    func subscribe(with consumer: RuKorincRuntimeRxConsumer!) -> RuKorincRuntimeRxDisposableWrapper! {
        let d = self.obs.subscribe(onNext: { val in
            consumer.accept(withId: val)
        });
        
        return DisposableSwift(d: d);
    }
    
    func subscribeAsync(with consumer: RuKorincRuntimeRxConsumer!) -> RuKorincRuntimeRxDisposableWrapper! {
        let d = self.obs.subscribeOn(ConcurrentDispatchQueueScheduler(qos: .background)).subscribe(onNext: { val in
            consumer.accept(withId: val)
        });
        
        return DisposableSwift(d: d);
    }
    
    func map(withFunc func1: RuKorincRuntimeRxFunction!) -> RuKorincRuntimeRxObservableWrapper! {
        return ObservableSwift(obs: (obs.map({ (val) -> Any in
            return func1.apply(withId: val)
        })))
    }
    
    public func flatMap(withFunc func1: RuKorincRuntimeRxFunction!) -> RuKorincRuntimeRxObservableWrapper! {
        
        
        let res = obs.flatMap({ val -> Observable<Any> in
            let flatted = func1.apply(withId: val) as! ObservableSwift
            let flatObs =  flatted.obs as Observable<Any>
            return flatObs
        })
        return ObservableSwift(obs: res )
    }
    
}
