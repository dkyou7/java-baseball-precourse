package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.Message.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GamerTest {

    @Test
    @DisplayName("값이 잘 생성되었는지 확인하는 테스트.")
    void init(){
        assertThat(Gamer.create("123")).isNotNull();
    }

    @Test
    @DisplayName("길이가 3보다 적을 경우 발생하는 에러 테스트.")
    void validateLength() {
        assertThatThrownBy(() -> Gamer.create("12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MESSAGE_LIMIT);
    }

    @Test
    @DisplayName("길이가 3보다 많을 경우 발생하는 에러 테스트.")
    void validateLength2() {
        assertThatThrownBy(() -> Gamer.create("12345"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MESSAGE_LIMIT);
    }

    @Test
    @DisplayName("값이 중복되었을 경우 발생하는 에러 테스트.")
    void validateDuplicate(){
        assertThatThrownBy(() -> Gamer.create("222"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MESSAGE_DUPLICATE);
    }

    @Test
    @DisplayName("값이 정규식에 맞지 않을 경우 발생하는 에러 테스트.")
    void validateRegx(){
        assertThatThrownBy(() -> Gamer.create("s23"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MESSAGE_REGX);
    }
}