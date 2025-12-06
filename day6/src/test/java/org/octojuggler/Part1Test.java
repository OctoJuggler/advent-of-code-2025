package org.octojuggler;

import com.google.common.io.CharStreams;
import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.math.BigInteger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Part1Test {

    private static final String INPUT = """
           123 328  51 64\s
            45 64  387 23\s
             6 98  215 314
           *   +   *   +\s\s
           """;

    @Test
    public void test() throws Exception{
        var sut = new Part1();

        var lines = CharStreams.readLines(new StringReader(INPUT));
        var operations = sut.parseInput(lines);

        var result = sut.evaluate(operations);
        assertThat(result).isEqualTo(BigInteger.valueOf(3263827));
    }
}