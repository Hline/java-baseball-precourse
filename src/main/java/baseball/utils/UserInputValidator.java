package baseball.utils;

public abstract class UserInputValidator {
    protected static final String WRONG_LENGTH_MESSAGE = "input value length is wrong";
    protected static final String WRONG_NUMBER_MESSAGE = "input value number is wrong";

    protected String userInputString;

    UserInputValidator(String userInputString){
        this.userInputString = userInputString;
    }

    public abstract void isValidValue();


}
