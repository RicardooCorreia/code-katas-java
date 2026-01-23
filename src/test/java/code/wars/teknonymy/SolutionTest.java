package code.wars.teknonymy;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void teknonymize_whenPersonWithoutChild_shouldNotSetTeknonym() {

        // Given
        final Person input = new Person("a", 'm', new Person[0], LocalDateTime.of(1000, 1, 1, 0, 0));

        // When
        Solution.teknonymize(input);

        // Then
        assertThat(input.teknonym)
                .isEmpty();
    }

    @Test
    void teknonymize_whenPersonWithThreeChildren_shouldSetTeknonymAsFatherOfOldest() {

        // Given
        final Person example = getExample(false);
        final Person input = example.children[2];
        input.parent = null;

        // When
        Solution.teknonymize(input);

        // Then
        assertThat(input.teknonym)
                .isEqualTo("father of e");
    }

    @Test
    void teknonymize_whenFamilyTree_shouldSetTeknonymsForAllGenerations() {

        // Given
        final Person input = getExample(false);

        // When
        Solution.teknonymize(input);

        // Then
        assertThat(input.teknonym)
                .isEqualTo("grandfather of e");
        assertThat(input.children[0].teknonym)
                .isEqualTo("mother of h");
        assertThat(input.children[2].teknonym)
                .isEqualTo("father of e");
    }

    @Test
    void teknonymize_whenGreatGrandfather_shouldSetTeknonymWithGreatPrefix() {

        // Given
        final Person input = getExample(true);
        input.children[2].children[2].children[0] = new Person("i", 'm', new Person[0], LocalDateTime.of(1060, 1, 1, 0, 0));
        input.children[2].children[2].children[1] = new Person("j", 'm', new Person[0], LocalDateTime.of(1058, 1, 1, 0, 0));
        input.children[2].children[2].children[0].parent = input.children[2].children[2];
        input.children[2].children[2].children[1].parent = input.children[2].children[2];

        // When
        Solution.teknonymize(input);

        // Then
        assertThat(input.teknonym)
                .isEqualTo("great-grandfather of j");
        assertThat(input.children[0].teknonym)
                .isEqualTo("mother of h");
        assertThat(input.children[2].teknonym)
                .isEqualTo("grandfather of j");
        assertThat(input.children[2].children[2].teknonym)
                .isEqualTo("mother of j");
    }

    @Test
    void teknonymize_whenUnorderedChildren_shouldSetTeknonymBasedOnOldest() {

        // Given
        final Person input = new Person(
                "d", 'm',
                new Person[]{
                        new Person("g", 'm', new Person[0], LocalDateTime.of(1046, 1, 1, 0, 0)),
                        new Person("f", 'f', new Person[0], LocalDateTime.of(1043, 1, 1, 0, 0)),
                        new Person("e", 'f', new Person[0], LocalDateTime.of(1045, 1, 1, 0, 0)),
                },
                LocalDateTime.of(1023, 11, 28, 0, 0)
        );
        input.children[0].parent = input;
        input.children[1].parent = input;
        input.children[2].parent = input;

        // When
        Solution.teknonymize(input);

        // Then
        assertThat(input.teknonym)
                .isEqualTo("father of f");
    }

    private static Person getExample(final boolean big) {

        final Person person = new Person(
                "a", 'm',
                new Person[]{
                        new Person(
                                "b", 'f',
                                new Person[]{
                                        new Person("h", 'f', new Person[0], LocalDateTime.of(1047, 1, 1, 0, 0))
                                },
                                LocalDateTime.of(1020, 1, 1, 0, 0)
                        ),
                        new Person("c", 'm', new Person[0], LocalDateTime.of(1021, 2, 1, 0, 0)),
                        new Person(
                                "d", 'm',
                                new Person[]{
                                        new Person("g", 'm', new Person[0], LocalDateTime.of(1046, 1, 1, 0, 0)),
                                        new Person("f", 'f', new Person[0], LocalDateTime.of(1045, 1, 1, 0, 0)),
                                        new Person("e", 'f', new Person[big ? 2 : 0], LocalDateTime.of(1043, 1, 1, 0, 0)),
                                },
                                LocalDateTime.of(1023, 11, 28, 0, 0)
                        ),
                },
                LocalDateTime.of(1000, 1, 1, 0, 0)
        );

        person.children[0].parent = person;
        person.children[1].parent = person;
        person.children[2].parent = person;

        person.children[0].children[0].parent = person.children[0];

        person.children[2].children[0].parent = person.children[2];
        person.children[2].children[1].parent = person.children[2];
        person.children[2].children[2].parent = person.children[2];

        return person;
    }

}
