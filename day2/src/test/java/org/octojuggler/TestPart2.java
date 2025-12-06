package org.octojuggler;

import org.octojuggler.datastructures.Pair;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.List.*;

public class TestPart2 {

    static List<Pair<Range, Integer>> ranges = of(
            new Pair<>(new Range(11, 22), 2),
            new Pair<>(new Range(95, 115), 2),
            new Pair<>(new Range(998, 1012), 2),
            new Pair<>(new Range(1188511880, 1188511890), 1),
            new Pair<>(new Range(222220, 222224), 1),
            new Pair<>(new Range(1698522, 1698528), 0),
            new Pair<>(new Range(446443, 446449), 1),
            new Pair<>(new Range(38593856, 38593862), 1),
            new Pair<>(new Range(565653, 565659), 1),
            new Pair<>(new Range(824824821, 824824827), 1),
            new Pair<>(new Range(2121212118, 2121212124), 1)
    );

    @Test
    public void readInput() {
        var sut = new Part2();

        var result = sut.readInput();
        Assertions.assertThat(result).hasSize(40);
    }

    @Test
    public void checkIsInvalidOld() {
        var sut = new Part1();

        var numbers = of(11, 22, 99, 1010, 1188511885, 222222, 446446, 38593859);
        numbers.forEach(x -> {
            System.out.println(x);
            Assertions.assertThat(sut.isInvalid(x)).isTrue();
        });
    }


    @Test
    public void checkIsInvalidNew() {
        var sut = new Part2();

        var numbers = of(11, 22, 99, 111, 999, 1010, 1188511885, 222222, 446446,
                38593859, 565656, 824824824, 2121212121);

        numbers.forEach(x -> {
            System.out.println(x);
            Assertions.assertThat(sut.isInvalid(x)).isTrue();
        });
    }

    @Test
    public void testRanges() {
        var sut = new Part2();
        for(var pair : ranges) {
            var range = pair.range();
            var numberOfInvalidNumbers = pair.numberOfInvalidNumbers();

            System.out.println(range);
            var result = sut.getInvalidNumbers(range);
            Assertions.assertThat(result).hasSize(numberOfInvalidNumbers);
        }
    }
}