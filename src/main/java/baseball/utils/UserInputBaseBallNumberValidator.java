package baseball.utils;

import java.util.HashSet;
import java.util.Set;

public class UserInputBaseBallNumberValidator extends UserInputValidator{
    protected static final String WRONG_UNIQUE_MESSAGE = "input value contains duplicated value";
    private static final int INPUT_BASEBALL_DIGIT = 3;
    private static final int INPUT_BASEBALL_MIN_NUM = 1;
    private static final int INPUT_BASEBALL_MAX_NUM = 9;

    public UserInputBaseBallNumberValidator(String userInputString){
        super(userInputString);
    }

    @Override
    public void isValidValue(){
        isValidLength();
        isValidRange();
        isUnique();
    }

    private void isValidLength(){
        if(userInputString.length() != INPUT_BASEBALL_DIGIT){
            throw new IllegalArgumentException(WRONG_LENGTH_MESSAGE);
        }
    }

    private void isValidRange(){
        for(int i=0; i<userInputString.length(); i++){
            isLessThanMax(userInputString.charAt(i));
            isGreaterThanMin(userInputString.charAt(i));
        }
    }

    private void isLessThanMax(char inputChar){
        if('0'+INPUT_BASEBALL_MAX_NUM < inputChar){
            throw new IllegalArgumentException(WRONG_NUMBER_MESSAGE);
        }
    }

    private void isGreaterThanMin(char inputChar){
        if('0'+INPUT_BASEBALL_MIN_NUM > inputChar){
            throw new IllegalArgumentException(WRONG_NUMBER_MESSAGE);
        }
    }
    private void isUnique(){
        Set<Character> setForDuplicateCheck = new HashSet<>();
        for(int i=0; i<userInputString.length(); i++){
            setForDuplicateCheck.add(userInputString.charAt(i));
        }
        if(setForDuplicateCheck.size() != userInputString.length()){
            throw new IllegalArgumentException(WRONG_UNIQUE_MESSAGE);
        }
    }
}
