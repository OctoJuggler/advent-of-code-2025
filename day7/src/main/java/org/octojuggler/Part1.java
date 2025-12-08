package org.octojuggler;

import org.octojuggler.utils.FileUtils;

import java.util.*;

public class Part1 {

    public static void main(String[] args) {
        var numberOfSplits = 0;
        var lines = FileUtils.readLines("/day7.txt");

        var iterator = lines.iterator();
        var line = iterator.next();

        var startPosition = line.indexOf('S');

        var stack = new Stack<Set<State>>();
        stack.push(Set.of(Air.from(startPosition)));

        while(iterator.hasNext()) {
            line = iterator.next();

            var positions = stack.peek();
            var newPositions = new HashSet<State>();

            for (var state: positions) {
                var temp = line.toCharArray();

                if(temp[state.position] == '.') {
                    newPositions.add(Air.from(state.position));
                }

                if(temp[state.position] == '^') {
                    numberOfSplits++;
                    newPositions.add(Split.from(state.position - 1));
                    newPositions.add(Split.from(state.position + 1));
                }
            }

            stack.push(newPositions);
        }

        System.out.println(numberOfSplits);
    }


}




