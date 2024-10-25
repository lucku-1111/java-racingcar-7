package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.error.ErrorMessages;

public class InputParser {
    private InputParser() {
    }

    public static List<String> parseCarNames(String carNamesInput) {
        List<String> carNames = Arrays.stream(carNamesInput.split(",")).toList();

        validateCarNames(carNames);
        return (carNames);
    }

    public static int parseRounds(String roundsInput) {
        validateRounds(roundsInput);
        return Integer.parseInt(roundsInput);
    }

    private static void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(ErrorMessages.TOO_LONG_NAME.getMessage());
            }
        }
    }

    private static void validateRounds(String roundsInput) {
        int rounds;

        try {
            rounds = Integer.parseInt(roundsInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_NOT_NUMBER.getMessage());
        }
        if (rounds <= 0) {
            throw new IllegalArgumentException(ErrorMessages.NEGATIVE_NUMBER.getMessage());
        }
    }
}
