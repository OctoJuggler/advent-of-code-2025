package org.octojuggler;

import org.octojuggler.utils.FileUtils;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class Part2 {

    private static final int NUMBER_OF_BATTERIES = 12;

    public static void main(String[] args) throws IOException {
        List<String> banks = FileUtils.readLines("/day3.txt");

        BigInteger sum = banks.stream()
                .map(String::trim)
                .map(Part2::maxBatterySelection)
                .map(BigInteger::new)
                .reduce(BigInteger.ZERO, BigInteger::add);

        System.out.println(sum);
    }

    // Entry point for the recursion
    private static String maxBatterySelection(String bank) {
        return select(bank, 0, NUMBER_OF_BATTERIES);
    }


    private static String select(String bank, int startIndex, int remaining) {
        if (remaining == 0) {
            return "";
        }

        int maxSearchIndex = bank.length() - remaining;

        char bestDigit = bank.charAt(startIndex);
        int bestIndex = startIndex;

        for (int i = startIndex; i <= maxSearchIndex; i++) {
            char c = bank.charAt(i);
            if (c > bestDigit) {
                bestDigit = c;
                bestIndex = i;
            }
        }

        return bestDigit + select(bank, bestIndex + 1, remaining - 1);
    }

}
