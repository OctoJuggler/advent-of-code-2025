package org.octojuggler;

import org.octojuggler.utils.FileUtils;

import java.util.*;

public class Part2 {

    public static void main(String[] args) {
        var lines = FileUtils.readLines("/day8.txt");

        var boxes = lines.stream().map(Box::from).toList();

        var distances = new TreeMap<SymmetricPair, Double>();

        var groups = new HashMap<Box, LinkedHashSet<Box>>();

        for(int i = 0; i < boxes.size(); i++ ) {
            for(int j = 0; j < boxes.size(); j++) {

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

        Stack<SymmetricPair> stack = new Stack<>();
        LinkedHashSet<Box> lastUpdatedGroup = new LinkedHashSet<>();

        for(Map.Entry<SymmetricPair, Double> entry : distances.entrySet()) {

            if(lastUpdatedGroup.size() == boxes.size()) {
                break;
            }

            var pair = entry.getKey();

            var box1 = pair.getBox1();
            var box2 = pair.getBox2();

            if(!groups.containsKey(box1) && !groups.containsKey(box2)) {
                LinkedHashSet<Box> group = new LinkedHashSet<>();
                group.add(box1);
                group.add(box2);

                groups.put(box1, group);
                groups.put(box2, group);

                lastUpdatedGroup = group;
            }
            else if(groups.containsKey(box1) && !groups.containsKey(box2)) {
                LinkedHashSet<Box> group = groups.get(box1);
                group.add(box2);

                groups.put(box2, group);

                lastUpdatedGroup = group;
            }
            else if(groups.containsKey(box2) && !groups.containsKey(box1)) {
                LinkedHashSet<Box> group = groups.get(box2);
                group.add(box1);

                groups.put(box1, group);

                lastUpdatedGroup = group;
            }
            else {
                var group1 = groups.get(box1);
                var group2 = groups.get(box2);

                LinkedHashSet<Box> newGroup = new LinkedHashSet<>(group1);
                newGroup.addAll(group2);

                for (Box box : newGroup) {
                    groups.put(box, newGroup);
                }

                lastUpdatedGroup = newGroup;
            }

            stack.push(pair);
        }

        var last = stack.pop();

        var box1 = last.getBox1();
        var box2 = last.getBox2();

        System.out.println(box1.x * box2.x);

        return;
    }


}




