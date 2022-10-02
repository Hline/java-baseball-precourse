package baseball;

import baseball.utils.UserInputBaseBallNumberValidator;
import baseball.utils.UserInputGameStatusNumberValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserInputBaseBallNumberTest {

    @Test
    void 사용자입력값테스트_세자리수_정상케이스(){
        new UserInputBaseBallNumberValidator("123").isValidValue();
        new UserInputBaseBallNumberValidator("987").isValidValue();
    }

    @Test
    void 사용자입력값테스트_세자리수_길이오류(){
        Assertions.assertThrows(IllegalArgumentException.class
            , () -> {
                new UserInputBaseBallNumberValidator("1234").isValidValue();
            }
        );
    }

    @Test
    void 사용자입력값테스트_세자리수_범위오류(){
        Assertions.assertThrows(IllegalArgumentException.class
            , () -> {
                new UserInputBaseBallNumberValidator("012").isValidValue();
            }
        );
    }

    @Test
    void 사용자입력값테스트_세자리수_중복오류(){
        Assertions.assertThrows(IllegalArgumentException.class
            , () -> {
                new UserInputBaseBallNumberValidator("112").isValidValue();
            }
        );
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