package baseball.domain;

import static baseball.Message.*;
import static baseball.Rule.SIZE_OF_DIGITS;

public class BaseballResult {

	private int strike;
	private int ball;

	public void plusStrike(int strike) {
		this.strike += strike;
	}

	public void plusBall(int ball) {
		this.ball += ball;
	}

	public boolean isPerfect() {
		return strike == SIZE_OF_DIGITS;
	}

	public String getPerfectMessage() {
		return MESSAGE_3STRIKE;
	}

	public String getResultMessage() {
		if(generateBallMessage().length()>0 && generateStrikeMessage().length()>0){
			return generateStrikeMessage() + " " + generateBallMessage();
		}
		return
				generateStrikeMessage() +
				generateBallMessage() +
				generateNothingMessage();
	}

	private String generateStrikeMessage() {
		if (strike > 0) {
			return strike + MESSAGE_STRIKE;
		}
		return "";
	}

	private String generateBallMessage() {
		if (ball > 0) {
			return ball + MESSAGE_BALL;
		}
		return "";
	}

	private String generateNothingMessage() {
		if (strike == 0 && ball == 0) {
			return MESSAGE_NOTHING;
		}
		return "";
	}
}
