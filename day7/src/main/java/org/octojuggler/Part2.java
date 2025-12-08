package org.octojuggler;

import org.octojuggler.utils.FileUtils;

import java.util.*;

public class Part2 {

    public static void main(String[] args) {
        var numberOfPaths = 1;
        var numberOfSplits = new LinkedList<Integer>();

        var lines = FileUtils.readLines("/day7.txt");

        var iterator = lines.iterator();
        var line = iterator.next();

        var startPosition = line.indexOf('S');

        var stack = new Stack<Set<State>>();
        stack.push(Set.of(Air.from(startPosition)));

        while (iterator.hasNext()) {
            line = iterator.next();

            var positions = stack.peek();
            var newPositions = new HashSet<State>();

            for (var state : positions) {
                var temp = line.toCharArray();

                if (temp[state.position] == '.') {
                    newPositions.add(Air.from(state.position));
                }

                if (temp[state.position] == '^') {
                    newPositions.add(Split.from(state.position - 1));
                    newPositions.add(Split.from(state.position + 1));
                }
            }

            numberOfSplits.add(newPositions.size());

            int x = newPositions.stream()
                    .filter(state -> state instanceof Split)
                    .map(y -> 1)
                    .reduce(0, Integer::sum);

            numberOfPaths = numberOfPaths + x;
//            var isAir = newPositions.stream().allMatch(state -> state instanceof Air);
//
//            if (!isAir) {
//                numberOfPaths = numberOfPaths + newPositions.size();
//            }
//
            stack.push(newPositions);
        }

        System.out.println(numberOfPaths);
        System.out.println(numberOfSplits);
    }


}




