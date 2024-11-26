package org.example.business;

import org.example.model.BankAccount;

@FunctionalInterface
public interface Condition<T> {
    boolean test(T o);

}
