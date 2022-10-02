package baseball.ui;

import camp.nextstep.edu.missionutils.Console;

public class UserInterface {

    private static final String USER_INPUT_BASEBALL_MSG = "숫자를 입력해주세요 : ";
    private static final String USER_INPUT_GAME_STATUS_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String askUserInputBaseBallNumber(){
        System.out.println(USER_INPUT_BASEBALL_MSG);
        return Console.readLine();
    }

    public static String askUserInputGameStatusNumber(){
        System.out.println(USER_INPUT_GAME_STATUS_MSG);
        return Console.readLine();
    }

}
