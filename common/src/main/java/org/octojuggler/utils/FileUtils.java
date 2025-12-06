package org.octojuggler.utils;

import com.google.common.io.CharStreams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class FileUtils {



    public static List<String> readLines(String input) {
        try (var inputStream = FileUtils.class.getResourceAsStream(input)) {

            if (inputStream == null) {
                throw new RuntimeException("Unable to find resource: " + input);
            }

            var reader = new BufferedReader(new InputStreamReader(inputStream));
            return CharStreams.readLines(reader);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String readFile(String file) {
        try (var inputStream = FileUtils.class.getResourceAsStream(file)) {
            return CharStreams.toString(new InputStreamReader(inputStream));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
