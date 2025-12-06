package org.octojuggler;

import java.util.List;


public abstract class AbstractSolution {

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
