package org.octojuggler;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestPart1 {

    static List<Range> ranges = List.of(
            new Range(11, 22),
            new Range(95, 115),
            new Range(998, 1012),
            new Range(1188511880, 1188511890),
            new Range(222220, 222224),
            new Range(1698522, 1698528),
            new Range(446443, 446449),
            new Range(38593856, 38593862)
    );

    @Test
    public void readInput() {
        var sut = new Part1();

        var result = sut.readInput();
        Assertions.assertThat(result).hasSize(40);
    }

    @Test
    public void checkIsInvalid() {
        var sut = new Part1();

        var numbers = List.of(11, 22, 99, 1010, 1188511885, 222222, 446446, 38593859);
        numbers.forEach(x -> {
            System.out.println(x);
            Assertions.assertThat(sut.isInvalid(x)).isTrue();
        });
    }

    @Test
    public void check22IsInvalid() {
        var sut = new Part1();
        Assertions.assertThat(sut.isInvalid(22)).isTrue();
    }

    @Test
    public void checkSumOfInvalidNumbers() {
        var sut = new Part1();
        var result = sut.getSumOfInvalidNumbers(ranges);
        Assertions.assertThat(result).isEqualTo(1227775554);
    }

}