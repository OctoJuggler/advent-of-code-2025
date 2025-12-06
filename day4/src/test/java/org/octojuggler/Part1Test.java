package org.octojuggler;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Part1Test {
    public static List<String> input = List.of(
            "..@@.@@@@.",
            "@@@.@.@.@@",
            "@@@@@.@.@@",
            "@.@@@@..@.",
            "@@.@@@@.@@",
            ".@@@@@@@.@",
            ".@.@.@.@@@",
            "@.@@@.@@@@",
            ".@@@@@@@@.",
            "@.@.@@@.@."
    );
    public static List<String> input2 = List.of(
            "...",
            ".@.",
            "..."
    );

    @Test
    public void shouldCreateBoard() {
        var sut = new Part1();
        char[][] x = sut.createBoard(input);

        assertThat(x).hasDimensions(10, 10);
    }

    @Test
    public void shouldCreateBoardForInput2() {
        var sut = new Part1();
        char[][] board = sut.createBoard(input);

        var neighbourHood = sut.createNeighbourHood(board);

        var numberOfFreeRolls =  sut.countFreeRolls(neighbourHood);
        assertThat(numberOfFreeRolls).isEqualTo(13);
    }

}