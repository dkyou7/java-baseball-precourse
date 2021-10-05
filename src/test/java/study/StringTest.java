package study;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    private static final int ERROR_INDEX = 999;

    @Test
    @DisplayName("요구사항1")
    @Description("1,2를 ,로 split 했을때 분리되는지 테스.")
    public void confirmSplitByString() {
        String originalString = "1,2";
        String[] splitString = originalString.split(",");

        assertThat(splitString).contains("1", "2");
        assertThat(splitString).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항1")
    @Description("1 을 ,로 split 했을때 1만을 포함하는 배열이 반환되는지 테스트.")
    public void returnSplitByArray() {
        String originalString = "1";
        String[] splitString = originalString.split(",");

        assertThat(splitString).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2")
    @Description("(1,2)에서 괄호를 제거한 결과가 나와야한다.")
    void substring() {
        String originalString = "(1,2)";
        String updatedString = originalString.substring(1,4);
        assertThat(updatedString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3")
    @Description("문자열 범위를 벗어나면 에러가 발생한다.")
    void outOfRangeError() {
        String originalString = "abc";
        assertThatThrownBy(() -> originalString.charAt(ERROR_INDEX))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}