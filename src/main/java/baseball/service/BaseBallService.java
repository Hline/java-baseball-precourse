package baseball.service;

import baseball.utils.ConsoleStream;

public class BaseBallService {
	
	ConsoleStream consoleStream = new ConsoleStream();

	static int[] playBoard;
	static int MAX_RANGE = 11;
	static int strikePoint;
	static int ballPoint;

	public void playGames() {
		boolean endPlayYN = false;
		while (endPlayYN == false) {
			// 임의의 숫자 만들기
			playBoard = new int[MAX_RANGE];
			for (int i = 1; i <= 3;) {
				int num = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1, 9);
				if (playBoard[num] != 0)
					continue;
				else
					playBoard[num] = i++;
			}

			// 점수계산
			boolean strikeYN = false;
			while (strikeYN == false) {
				consoleStream.write("숫자를 입력해주세요 : ");
				String input = consoleStream.readLine();
				// 입력검증
				if (input.matches("\\d{3}") == false)
					throw new IllegalArgumentException();
				strikePoint = 0;
				ballPoint = 0;
				for (int i = 1; i <= 3; i++) {
					int num = Character.getNumericValue(input.charAt(i - 1));
					if (playBoard[num] == i)
						strikePoint++;
					else if (playBoard[num] > 0)
						ballPoint++;
				}

				String userMessage = (ballPoint + strikePoint == 0 ? "낫싱"
						: (ballPoint > 0 ? ballPoint + "볼 " : "") + (strikePoint > 0 ? strikePoint + "스트라이크" : ""));
				consoleStream.writeLine(userMessage);
				if (strikePoint == 3) {
					strikeYN = true;
					consoleStream.writeLine("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
					consoleStream.writeLine("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"); // 여기서 이상한 값입력할 경우 예외 확인

					endPlayYN = (Integer.parseInt(consoleStream.readLine()) == 2);
				}
			}
		}
	}

}
