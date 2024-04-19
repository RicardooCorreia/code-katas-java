package code.wars.fix_me_hello;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DinglemouseTest {

    @Test
    public void hello_baseTest() {

        // Given
        Dinglemouse dm = new Dinglemouse().setName("Bob").setAge(27).setSex('M');

        // When
        String result = dm.hello();

        // Then
        String expected = "Hello. My name is Bob. I am 27. I am male.";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void hello_keepsOrder() {

        // Given
        Dinglemouse dm = new Dinglemouse().setAge(27).setSex('M').setName("Bob");

        // When
        String result = dm.hello();

        // Then
        String expected = "Hello. I am 27. I am male. My name is Bob.";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void hello_whenFemale_returnCorrect() {

        // Given
        Dinglemouse dm = new Dinglemouse().setName("Alice").setSex('F');

        // When
        String result = dm.hello();

        // Then
        String expected = "Hello. My name is Alice. I am female.";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void hello_whenJustHaveName_returnCorrect() {

        // Given
        Dinglemouse dm = new Dinglemouse().setName("Batman");

        // When
        String result = dm.hello();

        // Then
        String expected = "Hello. My name is Batman.";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void hello_whenMultipleSets_assumeLastValue() {

        // Given
        Dinglemouse dm = new Dinglemouse().setName("Batman").setSex('F').setSex('M').setAge(31).setAge(27);

        // When
        String result = dm.hello();

        // Then
        String expected = "Hello. My name is Batman. I am male. I am 27.";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void hello_whenEmpty_returnEmpty() {

        // Given
        Dinglemouse dm = new Dinglemouse();

        // When
        String result = dm.hello();

        // Then
        String expected = "Hello.";
        assertThat(result).isEqualTo(expected);
    }
}
