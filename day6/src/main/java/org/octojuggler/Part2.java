package org.octojuggler;

import org.octojuggler.utils.FileUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.math.BigInteger.ZERO;

public class Part2 {

    public List<String> split(String input, int[] lengths) {
        var result = new ArrayList<String>();

        var value = input;
        for (int i = 0; i < lengths.length; i++) {
            var length = lengths[i];

            var substring = value.substring(0, length);
            result.add(substring);

            if( result.size() != lengths.length) {
                value = value.substring(length + 1);
            }

        }

        return result;
    }

    public List<Operation> parseInput(List<String> lines) {

        List<String[]> parsedInput = lines.stream().map(x -> x.trim().split("\\s+")).toList();

        var numberOfColumns = parsedInput.get(0).length;
        var numberOfRows = parsedInput.size();

        var maxColumnLength = new int[numberOfColumns];

        for (int i = 0; i < numberOfColumns; i++) {
            for (int j = 0; j < numberOfRows; j++) {
                var length = parsedInput.get(j)[i].length();
                maxColumnLength[i] = Math.max(maxColumnLength[i], length);
            }
        }

        var paddedInput = lines.stream().map(x -> split(x, maxColumnLength)).toList();

        var result = new ArrayList<Operation>();

        for (int i = 0; i < numberOfColumns; i++) {
            var values = new LinkedList<String>();

            for (int j = 0; j < numberOfRows; j++) {
                if (j != numberOfRows - 1) {
                    values.add(paddedInput.get(j).get(j));
                } else {
                    var designator = paddedInput.get(j).get(i).trim();

                    if ("+".equals(designator)) {
                        result.add(new Add(values));
                    } else {
                        result.add(new Multiply(values));
                    }
                }
            }
        }

        return result;
    }

    public BigInteger evaluate(List<Operation> operations) {
        return operations.stream().map(Operation::evaluate).reduce(ZERO, BigInteger::add);
    }

    public static void main(String[] args) {
        char[][] lines = FileUtils.readLines("/day6.txt").stream()
                .map(String::toCharArray)
                .toArray(char[][]::new);

        var numberList = new ArrayList<String>();
        var operationList = new ArrayList<Operation>();

        var emptyColumn = true;
        char operation = ' ';

        for (int j = 0; j < lines[0].length; j++) {
            var builder = new StringBuilder();

            for (int i = 0; i < lines.length; i++) {

                if( i < lines.length - 1) {
                    builder.append(lines[i][j]);
                }

                if( i == lines.length - 1 && emptyColumn) {
                    operation = lines[i][j];
                }
            }

            var number = builder.toString().trim();

            if(number.isEmpty()) {
                if('+' == operation) {
                    operationList.add(new Add(numberList));
                } else {
                    operationList.add(new Multiply(numberList));
                }
                numberList.clear();
            } else {
                numberList.add(number);
            }

            emptyColumn = number.isEmpty();
        }

        if('+' == operation) {
            operationList.add(new Add(numberList));
        } else {
            operationList.add(new Multiply(numberList));
        }
        numberList.clear();

        var result = operationList.stream().map(Operation::evaluate).reduce(ZERO, BigInteger::add);
        System.out.println(result);
    }

}




