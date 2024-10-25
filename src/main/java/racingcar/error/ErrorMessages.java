package racingcar.error;

public enum ErrorMessages {
    TOO_LONG_NAME("자동차 이름은 5자 이하만 가능합니다."),
    INPUT_NOT_NUMBER("입력값은 숫자만 가능합니다"),
    NEGATIVE_NUMBER("양수만 입력 가능합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
