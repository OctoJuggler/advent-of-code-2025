package org.octojuggler;

import java.math.BigInteger;
import java.util.List;

import static java.math.BigInteger.ONE;

public class Multiply extends Operation{

    Multiply(List<String> params) {
        super(params);
    }

    @Override
    public BigInteger evaluate() {
        return extractNumbers().stream().reduce(ONE, BigInteger::multiply);
    }
}
