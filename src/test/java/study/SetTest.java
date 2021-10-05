package study;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SetTest {

    private Set<Integer> numbers;
    private static final int INIT_SIZE = 3;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("요구사항1")
    @Description("numbers 의 size 를 확인하는 테스트.")
    public void findNumbersSize() {
        int size = numbers.size();
        assertThat(size).isEqualTo(INIT_SIZE);
    }

    @DisplayName("요구사항2")
    @Description("numbers 에 1,2,3의 문자열이 포함하는지 확인한다.")
    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "1,2,3,4,5",
            "3,2,1",
            "1,2,3,4,5,6,7,8,9",
    })
    public void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("요구사항2")
    @Description("numbers 에 1,2,3의 문자열이 포함하는지 확인하는 테스트.")
    @ParameterizedTest
    @CsvSource({
            "4,5",
            "6,7,8,3"
    })
    public void contains2(int number) {
        assertNotEquals(numbers,number);
    }

    @DisplayName("요구사항3")
    @Description("입력값에 따라 결과값이 달라지는 경우도 확인해보는 테스트.")
    @ParameterizedTest
    @CsvSource({
            "1,true",
            "2,true",
            "3,true",
            "4,false",
            "5,false"
    })
    public void contains3(int number,boolean isTrue) {
        assertThat(numbers.contains(number)).isEqualTo(isTrue);
    }
}