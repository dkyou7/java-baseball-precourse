package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Rule.SIZE_OF_DIGITS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    private List<String> baseball;

    @BeforeEach
    void setup() {
        baseball = new Computer().generateRandomNumber();
    }

    @Test
    @DisplayName("생성된 숫자 크기를 확인하는 테스트.")
    void checkNumbersSize() {
        assertEquals(SIZE_OF_DIGITS, baseball.size());
    }

    @Test
    @DisplayName("생성된 숫자가 중복되는지 확인하는 테스트.")
    void isDuplicate() {
        assertThat(checkIsDuplicate()).isTrue();
    }

    private boolean checkIsDuplicate() {
        Set<String> nonDuplicateNumbers = new HashSet<>(baseball);
        return nonDuplicateNumbers.size() == SIZE_OF_DIGITS;
    }

}