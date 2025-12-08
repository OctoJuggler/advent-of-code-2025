package org.octojuggler;

import java.util.Objects;

public class SymmetricPair implements Comparable<SymmetricPair>{

    private final int index1;
    private final int index2;
    private final Box box1;
    private final Box box2;

    public SymmetricPair(int index1, int index2, Box box1, Box box2) {
        this.index1 = index1;
        this.index2 = index2;
        this.box1 = box1;
        this.box2 = box2;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SymmetricPair that = (SymmetricPair) o;
        return (Objects.equals(box1, that.box1) && Objects.equals(box2, that.box2) ) ||
                (Objects.equals(box1, that.box2) && Objects.equals(box2, that.box1));
    }

    @Override
    public int hashCode() {
        return Objects.hash(box1, box2) + Objects.hash(box2, box1);
    }

    public static SymmetricPair from(int index1, int index2, Box box1, Box box2) {
        return new SymmetricPair(index1, index2, box1, box2);
    }

    @Override
    public int compareTo(SymmetricPair o) {
        var delta1 = this.box1.distanceTo(this.box2);
        var delta2 = o.box1.distanceTo(o.box2);

        return Double.compare(delta1, delta2);
    }

    public Box getBox1() {
        return box1;
    }

    public Box getBox2() {
        return box2;
    }

    public int getIndex1() {
        return index1;
    }

    public int getIndex2() {
        return index2;
    }
}
