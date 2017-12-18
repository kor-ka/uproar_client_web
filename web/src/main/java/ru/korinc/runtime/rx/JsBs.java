package ru.korinc.runtime.rx;

import com.github.timofeevda.gwt.rxjs.interop.subject.BehaviorSubject;
import com.github.timofeevda.gwt.rxjs.interop.subject.Subject;

import ru.korinc.runtime.rx.subject.BSWrapper;

/**
 * Created by gputintsev on 18.12.17.
 */

public class JsBs<T> extends JsSubject<T> implements BSWrapper<T> {

    private BehaviorSubject<T> source;

    public JsBs(BehaviorSubject<T> source) {
        super(source);
        this.source = source;
    }

    @Override
    public T getValue() {
        return source.getValue();
    }
}
