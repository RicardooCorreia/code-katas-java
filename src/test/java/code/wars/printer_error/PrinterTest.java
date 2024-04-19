package code.wars.printer_error;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrinterTest {

    @Test
    public void printerError_printNumberOfErrors() {

        // Given
        final String input = "aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz";

        // When
        final String result = Printer.printerError(input);

        // Then
        assertThat(result)
                .isEqualTo("3/56");
    }
}
