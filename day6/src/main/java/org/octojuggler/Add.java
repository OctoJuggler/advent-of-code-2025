package org.octojuggler;

import java.math.BigInteger;
import java.util.List;

import static java.math.BigInteger.ZERO;

public class Add extends Operation {

    Add(List<String> params) {
        super(params);
    }

    @Override
    public BigInteger evaluate() {
        return extractNumbers().stream().reduce(ZERO, BigInteger::add);
    }

}
