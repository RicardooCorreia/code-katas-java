package code.wars.calculate_bmi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateTest {

    @Test
    void bmi_whenUnderweight_returnUnder() {

        // Given
        int weight = 50;
        double height = 1.8;

        // When
        String result = Calculate.bmi(weight, height);

        // Then
        assertThat(result)
                .isEqualTo("Underweight");
    }

    @Test
    void bmi_whenNormal_returnNormal() {

        // Given
        int weight = 80;
        double height = 1.8;

        // When
        String result = Calculate.bmi(weight, height);

        // Then
        assertThat(result)
                .isEqualTo("Normal");
    }

    @Test
    void bmi_whenOverweight_returnOverweight() {

        // Given
        int weight = 90;
        double height = 1.8;

        // When
        String result = Calculate.bmi(weight, height);

        // Then
        assertThat(result)
                .isEqualTo("Overweight");
    }

    @Test
    void bmi_whenObese_returnObese() {

        // Given
        int weight = 100;
        double height = 1.8;

        // When
        String result = Calculate.bmi(weight, height);

        // Then
        assertThat(result)
                .isEqualTo("Obese");
    }
}
