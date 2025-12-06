package org.octojuggler;

import com.google.common.collect.Lists;
import org.octojuggler.utils.FileUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

record Result(
    int value,
    int index
){}


public class Part1 {

    public List<Integer> transformIntoArray(String line) {
        var result = new ArrayList<Integer>();

        for (int i = 0; i < line.length(); i++) {
            result.add(Integer.parseInt(line.substring(i, i + 1)));
        }

        return result;
    }

    public long maxJoltage(List<String> lines) {
        return lines.stream().map(this::maxJoltageForLine)
                .reduce(0l, Long::sum);
    }

    public void findLargestBatteryIn(List<Integer> batteries, List<Integer> fragments) {
        var selected = 0;
        var switchedOn = new boolean[batteries.size()];

        for (int i = 0; i < batteries.size(); i++) {
            switchedOn[i]=false;
        }

        outer: for(int i = 9; i >= 0; i--) {
            for (int j = batteries.size() -1 ; j >= 0; j--) {
                if(selected == 12) {
                    break outer;
                }
                if (batteries.get(j) == i) {
                    switchedOn[j] = true;
                    selected++;
                }
            }
        }

        return;
    }

    public long maxJoltageForLine(String line) {
        var fragments = new ArrayList<Integer>();

        var batteries = transformIntoArray(line);
        findLargestBatteryIn(batteries, fragments);

        StringBuilder buffer = new StringBuilder();
        for (var fragment : fragments) {
            buffer.append(fragment);
        }

        return Long.parseLong(buffer.toString());
    }

    public static void main(String[] args) {
        var lines = FileUtils.readLines("/day3.txt");
        var sut = new Part1();
        System.out.println(sut.maxJoltage(lines));
    }

}




