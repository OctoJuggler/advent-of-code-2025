package org.octojuggler;

import java.util.ArrayList;


public class Part2 extends AbstractSolution {

    public boolean isInvalid(long number) {
        var numberAsString = Long.toString(number);

        var fragmentResults = new ArrayList<Boolean>();

        for(int i = 1; i < numberAsString.length()+1; i++) {
            fragmentResults.add(isInvalidForFragmentLength(numberAsString, i));
        }

        return fragmentResults.stream().reduce(false, (x, y) -> x || y);
    }

    public boolean isInvalidForFragmentLength(String numberAsString, int fragmentLength) {

        var totalLength = numberAsString.length();
        if (totalLength % fragmentLength != 0) {
            return false;
        }

        var numberOfFragments = totalLength / fragmentLength;

        if(numberOfFragments == 1) {
            return false;
        }

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
        var sut = new Part2();
        var result = sut.getSumOfInvalidNumbers(sut.readInput());
        System.out.println(result);
    }
}
