package org.octojuggler;

public record Range(long start, long end) {
    @Override
    public String toString() {
        return "Range{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
