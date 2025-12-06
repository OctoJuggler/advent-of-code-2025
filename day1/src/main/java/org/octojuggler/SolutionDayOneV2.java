package org.octojuggler;

import org.octojuggler.utils.FileUtils;

import java.io.IOException;
import java.util.List;



public class SolutionDayOneV2 extends AbstractSolution {

    State moveLeft(State state, int turns) {
        var dialPosition = state.getDialPosition();
        var zeroCount = 0;
        var zeroClicks = 0;

        for(int i = 0; i < turns; i++) {
            if(dialPosition == 0) {
                dialPosition = 99;
            } else {
                dialPosition--;
            }

            if(dialPosition == 0) {
                zeroClicks++;
            }
        }

        if (dialPosition == 0) {
            zeroCount++;
        }

        return new State(dialPosition, zeroCount, zeroClicks);
    }

    State moveRight(State state, int turns) {
        var dialPosition = state.getDialPosition();
        var zeroCount = 0;
        var zeroClicks = 0;

        for (int i = 0; i < turns; i++) {
            if (dialPosition == 99) {
                dialPosition = 0;
            } else {
                dialPosition++;
            }

            if (dialPosition == 0) {
                zeroClicks++;
            }
        }

        if (dialPosition == 0) {
            zeroCount++;
        }

        return new State(dialPosition, zeroCount, zeroClicks);
    }

    State turnTheDialOnce(State state, String line) {
        var turns = parseLine(line);

        if (turns > 0) {
            return moveRight(state, turns);
        } else if( turns < 0) {
            return moveLeft(state, -turns);
        } else {
            return state;
        }
    }

    public State turnTheDial(List<String> lines) {
        var state = new State();

        for (var line : lines) {
            var newState = turnTheDialOnce(state, line);
            state = newState.merge(state);

            System.out.println("Turn: %s, %s ".formatted(line, state));
        }

        return state;
    }

    public static void main(String[] args) throws IOException {
        var solution = new SolutionDayOneV2();
        var lines = FileUtils.readLines("/day1.txt");

        var result = solution.turnTheDial(lines);
        System.out.println(result);

    }
}
