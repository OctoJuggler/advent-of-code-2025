package org.octojuggler;

import org.octojuggler.utils.FileUtils;

import java.util.*;

public class Part1 {

    public static void main(String[] args) {
        var lines = FileUtils.readLines("/day8.txt");

        var boxes = lines.stream().map(Box::from).toList();

        var distances = new TreeMap<SymmetricPair, Double>();

        var groups = new HashMap<Box, Set<Box>>();

        for(int i = 0; i < boxes.size(); i++ ) {
            for(int j = 0; j < boxes.size(); j++) {

//                if(i == j) {
//                    continue;
//                }

                var box1 = boxes.get(i);
                var box2 = boxes.get(j);

                var pair = SymmetricPair.from(i, j, box1, box2);
                var distance = box1.distanceTo(box2);

                if(distances.containsKey(pair)) {

                    System.out.println("Duplicate pair found: " + pair);
                }
                distances.put(pair, distance);
            }
        }

        int counter = 0;

        for(Map.Entry<SymmetricPair, Double> entry : distances.entrySet()) {

            if(counter == 1000) {
                break;
            }

            var pair = entry.getKey();

            var box1 = pair.getBox1();
            var box2 = pair.getBox2();

            if(!groups.containsKey(box1) && !groups.containsKey(box2)) {
                var group = new HashSet<Box>();
                group.add(box1);
                group.add(box2);

                groups.put(box1, group);
                groups.put(box2, group);
            }
            else if(groups.containsKey(box1) && !groups.containsKey(box2)) {
                var group = groups.get(box1);
                group.add(box2);

                groups.put(box2, group);
            }
            else if(groups.containsKey(box2) && !groups.containsKey(box1)) {
                var group = groups.get(box2);
                group.add(box1);

                groups.put(box1, group);
            }
            else {
                var group1 = groups.get(box1);
                var group2 = groups.get(box2);

                Set<Box> newGroup = new HashSet<>(group1);
                newGroup.addAll(group2);

                for (Box box : newGroup) {
                    groups.put(box, newGroup);
                }

            }

            counter++;

        }


        Set<Set<Box>> uniqueGroups = new HashSet<>(groups.values());

        var sizes = uniqueGroups.stream()
                .map(Set::size)
                .sorted(Collections.reverseOrder())
                .toList();

        long result = 1;
        for(int i = 0; i < 3; i++) {
            var group = sizes.get(i);
            result = result * group;
        }

        System.out.println(result);

        return;
    }


}




