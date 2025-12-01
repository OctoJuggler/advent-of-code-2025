package org.octojuggler;

import com.google.common.io.CharStreams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class SolutionDayOne {

    public static final int STARTING_POSITION = 50;
    public static final String INPUT_FILE = "/day1.txt";

    List<String> readLines() throws IOException {
        try (var inputStream = this.getClass().getResourceAsStream(INPUT_FILE)) {

            if (inputStream == null) {
                throw new RuntimeException("Unable to find resource: " + INPUT_FILE);
            }

            var reader = new BufferedReader(new InputStreamReader(inputStream));
            return CharStreams.readLines(reader);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    int parseLine(String line) {
        var trimmedLine = line.trim();
        var numberAsString = trimmedLine.substring(1);
        var number = Integer.parseInt(numberAsString);

        return trimmedLine.charAt(0) == 'R' ? number : -number;
    }

    int normalize(int value) {
        if (value < 0) {
            return normalize(value + 100);
        }

        if (value > 99) {
            return normalize(value - 100);
        }

        return value;
    }

    int turnTheDial(List<String> lines) {
        var value = STARTING_POSITION;
        var zeroCount = 0;

        for (var line : lines) {
            var turns = parseLine(line);
            value += turns;

            value = normalize(value);


            if (value < 0 || value > 99) {
                throw new RuntimeException("Value is out of range: " + value);
            }

            if (value == 0) {
                zeroCount++;
            }

            System.out.printf("Position of the dial is %d after: %s \n", value, line);
        }

        return zeroCount;
    }

    public static void main(String[] args) throws IOException {
        var solution = new SolutionDayOne();
        var lines = solution.readLines();

        var result = solution.turnTheDial(lines);
        System.out.println("Number of times the dial was 0: " + result);

    }
}
