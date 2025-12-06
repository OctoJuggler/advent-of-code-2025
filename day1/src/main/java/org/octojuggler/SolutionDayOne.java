package org.octojuggler;

import org.octojuggler.utils.FileUtils;

import java.io.IOException;

record Result(int x, int y) {
}

class State {
    public static final int STARTING_POSITION = 50;

    private final int dialPosition;
    private final int zeroCount;
    private final int zeroCrossings;

    State() {
        this(STARTING_POSITION, 0, 0);
    }

    public State(int dialPosition, int zeroCount, int zeroClicks) {
        this.dialPosition = dialPosition;
        this.zeroCount = zeroCount;
        this.zeroCrossings = zeroClicks;
    }

    public int getDialPosition() {
        return dialPosition;
    }

    public int getZeroCount() {
        return zeroCount;
    }

    public int getZeroCrossings() {
        return zeroCrossings;
    }

    public int getZeroClicks() {
        return zeroCrossings;
    }

    public State merge(State other) {
        return new State(dialPosition, zeroCount + other.zeroCount, zeroCrossings + other.zeroCrossings);
    }

    @Override
    public String toString() {
        return "Dial Position: %d, Zero Count: %d, Zero Clicks: %d".formatted(this.dialPosition, this.zeroCount, this.getZeroClicks());
    }

}


public class SolutionDayOne extends AbstractSolution{

    Result normalize(int value, int zeroClicks) {
        if (value < 0) {
            return normalize(value + 100, zeroClicks + 1);
        }

        if (value > 99) {
            return normalize(value - 100, zeroClicks + 1);
        }

        if (value == 0) {
            return new Result(value, zeroClicks);
        }

        return new Result(value, zeroClicks);
    }

    State turnTheDialOnce(State state, String line) {
        var value = state.getDialPosition();

        var turns = parseLine(line);
        value += turns;

        var result = normalize(value, 0);
        value = result.x();

        if (value < 0 || value > 99) {
            throw new RuntimeException("Value is out of range: " + value);
        }

        var zeroCrossings = result.y();

        if (state.getDialPosition() == 0 && zeroCrossings > 0) {
            zeroCrossings = zeroCrossings - 1;
        }

        return new State(
                value,
                value == 0 ? state.getZeroCount() + 1 : state.getZeroCount(),
                state.getZeroCrossings() + zeroCrossings
        );

    }



    public static void main(String[] args) throws IOException {
        var solution = new SolutionDayOne();
        var lines = FileUtils.readLines("/day1.txt");

        var result = solution.turnTheDial(lines);
        System.out.println(result);

    }
}
