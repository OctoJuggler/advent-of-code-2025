package org.octojuggler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SymmetricPairTest {

    @Test
    public void testSymmetricPairs() {
        var box1 = new Box(1, 2, 3);
        var box2 = new Box(4, 5, 6);

        var sut1 = new SymmetricPair(1, 2, box1, box2);
        var sut2 = new SymmetricPair(2, 1,box2, box1);

        assertEquals(sut1, sut2);
    }

    @Test
    public void testSymmetricPairsHashCode() {
        var box1 = new Box(1, 2, 3);
        var box2 = new Box(4, 5, 6);

        var sut1 = new SymmetricPair(1,2,box1, box2);
        var sut2 = new SymmetricPair(2,1,box2, box1);

        assertEquals(sut1.hashCode(), sut2.hashCode());
    }

    @Test
    public void testDistanceTo() {
        var box1 = new Box(81164, 26649, 91136);
        var box2 = new Box(63580, 92883, 7773);

        assertThat(box1.distanceTo(box2)).isEqualTo(0.0);
    }
}