package it.unibo.inner.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {
    private ArrayList<T> elems;
    private Predicate<T> predicate;

    public IterableWithPolicyImpl(final T[] elementsToAdd) {
        this(elementsToAdd, new Predicate<T>() {

            @Override
            public boolean test(T elem) {
                return true;
            }

        });
    }

    public IterableWithPolicyImpl(final T[] elementsToAdd, final Predicate<T> predicate) {
        this.elems = new ArrayList<>();
        for (final T elem : elementsToAdd) {
            this.elems.add(elem);
        }

        this.predicate = predicate;

    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        this.predicate = filter;
    }

    public String toString() {
        return "[IterableWithPolicy]: " + this.elems.toString();
    }

    private class ArrayIterator implements Iterator<T> {
        private int index;

        @Override
        public boolean hasNext() {
            while (index < elems.size() && !predicate.test(elems.get(index))) {
                index++;
            }
            return index < elems.size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elems.get(index++);
        }

    }
}
