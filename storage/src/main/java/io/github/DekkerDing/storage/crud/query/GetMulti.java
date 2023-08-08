package io.github.DekkerDing.storage.crud.query;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

@FunctionalInterface
public interface GetMulti<T, R> {

    public abstract T all(Supplier<T> supplier);

    default Optional list(T parameter, Function<T, Optional> function) {
        return function.apply(parameter);
    }

    default Optional map(T parameter, Function<T, Optional> function) {
        return function.apply(parameter);
    }

    default Optional set(T parameter, Function<T, Optional> function) {
        return function.apply(parameter);
    }

    default List<R> compareByMax(T parameter, Function<T, R> function1, Function<T, R> function2, Comparator<R> comparatorPk) {
        final R apply1 = function1.apply(parameter);
        final R apply2 = function2.apply(parameter);

        final ArrayList<R> list = new ArrayList<>();
        if (comparatorPk.compare(apply1, apply2) < 0) {
            list.add(apply2);
            return list;
        } else if (comparatorPk.compare(apply1, apply2) > 0) {
            list.add(apply1);
            return list;
        }
        Random r = new Random(2);
        final int nextInt = r.nextInt(2);
        if (nextInt == 1) {
            list.add(apply1);
        } else if (nextInt == 2) {
            list.add(apply2);
        }
        return list;
    }

    default List<R> compareBySmall(T parameter, Function<T, R> function1, Function<T, R> function2, Comparator<R> comparatorPk) {
        final R apply1 = function1.apply(parameter);
        final R apply2 = function2.apply(parameter);

        final ArrayList<R> list = new ArrayList<>();
        if (comparatorPk.compare(apply1, apply2) < 0) {
            list.add(apply1);
            return list;
        } else if (comparatorPk.compare(apply1, apply2) > 0) {
            list.add(apply2);
            return list;
        }
        Random r = new Random(2);
        final int nextInt = r.nextInt(2);
        if (nextInt == 1) {
            list.add(apply1);
        } else if (nextInt == 2) {
            list.add(apply2);
        }
        return list;
    }
}
