package baseball.controller;

import baseball.domain.BaseballResult;
import baseball.domain.Gamer;
import baseball.domain.Manager;
import baseball.view.ViewBaseballRestart;
import baseball.view.ViewBaseballResult;
import baseball.view.ViewComputer;
import baseball.view.ViewGamer;

import java.util.List;

public class GameController {
    public void start() {
        List<String> computer = ViewComputer.generateRandomNumber();
        System.out.println("computer = " + computer);
        boolean isAnswer;
        do {
            Gamer gamer = ViewGamer.userInput();
            BaseballResult matchResult = Manager.match(computer, gamer);
            ViewBaseballResult.printMatchResult(matchResult);
            isAnswer = matchResult.isPerfect();
        } while (!isAnswer);
        reStart();
    }

    public void reStart() {
        if (ViewBaseballRestart.selectRestart()) {
            start();
        }
    }
}
