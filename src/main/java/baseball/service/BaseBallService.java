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
			// ������ ���� �����
			playBoard = new int[MAX_RANGE];
			for (int i = 1; i <= 3;) {
				int num = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1, 9);
				if (playBoard[num] != 0)
					continue;
				else
					playBoard[num] = i++;
			}

			// �������
			boolean strikeYN = false;
			while (strikeYN == false) {
				consoleStream.write("���ڸ� �Է����ּ��� : ");
				String input = consoleStream.readLine();
				// �Է°���
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

				String userMessage = (ballPoint + strikePoint == 0 ? "����"
						: (ballPoint > 0 ? ballPoint + "�� " : "") + (strikePoint > 0 ? strikePoint + "��Ʈ����ũ" : ""));
				consoleStream.writeLine(userMessage);
				if (strikePoint == 3) {
					strikeYN = true;
					consoleStream.writeLine("3���� ���ڸ� ��� �����̽��ϴ�! ���� ����\n");
					consoleStream.writeLine("������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ���.\n"); // ���⼭ �̻��� ���Է��� ��� ���� Ȯ��

					endPlayYN = (Integer.parseInt(consoleStream.readLine()) == 2);
				}
			}
		}
	}

}
