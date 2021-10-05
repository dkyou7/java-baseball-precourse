package baseball.domain;

import java.util.List;

import static baseball.Rule.SIZE_OF_DIGITS;

public class Manager {
    public static BaseballResult match(List<String> computer, Gamer gamer) {
        BaseballResult baseballResult = new BaseballResult();
        for(int index = 0; index < SIZE_OF_DIGITS; index++){
            String number = computer.get(index);
            baseballResult.plusStrike(checkStrike(number,gamer.getBaseballNumbers(),index));
            baseballResult.plusBall(checkBall(number,gamer.getBaseballNumbers(),index));
        }
        return baseballResult;
    }
    public static int checkStrike(String number, List<String> baseballNumbers, int index) {
        if(baseballNumbers.get(index).equals(number)){
            return 1;
        }
        return 0;
    }
    public static int checkBall(String number, List<String> baseballNumbers, int index) {
        if(!baseballNumbers.get(index).equals(number) && baseballNumbers.contains(number)){
            return 1;
        }
        return 0;
    }
}
