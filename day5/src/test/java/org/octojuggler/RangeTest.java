package org.octojuggler;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RangeTest {

    private List<Range> range1 = asList(new Range(1, 2), new Range(1, 2));
    private List<Range> range2 = asList(new Range(1, 3), new Range(1, 2));
    private List<Range> range3 = asList(new Range(1, 2), new Range(2, 3));
    private List<Range> range4 = asList(new Range(1, 2), new Range(4, 5));
    private List<Range> range5 = asList(new Range(1, 1), new Range(4, 5));

    @Test
    public void test0() {
       assertThatThrownBy(() -> new Range(2, 1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void test1() {
        var sut = new Part1();
        var result = sut.mergeRanges(range1);

        assertThat(result).isEqualTo(asList(new Range(1,2)));
    }

    @Test
    public void test2() {
        var sut = new Part1();
        var result = sut.mergeRanges(range2);

        assertThat(result).isEqualTo(asList(new Range(1,3)));
    }

    @Test
    public void test3() {
        var sut = new Part1();
        var result = sut.mergeRanges(range3);

        assertThat(result).isEqualTo(asList(new Range(1,3)));
    }

    @Test
    public void test4() {
        var sut = new Part1();
        var result = sut.mergeRanges(range4);

        assertThat(result).isEqualTo(range4);
    }

    @Test
    public void test5() {
        var sut = new Part1();
        var result = sut.mergeRanges(range5);

        assertThat(result).isEqualTo(range5);
    }

    @Test
    public void test6() {
        var sut = new Part1();
        var result = sut.caculateNumberOfFreshIds(range1);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void test7() {
        var sut = new Part1();
        var result = sut.caculateNumberOfFreshIds(range5);

        assertThat(result).isEqualTo(3);
    }
}