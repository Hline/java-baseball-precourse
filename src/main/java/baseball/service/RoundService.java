package baseball.service;

import baseball.domain.Round;
import baseball.view.UserInterface;
import baseball.utils.UserInputBaseBallNumberValidator;

import java.util.ArrayList;
import java.util.List;

public class RoundService {

    private final List<Integer> targetNumberList;
    private final List<Integer> userInputNumberList;

    private final Round round;

    public RoundService(List<Integer> targetNumberList){
        this.targetNumberList = targetNumberList;
        userInputNumberList = setUserInputNumberList();
        this.round = new Round();
    }

    private List<Integer> setUserInputNumberList(){
        String userInputString = UserInterface.askUserInputBaseBallNumber();
        new UserInputBaseBallNumberValidator(userInputString).isValidValue(); //expect throw if not valid

        List<Integer> userInputNumberList = new ArrayList<>();
        for(int i=0; i<userInputString.length(); i++){
            userInputNumberList.add(Character.getNumericValue(userInputString.charAt(i)));
        }
        return userInputNumberList;
    }

    public void startRound(){
        setStrikeCntAndBallCnt();
        printRoundResult();
    }

    private void setStrikeCntAndBallCnt(){
        int strikeCnt = 0;
        int ballCnt = 0;
        for(int i=0; i<userInputNumberList.size(); i++){
            if(isStrike(i)){
                strikeCnt++;
                continue;
            }
            if(isBall(i)){
                ballCnt++;
            }
        }
        round.setStrikeCnt(strikeCnt);
        round.setBallCnt(ballCnt);
    }

    private boolean isStrike(int index){
        return targetNumberList.get(index).equals(userInputNumberList.get(index));
    }

    private boolean isBall(int index){
        return targetNumberList.contains(userInputNumberList.get(index));
    }

    private void printRoundResult(){
        if(isNothing()){
            System.out.println("낫싱");
            return;
        }
        if(isWinning()){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return;
        }
        if(round.getBallCnt() > 0){
            System.out.print(round.getBallCnt()+"볼");
        }
        if(round.getStrikeCnt() > 0){
            System.out.print(round.getStrikeCnt()+"스트라이크");
        }
        System.out.println();
    }

    private boolean isNothing() {
        return round.getStrikeCnt() + round.getBallCnt() == 0;
    }

    public boolean isWinning(){
        return round.getStrikeCnt() == 3;
    }

}
