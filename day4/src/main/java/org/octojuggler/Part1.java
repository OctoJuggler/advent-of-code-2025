package org.octojuggler;

import com.google.common.collect.Lists;
import org.octojuggler.utils.FileUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Part1 {

    private static char PAPER_ROLL = '@';
    private static char EMPTY_SPOT = '.';

    public int[][] createNeighbourHood(char[][] board) {
        var width = board.length;
        var height = board[0].length;
        var neighbourhood = new int[width][height];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (board[i][j] == EMPTY_SPOT) {
                    neighbourhood[i][j] = Integer.MAX_VALUE;
                    continue;
                }

                var left = 0;
                var right = 0;
                var up = 0;
                var down = 0;
                var upLeft = 0;
                var upRight = 0;
                var downLeft = 0;
                var downRight = 0;

                if (j - 1 >= 0) {
                    left = board[i][j - 1] == PAPER_ROLL ? 1 : 0;
                }

                if (j + 1 < height) {
                    right = board[i][j + 1] == PAPER_ROLL ? 1 : 0;
                }

                if (i - 1 >= 0) {
                    up = board[i - 1][j] == PAPER_ROLL ? 1 : 0;
                }

                if (i + 1 < width) {
                    down = board[i + 1][j] == PAPER_ROLL ? 1 : 0;
                }

                if (i - 1 >= 0 && j - 1 >= 0) {
                    upLeft = board[i - 1][j - 1] == PAPER_ROLL ? 1 : 0;
                }

                if (i - 1 >= 0 && j + 1 < height) {
                    upRight = board[i - 1][j + 1] == PAPER_ROLL ? 1 : 0;
                }

                if (i + 1 < width && j - 1 >= 0) {
                    downLeft = board[i + 1][j - 1] == PAPER_ROLL ? 1 : 0;
                }

                if (i + 1 < width && j + 1 < height) {
                    downRight = board[i + 1][j + 1] == PAPER_ROLL ? 1 : 0;
                }

                neighbourhood[i][j] = left + right + up + down + upLeft + upRight + downLeft + downRight;
            }
        }

        return neighbourhood;
    }

    public int countFreeRolls(int[][] input) {
        int result = 0;

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] < 4) {
                    result++;
                }
            }
        }

        return result;
    }

    public char[][] createBoard(List<String> lines) {
        return lines.stream().map(String::toCharArray).toArray(char[][]::new);
    }

    public int calculateFreeRolls(List<String> lines) {
        var board = createBoard(lines);
        var totalFreeRolls = 0;
        int numberOfFreeRolls = 0;

        do {
            var neighbourhood = createNeighbourHood(board);
            numberOfFreeRolls = removeFreeRolls(neighbourhood, board);
            totalFreeRolls += numberOfFreeRolls;

            System.out.println("Number of free rolls: " + numberOfFreeRolls);

        } while (numberOfFreeRolls != 0);

        return totalFreeRolls;
    }

    public int removeFreeRolls(int[][] neighbourhood, char[][] board) {
        int result = 0;

        for (int i = 0; i < neighbourhood.length; i++) {
            for (int j = 0; j < neighbourhood[0].length; j++) {
                if (neighbourhood[i][j] < 4) {
                    board[i][j] = EMPTY_SPOT;
                    result++;
                }
            }
        }

        return result;

    }


    public static void main(String[] args) {
        var lines = FileUtils.readLines("/day4.txt");
        var sut = new Part1();
        var result = sut.calculateFreeRolls(lines);

        System.out.println(result);
    }

}




