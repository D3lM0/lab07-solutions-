package it.unibo.inner.impl;

import java.util.ArrayList;
import java.util.Iterator;


import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {
    private ArrayList<T> elems;

    
    public IterableWithPolicyImpl(final T[] elementsToAdd) {
        this.elems = new ArrayList<>();
        for (final T elem : elementsToAdd) {
            this.elems.add(elem);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {

    }

    public String toString() {
        return "[IterableWithPolicy]: " + this.elems.toString();
    }

    private class ArrayIterator implements Iterator<T> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < elems.size();
        }

        @Override
        public T next() {
            return elems.get(index++);
        }

    }
}
