package ru.korinc.runtime.rx.subject;

import ru.korinc.runtime.rx.ObservableWrapper;

/**
 * Created by gputintsev on 12.04.17.
 */

public interface BSWrapper<T> extends SubjectWrapper<T> {

    T getValue();
}
