package org.octojuggler;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public abstract class Operation {
    protected final List<String> params;

    Operation(List<String> params) {
        this.params = new ArrayList<>(params);
    }

    public List<BigInteger> extractNumbers() {
        return params.stream().map(BigInteger::new).toList();
    }

    public abstract BigInteger evaluate();
}
