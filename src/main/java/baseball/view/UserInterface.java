package baseball.view;

import baseball.Constants.UserInterfaceMessage;
import camp.nextstep.edu.missionutils.Console;

public class UserInterface {

    public static String askUserInputBaseBallNumber(){
        System.out.print(UserInterfaceMessage.USER_INPUT_BASEBALL_MSG);
        return Console.readLine();
    }

    public static String askUserInputGameStatusNumber(){
        System.out.println(UserInterfaceMessage.USER_INPUT_GAME_STATUS_MSG);
        return Console.readLine();
    }

}
