package org.octojuggler;

import java.util.Objects;

public class Box {
    long x;
    long y;
    long z;

    public Box(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Box from(String input) {
        var fragments = input.split(",");

        var x = Long.parseLong(fragments[0]);
        var y = Long.parseLong(fragments[1]);
        var z = Long.parseLong(fragments[2]);

        return new Box(x, y, z);
    }

    public double distanceTo(Box other) {
        var d1 = Math.pow(x - other.x, 2);
        var d2 = Math.pow(y - other.y, 2);
        var d3 = Math.pow(z - other.z, 2);
        return Math.sqrt(d1 + d2 + d3);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return x == box.x && y == box.y && z == box.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "Box{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
