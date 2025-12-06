//package org.octojuggler;
//
//
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class ClickTests {
//
//    @Test
//    public void fromZeroTurningLeft10() throws Exception {
//
//        var sut = new SolutionDayOne();
//        var result = sut.turnTheDialOnce(new State(0, 0, 0), "L10");
//
//        assertThat(result.getZeroClicks()).isEqualTo(0);
//    }
//
//    @Test
//    public void from10TurningLeft10() throws Exception {
//
//        var sut = new SolutionDayOne();
//        var result = sut.turnTheDialOnce(new State(10, 0, 0), "L10");
//
//        assertThat(result.getZeroClicks()).isEqualTo(1);
//    }
//
//    @Test
//    public void fromZeroTurningLeft100() throws Exception {
//
//        var sut = new SolutionDayOne();
//        var result = sut.turnTheDialOnce(new State(0, 0, 0), "L100");
//
//        assertThat(result.getZeroClicks()).isEqualTo(1);
//    }
//
//    @Test
//    public void from10TurningLeft100() throws Exception {
//
//        var sut = new SolutionDayOne();
//        var result = sut.turnTheDialOnce(new State(10, 0, 0), "L100");
//
//        assertThat(result.getZeroClicks()).isEqualTo(1);
//    }
//
//
//    @Test
//    public void fromZeroTurningRight10() throws Exception {
//
//        var sut = new SolutionDayOne();
//        var result = sut.turnTheDialOnce(new State(0, 0, 0), "R10");
//
//        assertThat(result.getZeroClicks()).isEqualTo(0);
//    }
//
//    @Test
//    public void fromZeroTurningRight100() throws Exception {
//
//        var sut = new SolutionDayOne();
//        var result = sut.turnTheDialOnce(new State(0, 0, 0), "R100");
//
//        assertThat(result.getZeroClicks()).isEqualTo(1);
//    }
//
//
//}
