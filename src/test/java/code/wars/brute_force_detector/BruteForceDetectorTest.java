package code.wars.brute_force_detector;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BruteForceDetectorTest {

    @Test
    void detectBruteForce_whenThreeConsecutiveFailures_returnSuspiciousIps() {

        // Given
        String[] input = {"192.168.1.1 LOGIN_FAIL user=admin", "192.168.1.1 LOGIN_FAIL user=admin", "192.168.1.1 LOGIN_FAIL user=admin"};

        // When
        List<String> results = BruteForceDetector.detectBruteForce(input);

        // Then
        assertThat(results)
                .containsExactlyInAnyOrder("192.168.1.1");
    }

    @Test
    void detectBruteForce_whenSuccessResetsCounter_returnEmpty() {

        // Given
        String[] input = {"10.0.0.5 LOGIN_FAIL user=x", "10.0.0.5 LOGIN_FAIL user=x", "10.0.0.5 LOGIN_SUCCESS user=x", "10.0.0.5 LOGIN_FAIL user=x"};

        // When
        List<String> results = BruteForceDetector.detectBruteForce(input);

        // Then
        assertThat(results).isEmpty();
    }

    @Test
    void detectBruteForce_whenMixedTrafficWithOnlySomeIpsFailing_returnOnlyFailedIps() {

        // Given
        String[] input = {"1.1.1.1 LOGIN_FAIL user=a", "2.2.2.2 LOGIN_FAIL user=b", "1.1.1.1 LOGIN_FAIL user=a", "2.2.2.2 LOGIN_SUCCESS user=b", "1.1.1.1 LOGIN_FAIL user=a", "2.2.2.2 LOGIN_FAIL user=b"};

        // When
        List<String> results = BruteForceDetector.detectBruteForce(input);

        // Then
        assertThat(results)
                .containsExactlyInAnyOrder("1.1.1.1");
    }

    @Test
    void detectBruteForce_whenIpHasMultipleStreaks_returnIpOnlyOnce() {

        // Given
        String[] input = {"5.5.5.5 LOGIN_FAIL user=x", "5.5.5.5 LOGIN_FAIL user=x", "5.5.5.5 LOGIN_FAIL user=x", "5.5.5.5 LOGIN_SUCCESS user=x", "5.5.5.5 LOGIN_FAIL user=x", "5.5.5.5 LOGIN_FAIL user=x", "5.5.5.5 LOGIN_FAIL user=x"};

        // When
        List<String> results = BruteForceDetector.detectBruteForce(input);

        // Then
        assertThat(results)
                .containsExactlyInAnyOrder("5.5.5.5");
    }

    @Test
    void detectBruteForce_whenEmptyInput_returnEmpty() {

        // Given
        String[] input = {};

        // When
        List<String> results = BruteForceDetector.detectBruteForce(input);

        // Then
        assertThat(results).isEmpty();
    }

    @Test
    void detectBruteForce_whenMultipleIpsDetected_returnSortedAlphabetically() {

        // Given
        String[] input = {"9.9.9.9 LOGIN_FAIL user=a", "1.1.1.1 LOGIN_FAIL user=b", "9.9.9.9 LOGIN_FAIL user=a", "1.1.1.1 LOGIN_FAIL user=b", "9.9.9.9 LOGIN_FAIL user=a", "1.1.1.1 LOGIN_FAIL user=b"};

        // When
        List<String> results = BruteForceDetector.detectBruteForce(input);

        // Then
        assertThat(results)
                .containsExactly("1.1.1.1", "9.9.9.9");
    }
}

