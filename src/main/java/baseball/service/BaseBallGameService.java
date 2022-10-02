package baseball.service;

import baseball.domain.BaseBallGame;
import baseball.Constants.GameStatus;
import baseball.view.UserInterface;
import baseball.utils.UserInputGameStatusNumberValidator;
import baseball.utils.UserInputValidator;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BaseBallGameService {

    public void startBaseBallGame(){
        BaseBallGame baseBallGame = new BaseBallGame(generateTargetNumber());
        //baseBallGame.getTargetNumberList().forEach(System.out::println);
        do {
            RoundService roundService = new RoundService(baseBallGame.getTargetNumberList());
            roundService.startRound();
            if(roundService.isWinning()){
                break;
            }
        } while(GameStatus.START == baseBallGame.getGameStatus());

        if(GameStatus.START == isStartNewGame()){
            startBaseBallGame();
        }
    }

    private List<Integer> generateTargetNumber(){
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    private GameStatus isStartNewGame(){
        String userInputGameStatusString = UserInterface.askUserInputGameStatusNumber();
        UserInputValidator userInputValidator = new UserInputGameStatusNumberValidator(userInputGameStatusString);
        userInputValidator.isValidValue();  //expect throw if not valid
        int userInputGameStatus = Integer.parseInt(userInputGameStatusString);

        return GameStatus.searchKey(userInputGameStatus);
    }


}
