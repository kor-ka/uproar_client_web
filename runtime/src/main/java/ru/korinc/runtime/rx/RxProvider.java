package ru.korinc.runtime.rx;

import com.google.j2objc.annotations.ObjectiveCName;

import ru.korinc.runtime.rx.subject.BSWrapper;
import ru.korinc.runtime.rx.subject.PublishSubjectWrapper;

/**
 * Created by gputintsev on 12.04.17.
 */

public interface RxProvider {

    @ObjectiveCName("observableCreateWithSource:")
    <T> ObservableWrapper<T> observableCreate(ObservableOnSubscribe<T> observableOnSubscribe);

    <T> BSWrapper<T> bs(T defaultValue);

    <T> PublishSubjectWrapper<T> ps();

    BackgroundSchedulerWrapper scheduler();
}
