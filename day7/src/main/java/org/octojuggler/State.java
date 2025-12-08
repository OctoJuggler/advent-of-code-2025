package org.octojuggler;

import java.util.Objects;

public abstract class State {
    final int position;

    public State(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return position == state.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }
}
