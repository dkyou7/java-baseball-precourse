package baseball.domain;

import nextstep.utils.Randoms;

import java.util.*;

import static baseball.Rule.SIZE_OF_DIGITS;
import static baseball.Rule.MIN_NUMBER;
import static baseball.Rule.MAX_NUMBER;

public class Computer {
    public List<String> generateRandomNumber() {
        List<String> randomNumberSet = new ArrayList<>();
        while (randomNumberSet.size() < SIZE_OF_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            randomNumberSet.add(String.valueOf(randomNumber));
        }
        return new ArrayList<>(randomNumberSet);
    }
}
