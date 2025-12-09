package advent.of.code.y2025;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class Day1SecretEntranceTest {

    public final Day1SecretEntrance subject = new Day1SecretEntrance();

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
                .isEqualTo(3);
    }

    @Test
    void shouldSolvePuzzle_whenMultipleRotations() {

        // Given
        List<String> input = List.of(
                "L1168",
                "L1130",
                "R248",
                "L105",
                "R360",
                "L1055",
                "L100001",
                "L10299",
                "R12314",
                "L182"
        );

        // When
        int result = subject.solvePuzzle(input);

        // Then
        assertThat(result)
                .isEqualTo(3);
    }

    @Test
    void shouldSolvePuzzle_puzzle() {

        // Given
        List<String> input = getLargeInput();

        // When
        int result = subject.solvePuzzle(input);

        // Then
        assertThat(result)
                .isEqualTo(964);
    }

    private static List<String> getLargeInput() {
        File file  = new File("src/test/resources/advent-of-code-2025/day1/input.txt");
        List<String> input =  new LinkedList<>();
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
