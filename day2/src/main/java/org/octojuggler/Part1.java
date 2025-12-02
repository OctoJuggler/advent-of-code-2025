package org.octojuggler;

import java.util.ArrayList;


public class Part1 extends AbstractSolution {

    public boolean isInvalid(long number) {
        var numberAsString = Long.toString(number);

        var totalLength = numberAsString.length();
        var fragmentLength = numberAsString.length() / 2;

        if (totalLength % fragmentLength == 1) {
            return false;
        }

        var numberOfFragments = totalLength / fragmentLength;

        var fragments = generateFragmentsOfSize(numberOfFragments, fragmentLength, numberAsString);

        var firstFragment = fragments.get(0);
        for (int i = 1; i < numberOfFragments; i++) {
            var fragment = fragments.get(i);
            if (!fragment.equals(firstFragment)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        var sut = new Part1();
        var result = sut.getSumOfInvalidNumbers(sut.readInput());
        System.out.println(result);
    }
}
