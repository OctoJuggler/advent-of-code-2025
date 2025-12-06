package org.octojuggler;

import org.octojuggler.utils.FileUtils;

import java.math.BigInteger;
import java.util.*;

class Range implements Comparable<Range> {
    public long min;
    public long max;

    public Range(long min, long max) {
        this.min = min;
        this.max = max;

        if(min > max) throw new IllegalArgumentException("min > max");
    }

    public boolean contains(long value) {
        return value >= min && value <= max;
    }

    public long size() {
        return max - min + 1;
    }

    @Override
    public int compareTo(Range o) {
        return Long.compare(this.min, o.min);
    }

    public Optional<Range> merge(Range other) {
        if(this.contains(other.min) && this.contains(other.max)) {
           return Optional.of(new Range(this.min, this.max));
        }

        if(this.contains(other.min) && ! this.contains(other.max)) {
            return Optional.of(new Range(this.min, other.max));
        }

        if(!this.contains(other.min) && this.contains(other.max)) {
            return Optional.of(new Range(other.min, this.max));
        }

        return Optional.empty();

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Range range = (Range) o;
        return min == range.min && max == range.max;
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }

    @Override
    public String toString() {
        return "Range{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }

    public static Range from(String input) {
        var parts = input.split("-");
        return new Range(Long.parseLong(parts[0].trim()), Long.parseLong(parts[1].trim()));
    }

}

record RangesAndIds(List<Range> ranges, List<Long> ids) {
    @Override
    public List<Range> ranges() {
        return new LinkedList<>(ranges);
    }
}

public class Part1 {

    public RangesAndIds parseInput() {
        List<Range> ranges = new LinkedList<>();
        List<Long> ids = new ArrayList<>();

        List<String> lines =  FileUtils.readLines("/day5.txt");

        var foundEmptyLine = false;

        for (var line: lines) {

            if(line.trim().isEmpty()) {
                foundEmptyLine = true;
                continue;
            }

            if(!foundEmptyLine) {
                ranges.add(Range.from(line));
            }

            if(foundEmptyLine) {
               ids.add(Long.parseLong(line));
            }
        }

        return new RangesAndIds(ranges, ids);
    }

    public List<Range> mergeRanges(List<Range> input) {
        var ranges = new LinkedList<>(input);
        ranges.sort(Range::compareTo);

        var mergedRanges = new LinkedList<Range>();

        var firstRange = ranges.remove(0);

        while(!ranges.isEmpty()) {

            var secondRange = ranges.remove(0);

            var mergeResult = firstRange.merge(secondRange);

            if (mergeResult.isPresent()) {
                firstRange = mergeResult.get();
            } else {
                mergedRanges.add(firstRange);
                firstRange = secondRange;
            }
        }

        mergedRanges.add(firstRange);

        return mergedRanges;
    }

    public BigInteger caculateNumberOfFreshIds(List<Range> ranges) {
        var numberOfFreshIds = BigInteger.ZERO;

        var x = mergeRanges(ranges);

        for (var range: x) {
            numberOfFreshIds = numberOfFreshIds.add(BigInteger.valueOf(range.size()));
        }

        return numberOfFreshIds;
    }

    public static void main(String[] args) {
       var sut = new Part1();
       var result = sut.parseInput();

       System.out.println(sut.caculateNumberOfFreshIds(result.ranges()));
    }

}




