package code.wars.easy_balance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EasyBalTest {

    @Test
    void balance_whenSimpleTransactions_returnFormattedBalance() {

        // Given
        final String book = """
                1000.00!=
                001 Market !=:125.45
                126 Hardware =34.95
                127 Video! 7.45
                128 Book :14.32
                129 Gasoline ::16.10""";

        // When
        final String result = EasyBal.balance(book);

        // Then
        final String expected = "" +
                "Original Balance: 1000.00\\r\\n" +
                "001 Market 125.45 Balance 874.55\\r\\n" +
                "126 Hardware 34.95 Balance 839.60\\r\\n" +
                "127 Video 7.45 Balance 832.15\\r\\n" +
                "128 Book 14.32 Balance 817.83\\r\\n" +
                "129 Gasoline 16.10 Balance 801.73\\r\\n" +
                "Total expense  198.27\\r\\n" +
                "Average expense  39.65";
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void balance_whenComplexTransactionsWithSpecialCharacters_returnFormattedBalance() {

        // Given
        final String book = """
                1233.00
                125 Hardware;! 24.80?
                123 Flowers 93.50;
                127 Meat 120.90
                120 Picture 34.00
                124 Gasoline 11.00
                123 Photos;! 71.40?
                122 Picture 93.50
                132 Tyres;! 19.00,?;
                129 Stamps; 13.60
                129 Fruits{} 17.60
                129 Market;! 128.00?
                121 Gasoline;! 13.60?""";

        // When
        final String result = EasyBal.balance(book);

        // Then
        final String expected = """
                Original Balance: 1233.00\\r\\n125 Hardware 24.80 Balance 1208.20\\r\\n123 Flowers 93.50 Balance 1114.70\\r\\n127 Meat 120.90 Balance 993.80\\r\\n120 Picture 34.00 Balance 959.80\\r\\n124 Gasoline 11.00 Balance 948.80\\r\\n123 Photos 71.40 Balance 877.40\\r\\n122 Picture 93.50 Balance 783.90\\r\\n132 Tyres 19.00 Balance 764.90\\r\\n129 Stamps 13.60 Balance 751.30\\r\\n129 Fruits 17.60 Balance 733.70\\r\\n129 Market 128.00 Balance 605.70\\r\\n121 Gasoline 13.60 Balance 592.10\\r\\nTotal expense  640.90\\r\\nAverage expense  53.41""";
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    void balance_whenEmptyString_returnFormattedBalance() {

        // Given
        final String book = """
                1078.00
                001 Books  71.41\s
                002 Meat ;! 17.00 ?;
                003 Picture ;! 12.22 ?;
                004 Grocery ;! 34.00 ?;
                005 Market  34.00\s
                006 Picture ;! 24.81 ?;""";

        // When
        final String result = EasyBal.balance(book);

        // Then
        final String expected = """
                Original Balance: 1233.00\\r\\n125 Hardware 24.80 Balance 1208.20\\r\\n123 Flowers 93.50 Balance 1114.70\\r\\n127 Meat 120.90 Balance 993.80\\r\\n120 Picture 34.00 Balance 959.80\\r\\n124 Gasoline 11.00 Balance 948.80\\r\\n123 Photos 71.40 Balance 877.40\\r\\n122 Picture 93.50 Balance 783.90\\r\\n132 Tyres 19.00 Balance 764.90\\r\\n129 Stamps 13.60 Balance 751.30\\r\\n129 Fruits 17.60 Balance 733.70\\r\\n129 Market 128.00 Balance 605.70\\r\\n121 Gasoline 13.60 Balance 592.10\\r\\nTotal expense  640.90\\r\\nAverage expense  53.41""";
        assertThat(result)
                .isEqualTo(expected);
    }
}
