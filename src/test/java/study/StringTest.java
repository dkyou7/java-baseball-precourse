package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    private static final int ERROR_INDEX = 999;

    @Test
    @DisplayName("요구사항1")
    public void confirmSplitByString() {
        String originalString = "1,2";
        String[] splitString = originalString.split(",");

        assertThat(splitString).contains("1", "2");
        assertThat(splitString).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항1")
    public void returnSplitByArray() {
        String originalString = "1";
        String[] splitString = originalString.split(",");

        assertThat(splitString).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2")
    void substring() {
        String originalString = "(1,2)";
        String updatedString = originalString.substring(1,4);
        assertThat(updatedString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3")
    void outOfRangeError() {
        String originalString = "abc";
        assertThatThrownBy(() -> originalString.charAt(ERROR_INDEX))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}