package advent.of.code.y2025;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class Day1SecretEntrancePart2Test {

    public final Day1SecretEntrancePart2 subject = new Day1SecretEntrancePart2();

    @Test
    void shouldSolvePuzzle() {

        // Given
        List<String> input = List.of(
                "L68",
                "L30",
                "R48",
                "L5",
                "R60",
                "L55",
                "L1",
                "L99",
                "R14",
                "L82"
        );

        // When
        int result = subject.solvePuzzle(input);

        // Then
        assertThat(result)
                .isEqualTo(6);
    }

    @Test
    void shouldSolvePuzzle_2() {

        // Given
        List<String> input = List.of(
                "R1000",    // +10 (50) 10
                "L1000",    // +10 (50) 20
                "L50",      // +1  (0)  21
                "R1",       // +0  (1)  21
                "L1",       // +1  (0)  22
                "L1",       // +0  (99) 22
                "R1",       // +1  (0)  23
                "R100",     // +1  (0)  24
                "R1"        // +0  (1)  24
        );

        // When
        int result = subject.solvePuzzle(input);

        // Then
        assertThat(result)
                .isEqualTo(24);
    }

    @Test
    void shouldSolvePuzzle_puzzle() {

        // Given
        List<String> input = getLargeInput();

        // When
        int result = subject.solvePuzzle(input);

        // Then
        assertThat(result)
                .isEqualTo(5872);
    }

    private static List<String> getLargeInput() {
        File file = new File("src/test/resources/advent-of-code-2025/day1/input.txt");
        List<String> input = new LinkedList<>();
        try (Scanner myReader = new Scanner(file)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                input.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return input;
    }
}
