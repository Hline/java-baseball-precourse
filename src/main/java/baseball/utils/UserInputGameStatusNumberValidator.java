package baseball.utils;

public class UserInputGameStatusNumberValidator extends UserInputValidator {
    private static final int INPUT_GAME_STATUS_DIGIT = 1;
    private static final int INPUT_GAME_STATUS_MIN_NUM = 1;
    private static final int INPUT_GAME_STATUS_MAX_NUM = 2;

    public UserInputGameStatusNumberValidator(String userInputString) {
        super(userInputString);
    }

    @Override
    public void isValidValue() {
        isValidLength();
        isValidRange();
    }

    private void isValidLength(){
        if(userInputString.length() != INPUT_GAME_STATUS_DIGIT){
            throw new IllegalArgumentException(WRONG_LENGTH_MESSAGE);
        }
    }

    private void isValidRange(){
        if(Character.getNumericValue(userInputString.charAt(0)) != INPUT_GAME_STATUS_MIN_NUM
                && Character.getNumericValue(userInputString.charAt(0)) != INPUT_GAME_STATUS_MAX_NUM){
            throw new IllegalArgumentException(WRONG_NUMBER_MESSAGE);
        }
    }
}
