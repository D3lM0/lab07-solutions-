package it.unibo.inner.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.unibo.inner.api.IterableWithPolicy;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {
    private ArrayList<T> elems = new ArrayList<>();

    
    public IterableWithPolicyImpl(final ArrayList<T> elems) {

    }

    private class IteratorWithPolicy implements Iterator<T> {
        public T next() {
            final T elem = IterableWithPolicyImpl.this.elems.getFirst();
            IterableWithPolicyImpl.this.elems.
        }

        public boolean hasNext() {
            return (IterableWithPolicyImpl.this.elems != null);
        }
    }
}
