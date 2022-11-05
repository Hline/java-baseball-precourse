package baseball.utils;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleStream {
	BufferedWriter bw;

	public ConsoleStream() {
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}

	public void write(String text) {
		try {
			bw.write(text);
			bw.flush();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void writeLine(String text) {
		write(text + "\n");
	}

	private void close() {
		try {
			bw.flush();
			bw.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String readLine() {
		return Console.readLine();
	}

}
