package baseball;

import baseball.utils.UserInputBaseBallNumberValidator;
import baseball.utils.UserInputGameStatusNumberValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserInputGameStatusNumberTest {

    @Test
    void 사용자입력값테스트_게임재시작혹은종료_정상케이스(){
        new UserInputGameStatusNumberValidator("1").isValidValue();
        new UserInputGameStatusNumberValidator("2").isValidValue();
    }

    @Test
    void 사용자입력값테스트_게임재시작혹은종료_길이오류(){
        Assertions.assertThrows(IllegalArgumentException.class
            , () -> {
                new UserInputGameStatusNumberValidator("3").isValidValue();
            }
        );
    }

    @Test
    void 사용자입력값테스트_게임재시작혹은종료_범위오류(){
        Assertions.assertThrows(IllegalArgumentException.class
            , () -> {
                new UserInputGameStatusNumberValidator("3").isValidValue();
            }
        );
    }
}