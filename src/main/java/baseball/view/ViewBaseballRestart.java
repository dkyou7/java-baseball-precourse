package baseball.view;

import baseball.Message;
import nextstep.utils.Console;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static baseball.Message.*;

public class ViewBaseballRestart {

	private final static Map<String, Boolean> selectOption = new HashMap<>();

	static {
		selectOption.put("1", true);
		selectOption.put("2", false);
	}

	public static boolean selectRestart() {
		System.out.println(MESSAGE_RESTART);
		String inputSelect = Console.readLine();
		try {
			return validateInputSelect(inputSelect);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return selectRestart();
		}
	}

	private static boolean validateInputSelect(String inputSelect) {
		Boolean isRestart = selectOption.get(inputSelect);
		if (Objects.isNull(isRestart)) {
			throw new IllegalArgumentException(invalidInputMsg(MESSAGE_VALIDATE_RESTART));
		}
		return isRestart;
	}
}
