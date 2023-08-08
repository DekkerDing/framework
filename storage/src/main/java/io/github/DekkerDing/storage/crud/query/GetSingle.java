package io.github.DekkerDing.storage.crud.query;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public interface GetSingle <T, R> {

    default Optional echo (T parameter, Predicate<T> predicate, Function<T, Optional> function){
        if(predicate.test(parameter)){
           return function.apply(parameter);
        }
        return Optional.empty();
    }
}
