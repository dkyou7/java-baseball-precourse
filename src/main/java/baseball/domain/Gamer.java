package baseball.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Message.*;
import static baseball.Rule.*;

public class Gamer {

    private final List<String> baseballNumbers;

    public List<String> getBaseballNumbers() {
        return baseballNumbers;
    }

    private Gamer(List<String> inputNumbers) {
        validationUserInput(inputNumbers);
        this.baseballNumbers = inputNumbers;
    }

    public static Gamer create(String inputNumbers) {
        return new Gamer(Arrays.asList(inputNumbers.split("")));
    }

    public static boolean validationUserInput(List<String> source){
        validateLength(source);
        validateDuplicate(source);
        validateRegx(source);
        return true;
    }

    private static void validateRegx(List<String> source) {
        String convertSource = String.join("", source);
        if(!convertSource.matches("["+ MIN_NUMBER + "-" + MAX_NUMBER + "]"+"{" + SIZE_OF_DIGITS +"}")){
            throw new IllegalArgumentException(invalidInputMsg(MESSAGE_REGX));
        }
    }

    private static void validateDuplicate(List<String> source) {
        if(!isDuplicate(source)){
            throw new IllegalArgumentException(invalidInputMsg(MESSAGE_DUPLICATE));
        }
    }

    private static void validateLength(List<String> source) {
        if(source.size() != SIZE_OF_DIGITS){
            throw new IllegalArgumentException(invalidInputMsg(MESSAGE_LIMIT));
        }
    }

    private static boolean isDuplicate(List<String> source) {
        Set<String> converted = new HashSet<>(source);
        return converted.size() == source.size();
    }
}
