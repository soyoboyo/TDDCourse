package org.bmc.tdd;

import java.util.List;

public class BowlingGame {

	public int getScore(List<String> rolls) {
		int result = 0;
		for (int i = 0; i < 10; i++) {
			Character firstRoll = rolls.get(i).charAt(0);
			Character secondsRoll;

			if (i < 8) {
				if (firstRoll.equals('X')) {
					result += 10;
					result += getPointsFromTwoNextRolls(rolls.get(i + 1), rolls.get(i + 2));
				} else {
					secondsRoll = rolls.get(i).charAt(1);
					int x = parseRoll(firstRoll, secondsRoll);
					result += x;
					result += parseRoll(secondsRoll, x);
					if (rolls.get(i).charAt(1) == '/') {
						result += parseRoll(rolls.get(i).charAt(0));
					}
				}
			}
			if (i == 8) {
				if (firstRoll.equals('X')) {
					result += 10;
					result += getPointsFromTwoNextRolls(rolls.get(i + 1), rolls.get(i + 1));
				} else {
					int x = parseRoll(rolls.get(8).charAt(0));
					result += x;
					result += parseRoll(rolls.get(8).charAt(1), x);
					if (rolls.get(i).charAt(1) == '/') {
						result += parseRoll(rolls.get(i).charAt(0));
					}
				}
			} else if (i == 9) {
				if (firstRoll.equals('X')) {
					result += 10;
					result += parseRoll(rolls.get(9).charAt(1));
					result += parseRoll(rolls.get(9).charAt(2), parseRoll(rolls.get(9).charAt(1)));
				} else {
					int x = parseRoll(rolls.get(9).charAt(0));
					result += x;
					result += parseRoll(rolls.get(9).charAt(1), x);
					if (rolls.get(9).length() == 3) {
						result += parseRoll(rolls.get(9).charAt(2));
					}
				}
			}
		}
		return result;
	}

	private int getPointsFromTwoNextRolls(String firstFrame, String secondFrame) {
		int sum = 0;
		if (firstFrame.charAt(0) == 'X') {
			sum += 10;
			if (secondFrame.charAt(0) == 'X') {
				sum += 10;
			} else {
				sum += Integer.parseInt(secondFrame.substring(0, 1));
			}
		} else {
			int previous = Integer.parseInt(firstFrame.substring(0, 1));
			sum += previous;
			sum += parseRoll(firstFrame.charAt(1), previous);
		}
		return sum;

	}

	private int parseRoll(Character roll, int previousRoll) {
		if (roll.equals('X')) {
			return 10;
		} else if (roll.equals('-')) {
			return 0;
		} else if (roll.equals('/')) {
			return 10 - previousRoll;
		} else {
			return Integer.parseInt(String.valueOf(roll));
		}
	}

	private int parseRoll(Character roll) {
		if (roll.equals('X')) {
			return 10;
		} else {
			return Integer.parseInt(String.valueOf(roll));
		}
	}
}

