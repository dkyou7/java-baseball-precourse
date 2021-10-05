package baseball.view;

import baseball.domain.Computer;

import java.util.List;

public class ViewComputer {
    public static List<String> generateRandomNumber(){
        return new Computer().generateRandomNumber();
    }
}
