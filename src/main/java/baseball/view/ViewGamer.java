package baseball.view;

import baseball.domain.Gamer;
import nextstep.utils.Console;

import static baseball.Message.MESSAGE_INPUT_NUMBER;

public class ViewGamer {
    public static Gamer userInput() {
        System.out.print(MESSAGE_INPUT_NUMBER);
        String inputNumbers = Console.readLine();
        try {
            return Gamer.create(inputNumbers);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return userInput();
        }
    }
}
