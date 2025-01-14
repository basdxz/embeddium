package org.embeddedt.embeddium.api.options.structure;

public interface OptionBinding<S, T> {
    void setValue(S storage, T value);

    T getValue(S storage);
}
