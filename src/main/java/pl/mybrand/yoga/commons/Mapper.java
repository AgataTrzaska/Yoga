package pl.mybrand.yoga.commons;

import org.springframework.stereotype.Component;

public interface Mapper<F, T> {

    T map(F from);
    F reverse(T to);
}
