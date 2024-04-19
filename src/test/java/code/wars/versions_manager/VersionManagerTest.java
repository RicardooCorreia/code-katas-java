package code.wars.versions_manager;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class VersionManagerTest {

    @CsvSource(textBlock = """
                '', 0.0.1
                1.2.3, 1.2.3
                1.2.3.4, 1.2.3
                1.2.3.d, 1.2.3
                1, 1.0.0
                1.1, 1.1.0
            """)
    @ParameterizedTest
    void release_validateInitialization(String version, String expected) {

        // Given
        VersionManager versionManager = new VersionManager(version);

        // When
        String result = versionManager.release();

        // Then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void release_setDefaultVersion() {

        // Given
        VersionManager versionManager = new VersionManager();

        // When
        String release = versionManager.release();

        // Then
        assertThat(release)
                .isEqualTo("0.0.1");
    }

    @Test
    void release_whenIncreasedMajor_return1Major() {

        // Given
        VersionManager versionManager = new VersionManager();

        // When
        String release = versionManager
                .major()
                .release();

        // Then
        assertThat(release)
                .isEqualTo("1.0.0");
    }

    @Test
    void release_whenIncreasedMajorSecondTime_return2Major() {

        // Given
        VersionManager versionManager = new VersionManager("1.2.3");

        // When
        String release = versionManager
                .major()
                .release();

        // Then
        assertThat(release)
                .isEqualTo("2.0.0");
    }

    @Test
    void releaseAndMinor_whenDefault_returnMinor() {

        // Given
        VersionManager versionManager = new VersionManager();

        // When
        String release = versionManager
                .minor()
                .release();

        // Then
        assertThat(release)
                .isEqualTo("0.1.0");
    }

    @Test
    void releaseAndMinor_whenAlreadyHasMajor_returnMinor() {

        // Given
        VersionManager versionManager = new VersionManager("1");

        // When
        String release = versionManager
                .minor()
                .release();

        // Then
        assertThat(release)
                .isEqualTo("1.1.0");
    }

    @Test
    void releaseAndMinor_whenAlreadyHasPatch_returnMinor() {

        // Given
        VersionManager versionManager = new VersionManager("1.2.3");

        // When
        String release = versionManager
                .minor()
                .release();

        // Then
        assertThat(release)
                .isEqualTo("1.3.0");
    }

    @Test
    void releaseAndPatch_whenHasVersion_returnPatch() {

        // Given
        VersionManager versionManager = new VersionManager("4");

        // When
        String release = versionManager.patch().patch().release();

        // Then
        assertThat(release)
                .isEqualTo("4.0.2");
    }

    @Test
    void rollback_whenHasPreviousVersion_returnPrevious() {

        // Given
        VersionManager versionManager = new VersionManager();

        // When
        String release = versionManager
                .major()
                .rollback()
                .release();

        // Then
        assertThat(release).isEqualTo("0.0.1");
    }

    @Test
    void rollback_whenMultipleRollbacks_returnPrevious() {

        // Given
        VersionManager versionManager = new VersionManager();

        // When
        String release = versionManager.major().patch().rollback().rollback().release();

        // Then
        assertThat(release).isEqualTo("0.0.1");
    }

    @ValueSource(strings = {"a", "a.b.c", "1.a", "0.1.a.5"})
    @ParameterizedTest
    void initialization_whenInvalid_returnException(
            // Given
            String version) {

        // When
        ThrowableAssert.ThrowingCallable executable = () -> new VersionManager(version);

        // Then
        assertThatExceptionOfType(Exception.class).isThrownBy(executable);
    }

    @Test
    void rollback_whenHasNoVersion_throwException() {

        // Given
        VersionManager versionManager = new VersionManager();

        // When
        ThrowableAssert.ThrowingCallable executable = versionManager::rollback;

        // Then
        assertThatExceptionOfType(Exception.class).isThrownBy(executable);
    }
}
