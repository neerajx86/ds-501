package arraystrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

public class IsUnique {


    static boolean isUnique(String sentence) {
        char[] characters = sentence.toCharArray();
        Arrays.sort(characters);

        for (int i = 0, j = 1; j < characters.length; i++, j++) {
            if (characters[i] == characters[j]) {
                return false;
            }
        }
        return true;
    }

    @Test
    void testIsUnique1() {
        String[] sentences = new String[]{
                "quick brown fox, jumps over the lazy dog.",
                "track ques"
        };

        boolean[] results = new boolean[]{
                false,
                true
        };

        for (int i = 0; i < sentences.length; i++) {
            assertEquals(IsUnique.isUnique(sentences[i]), results[i]);
        }
    }

}