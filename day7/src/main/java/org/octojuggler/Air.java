package org.octojuggler;

public class Air extends State {
    public Air(int position) {
        super(position);
    }



    public static Air from(int position) {
        return new Air(position);
    }
}
