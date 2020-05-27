package com.company.lab4;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

final class JournalGenerator {

    private static final Random RANDOM = new Random();
    private static final int COUNT_OF_MARKS_IN_JOURNAL = 10;

    static Map<String, int[]> generateJournal(String[] namesOfStudens) {
        Map<String, int[]> journal = new HashMap<>();
        for (String namesOfStuden : namesOfStudens) {
            journal.put(namesOfStuden, generateMarks());
        }

        return journal;
    }

    private static int[] generateMarks() {
        return IntStream.generate(() -> RANDOM.nextInt(12))
                .limit(COUNT_OF_MARKS_IN_JOURNAL)
                .toArray();
    }
}
