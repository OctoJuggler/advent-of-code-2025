package org.octojuggler;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Part1Test {

    private static List<String> lines = List.of(
//            "987654321111111",
//            "811111111111119"
            "234234234234278"
//            "818181911112111"
    );

    private Part1 sut = new Part1();

    @Test
    public void test() {
        var result  = sut.maxJoltage(lines);
        assertThat(result).isEqualTo(3121910778619l);
    }

}