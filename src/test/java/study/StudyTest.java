package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.junit.platform.commons.util.StringUtils;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;
import static org.junit.jupiter.params.provider.EnumSource.Mode.MATCH_ALL;

public class StudyTest {

    @DisplayName("각 String이 빈칸을 포함하고 있는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "race car", "you dong kwan", "able was I ere I saw elba" })
    void containsWhitespace(String candidate) {
        assertTrue(StringUtils.containsWhitespace(candidate));
    }

    @DisplayName("각 정수가 범위 내에 포함되어있는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9 })
    void testWithValueSource(int argument) {
        assertTrue(0 < argument && argument < 10);
    }

    @DisplayName("비어있는 경우 테스트")
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n" })
    void nullEmptyAndBlankStrings(String text) {
        assertTrue(text == null || text.trim().isEmpty());
    }

    @DisplayName("NullAndEmptySource 기능 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { " ", "   ", "\t", "\n" })
    void nullEmptyAndBlankStrings2(String text) {
        assertTrue(text == null || text.trim().isEmpty());
    }

    @DisplayName("EnumSource 기능 테스트")
    @ParameterizedTest
    @EnumSource
    void testWithEnumSourceWithAutoDetection(ChronoUnit unit) {
        assertNotNull(unit);
    }

    @DisplayName("EnumSource 기능 테스트 - 포함하는 경우")
    @ParameterizedTest
    @EnumSource(names = { "DAYS", "HOURS" })
    void testWithEnumSourceInclude(ChronoUnit unit) {
        assertTrue(EnumSet.of(ChronoUnit.DAYS, ChronoUnit.HOURS).contains(unit));
    }

    @DisplayName("EnumSource 기능 테스트 - 제외시킨 경우")
    @ParameterizedTest
    @EnumSource(mode = EXCLUDE, names = { "DAYS", "HOURS" })
    void testWithEnumSourceExclude(ChronoUnit unit) {
        assertFalse(EnumSet.of(ChronoUnit.DAYS, ChronoUnit.HOURS).contains(unit));
    }

    @DisplayName("EnumSource 기능 테스트 - 정규식 표현하기")
    @ParameterizedTest
    @EnumSource(mode = MATCH_ALL, names = "^.*DAYS$")
    void testWithEnumSourceRegex(ChronoUnit unit) {
        assertTrue(unit.name().endsWith("DAYS"));
    }

    @DisplayName("함수명을 입력하면 함수 내부 값을 가져와준다.")
    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithExplicitLocalMethodSource(String argument) {
        assertNotNull(argument);
    }

    static Stream<String> stringProvider() {
        return Stream.of("apple", "banana");
    }

    @DisplayName("이름이 같으면 생략해도 된다.")
    @ParameterizedTest
    @MethodSource
    void testWithExplicitLocalMethodSource2(String argument) {
        assertNotNull(argument);
    }

    static Stream<String> testWithExplicitLocalMethodSource2() {
        return Stream.of("apple", "banana");
    }

    @DisplayName("INT 자료형도 가능")
    @ParameterizedTest
    @MethodSource("range")
    void testWithRangeMethodSource(int argument) {
        assertNotEquals(0, argument);
    }

    // skip : 몇개를 버릴 것인지 알려주는 메서드
    static IntStream range() {
        return IntStream.range(0, 20).skip(1);
    }

    @DisplayName("다양한 param을 넣어 테스트")
    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    void testWithMultiArgMethodSource(String str, int num, List<String> list) {
        assertEquals(5, str.length());
        assertTrue(num >=1 && num <=2);
        assertEquals(2, list.size());
    }

    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                arguments("apple", 1, Arrays.asList("a", "b")),
                arguments("lemon", 2, Arrays.asList("x", "y"))
        );
    }

    @DisplayName(",로 구분된 테스트")
    @ParameterizedTest
    @CsvSource({
            "apple,         1",
            "banana,        2",
            "'lemon, lime', 0xF1"
    })
    void testWithCsvSource(String fruit, int rank) {
        assertNotNull(fruit);
        assertNotEquals(0, rank);
    }

    @DisplayName(",로 구분된 세가지 경우가 다 1-9 내에 있는지 테스트")
    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "4,7,5",
    })
    void testWithCsvSource2(int first, int second,int third) {
        assertTrue(0 < first && first < 10);
        assertTrue(0 < second && second < 10);
        assertTrue(0 < third && third < 10);
    }

    @Test
    @DisplayName("assertj 기초")
    void a_few_simple_assertions() {
        assertThat("The Lord of the Rings")
                .isNotNull()
                .startsWith("The")
                .contains("Lord")
                .endsWith("Rings");

        // basic assertions
        assertThat("Frodo").isEqualTo("Frodo");
        assertThat("Frodo").isNotEqualTo("sauron");

        // chaining string specific assertions
        assertThat("Frodo").startsWith("Fro")
                .endsWith("do")
                .isEqualToIgnoringCase("frodo");

        // collection specific assertions (there are plenty more)
        // in the examples below fellowshipOfTheRing is a List<TolkienCharacter>
        assertThat(Arrays.asList("frodo","sam"))
                .hasSize(2)
                .contains("frodo")
                .containsExactly("frodo","sam")
                .doesNotContain("sauron");

        // as() is used to describe the test and will be shown before the error message
        assertThat(33).as("check %s's age", "Frodo").isEqualTo(33);

        // exception assertion, standard style ...
        assertThatThrownBy(() -> { throw new Exception("boom!"); }).hasMessage("boom!");

        // assertThat methods come from WithAssertions - no static import needed
        assertThat("Frodo").isEqualTo("Frodo").isNotEqualTo("Frodon");

        assertThat("Frodo").isIn(Arrays.asList("Frodo","Sam"));
        assertThat("Frodo").isIn("Frodo", "Frodo2", "Frodo3");
        assertThat("sauron").isNotIn(Arrays.asList("frodo","sam"));
        assertThat("sauron").isNotIn("Frodo", "Frodo2", "Frodo3");

        //assertThat(frodo).matches(p -> p.age > 30 && p.getRace() == HOBBIT);
        //assertThat(frodo.age).matches(p -> p > 30);
    }
}
