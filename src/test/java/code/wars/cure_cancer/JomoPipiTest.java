package code.wars.cure_cancer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JomoPipiTest {

    @Test
    public void mutationLocation_whenSmallMatrix_returnCorrectResult() {

        // Given
        char[][] input = {
                "thisIsAsmallerPerson".toCharArray(),
                "thisIsAsmallerPerson".toCharArray(),
                "thisIsAsmallerPerson".toCharArray(),
                "thisssAsmallerPerson".toCharArray()
        };

        // When
        int[] result = JomoPipi.mutationLocation(input);

        // Then
        assertThat(result)
                .isEqualTo(new int[]{3, 4});

    }

    @Test
    public void mutationLocation_whenLargeMatrix_returnCorrectResult() {

        // Given
        char[][] input = {
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuff1thinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray()
        };

        // When
        int[] result = JomoPipi.mutationLocation(input);

        // Then
        assertThat(result)
                .isEqualTo(new int[]{9, 14});
    }

    @Test
    public void mutationLocation_whenWrongDignose_returnEmtpyArray() {

        // Given
        char[][] input = {
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray(),
                "someGreaTstuffIthinkThisIs".toCharArray()
        };

        // When
        int[] result = JomoPipi.mutationLocation(input);

        // Then
        assertThat(result)
                .isEqualTo(new int[0]);
    }
}
