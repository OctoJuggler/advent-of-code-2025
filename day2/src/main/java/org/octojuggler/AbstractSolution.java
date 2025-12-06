package org.octojuggler;

import com.google.common.io.CharStreams;
import org.octojuggler.utils.FileUtils;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractSolution {

    final public List<Range> readInput() {
            var input = FileUtils.readFile("/day2.txt");
            var rangesAsString = input.split(",");

            return Arrays.stream(rangesAsString).map(x -> {
                var parts = x.split("-");
                return new Range(Long.parseLong(parts[0]), Long.parseLong(parts[1]));
            }).toList();

    }

    final public long getSumOfInvalidNumbers(List<Range> ranges) {
        long result = 0;

        for (var x : ranges) {
            var invalidNumbers = getInvalidNumbers(x);

            for (var invalidNumber : invalidNumbers) {
                result += invalidNumber;
            }

        }

        return result;
    }


    final public List<Long> getInvalidNumbers(Range range) {
        List<Long> numbers = new ArrayList<Long>();

        for (var i = range.start(); i <= range.end(); i++) {
            if (isInvalid(i)) {
                numbers.add(i);
            }
        }

        return numbers;
    }

    final List<String> generateFragmentsOfSize(int numberOfFragments, int fragmentLength, String numberAsString) {
        var fragments = new ArrayList<String>();
        for (int i = 0; i < numberOfFragments; i++) {
            var fragment = numberAsString.substring(i * fragmentLength, (i + 1) * fragmentLength);
            fragments.add(fragment);
        }

        return fragments;
    }

    public abstract boolean isInvalid(long number);
}
