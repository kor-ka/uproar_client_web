package ru.korinc.runtime.rx.subject;

import ru.korinc.runtime.rx.ObservableWrapper;
import ru.korinc.runtime.rx.ObserverWrapper;

/**
 * Created by gputintsev on 12.04.17.
 */

public interface SubjectWrapper<T> extends ObservableWrapper<T>, ObserverWrapper<T> {

}
