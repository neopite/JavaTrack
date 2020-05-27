package com.company.lab4;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class JournalUtil {
    public static double avgOfArray(int[] arrayOfMarks) {
        return Arrays.stream(arrayOfMarks)
                .average()
                .orElse(Double.NaN);
    }

    public static Map<String, int[]> findBadStudents(Map<String, int[]> students) {
        return students
                .entrySet()
                .stream()
                .filter(x -> avgOfArray(x.getValue()) <= 6)
                .collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
