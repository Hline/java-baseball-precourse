package baseball;

import baseball.service.BaseBallService;

public class Application {
	
	public static void main(String[] args) {
		new BaseBallService().playGames();
	}
}
