package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UniqueEmailAddressesTest {

    private final UniqueEmailAddresses.Solution subject = new UniqueEmailAddresses.Solution();

    @Test
    void numUniqueEmails_applyRules() {

        // Given
        String[] input = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};

        // When
        int result = subject.numUniqueEmails(input);

        // Then
        assertThat(result)
                .isEqualTo(2);
    }

    @Test
    void numUniqueEmails_whenNoRules_returnSetLength() {

        // Given
        String[] input = {"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"};

        // When
        int result = subject.numUniqueEmails(input);

        // Then
        assertThat(result)
                .isEqualTo(3);
    }
}