package org.octojuggler;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class SolutionDayOneTest {

    private static final List<String> INPUT_1 = List.of(
            "L68",
            "L30",
            "R48",
            "L5",
            "R60",
            "L55",
            "L1",
            "L99",
            "R14",
            "L82"
    );


    private static final List<String> INPUT_2 = List.of(
            "L68",
            "L30",
            "R48",
            "L5",
            "R60",
            "L55",
            "L1",
            "L99",
            "R14",
            "L82"
    );

    @Test
    public void shouldReturnLines() throws Exception {
        var sut = new SolutionDayOne();
        var result = sut.readLines();

        assertThat(result).hasSize(4232);
    }

    @Test
    public void shouldParseLineRight() throws Exception {
        var sut = new SolutionDayOne();
        var result = sut.parseLine("R14");
        assertThat(result).isEqualTo(14);
    }

    @Test
    public void shouldParseLineLeft() throws Exception {
        var sut = new SolutionDayOne();
        var result = sut.parseLine("L14");
        assertThat(result).isEqualTo(-14);
    }

    @Test
    public void shouldReturnAnswer1() throws Exception {

        var sut = new SolutionDayOne();
        var result = sut.turnTheDial(INPUT_1);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void shouldReturnAnswer2() throws Exception {

        var sut = new SolutionDayOne();
        var result = sut.turnTheDial(INPUT_2);

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void shouldReturnAnswer3() throws Exception {

        var sut = new SolutionDayOne();
        var result = sut.turnTheDial(List.of("R1000"));

        assertThat(result).isEqualTo(10);
    }
}
