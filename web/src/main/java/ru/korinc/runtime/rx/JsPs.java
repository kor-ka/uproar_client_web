package ru.korinc.runtime.rx;

import ru.korinc.runtime.interop.subject.BehaviorSubject;

import ru.korinc.runtime.interop.subject.Subject;
import ru.korinc.runtime.rx.subject.BSWrapper;
import ru.korinc.runtime.rx.subject.PublishSubjectWrapper;

/**
 * Created by gputintsev on 18.12.17.
 */

public class JsPs<T> extends JsSubject<T> implements PublishSubjectWrapper<T> {

    private Subject<T> source;

    public JsPs(Subject<T> source) {
        super(source);
        this.source = source;
    }
}
