package ru.korinc.j2objc.runtime.rx;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import ru.korinc.runtime.rx.subject.PublishSubjectWrapper;

/**
 * Created by gputintsev on 20.12.17.
 */

public class AndroidPublishSubject<T> extends AndroidSubject<T>
        implements PublishSubjectWrapper<T> {

    public AndroidPublishSubject(PublishSubject<T> source) {
        super(source);
    }
}
