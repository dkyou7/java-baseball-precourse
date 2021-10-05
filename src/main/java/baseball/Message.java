package baseball;

public class Message {
    public static final String MESSAGE_INPUT_NUMBER = "숫자를 입력해주세요: ";
    public static final String MESSAGE_ERROR = "[ERROR]";

    public static final String MESSAGE_NOTHING = "낫싱";
    public static final String MESSAGE_STRIKE = "스트라이크";
    public static final String MESSAGE_BALL = "볼";

    public static final String MESSAGE_3STRIKE = "게임 끝";
    public static final String MESSAGE_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public final static String MESSAGE_VALIDATE_RESTART = "잘못된 문자를 입력하였습니다. 다시 입력해주세요.";

    public static final String MESSAGE_LIMIT = "숫자 야구 게임은 3개만 가능합니다.";
    public static final String MESSAGE_DUPLICATE = "중복된 숫자는 입력 불가능합니다.";
    public static final String MESSAGE_REGX = "1~9 사이의 수로 3자리만 입력 가능합니다.";

    public static String invalidInputMsg(String message) {
        return String.format("%s %s",MESSAGE_ERROR,message);
    }
}
