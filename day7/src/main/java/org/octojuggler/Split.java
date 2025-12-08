package org.octojuggler;

public class Split extends State {
    public Split(int position) {
        super(position);
    }

    public static Split from(int position) {
        return new Split(position);
    }
}
