package ru.perveevm.codeforces.api.utils;

import java.util.Objects;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 * <p>
 * Describes a pair of two elements. Their types may be different.
 */
public class Pair<T1, T2> {
    private final T1 first;
    private final T2 second;

    /**
     * Constructs a pair of two given elements.
     *
     * @param first  The first element of a pair.
     * @param second The second element of a pair.
     */
    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    /**
     * @return The first element of a pair.
     */
    public T1 getFirst() {
        return first;
    }

    /**
     * @return The second element of a pair.
     */
    public T2 getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (!Objects.equals(first, pair.first)) return false;
        return Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }
}
