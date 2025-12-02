package org.octojuggler;

import com.google.common.io.CharStreams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public abstract class AbstractSolution {

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

    public State turnTheDial(List<String> lines) {
        var state = new State();

        for (var line : lines) {
            state = turnTheDialOnce(state, line);
            System.out.println("Turn: %s, %s ".formatted(line, state));
        }

        return state;
    }

    abstract State turnTheDialOnce(State state, String line);

}
