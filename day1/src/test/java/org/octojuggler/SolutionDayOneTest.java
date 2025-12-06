package org.octojuggler;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


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

        var sut = getSolution();
        var result = sut.turnTheDial(INPUT_1);

        assertThat(result.getZeroCount()).isEqualTo(3);
    }

    @Test
    public void shouldReturnAnswer2() throws Exception {

        var sut = getSolution();
        var result = sut.turnTheDial(INPUT_2);

        assertThat(result.getZeroClicks()).isEqualTo(6);
    }

    @Test
    public void shouldReturnAnswer3() throws Exception {

        var sut = getSolution();
        var result = sut.turnTheDial(List.of("R1000"));

        assertThat(result.getZeroClicks()).isEqualTo(10);
    }

    @Test
    public void shouldReturnAnswer4() throws Exception {

        var sut = getSolution();
        var result = sut.turnTheDial(List.of("L60"));

        assertThat(result.getZeroCount()).isEqualTo(0);
        assertThat(result.getZeroClicks()).isEqualTo(1);
    }

    @Test
    public void shouldReturnAnswer5() throws Exception {

        var sut = getSolution();
        var result = sut.turnTheDial(List.of("L50"));

        assertThat(result.getZeroCount()).isEqualTo(1);
        assertThat(result.getZeroClicks()).isEqualTo(1);
    }

    @Test
    public void shouldReturnAnswer6() throws Exception {

        var sut = getSolution();
        var result = sut.turnTheDialOnce(new State(), "R50");

        assertThat(result.getZeroCount()).isEqualTo(1);
        assertThat(result.getZeroClicks()).isEqualTo(1);
    }


    @Test
    public void shouldReturnAnswer7() throws Exception {

        var sut = getSolution();
        var result = sut.turnTheDialOnce(new State(0,0,0), "L10");

        assertThat(result.getZeroCount()).isEqualTo(0);
        assertThat(result.getZeroClicks()).isEqualTo(0);
    }

    @Test
    public void shouldReturnAnswer8() throws Exception {

        var sut = getSolution();
        var result = sut.turnTheDialOnce(new State(0,0,0), "R10");

        assertThat(result.getZeroCount()).isEqualTo(0);
        assertThat(result.getZeroClicks()).isEqualTo(0);
    }

    @Test
    public void shouldReturnAnswer9() throws Exception {

        var sut = getSolution();
        var result = sut.turnTheDialOnce(new State(0,0,0), "R100");

        assertThat(result.getDialPosition()).isEqualTo(0);
        assertThat(result.getZeroCount()).isEqualTo(1);
        assertThat(result.getZeroClicks()).isEqualTo(1);
    }

    public AbstractSolution getSolution() {
        return new SolutionDayOneV2();
    }
}
