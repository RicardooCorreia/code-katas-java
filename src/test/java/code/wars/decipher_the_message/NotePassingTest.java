package code.wars.decipher_the_message;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NotePassingTest {

    @Test
    void should_returnEmptyString_when_decipheringEmptyNote() {
        // given
        String encoded = "";

        // when
        String result = NotePassing.decipher(encoded);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    void should_correctlyDecipherLowerCaseLetters() {
        // given
        String encoded = "lvahhe bl lh uhkbgz b vtg'm uxebxox maxkx tkx lh ftgr ahnkl exym";

        // when
        String result = NotePassing.decipher(encoded);

        // then
        assertThat(result).isEqualTo("school is so boring i can't believe there are so many hours left");
    }

    @Test
    void should_correctlyDecipherUpperCaseLetters() {
        // given
        String encoded = "HFZ FTR RHNK WKXLL BL LH VNMX";

        // when
        String result = NotePassing.decipher(encoded);

        // then
        assertThat(result).isEqualTo("OMG MAY YOUR DRESS IS SO CUTE");
    }

    @Test
    void should_preservePunctuation_when_decipheringNote() {
        // given
        String encoded = "Axr Ftr! Pabva mxtvaxk wh rhn mabgd bl gbvxk, Fk. Chgxl hk Fkl. Itmxe?";

        // when
        String result = NotePassing.decipher(encoded);

        // then
        assertThat(result).isEqualTo("Hey May! Which teacher do you think is nicer, Mr. Jones or Mrs. Patel?");
    }
}