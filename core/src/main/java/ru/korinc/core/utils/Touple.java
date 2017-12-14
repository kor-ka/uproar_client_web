package ru.korinc.core.utils;

/**
 * Created by gputintsev on 05.04.17.
 */

public class Touple<A, B> {

    private A a;

    private B b;

    public Touple(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Touple<?, ?> touple = (Touple<?, ?>) o;

        if (a != null ? !a.equals(touple.a) : touple.a != null) {
            return false;
        }
        return b != null ? b.equals(touple.b) : touple.b == null;

    }

    @Override
    public int hashCode() {
        int result = a != null ? a.hashCode() : 0;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        return result;
    }
}
