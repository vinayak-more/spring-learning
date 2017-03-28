package main;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class MainClass {

	static int factor = 15;

	public static void main(String[] args) {
		MainClass main = new MainClass();
		main.encode(factor);
		main.decode(factor);
	}

	public void encode(int factor) {
		InputStream is = MainClass.class.getResourceAsStream("/file.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(
					"E:/SpringProject/encode.txt", true));
			while (is.available() > 0) {
				int c = is.read();
				if ((c >= 65 && c <= 90)) {
					c -= 65;
					c = (c + factor) % 26;
					c += 65;
				} else if (c >= 97 && c <= 122) {
					c -= 97;
					c = (c + factor) % 26;
					c += 97;
				}
				System.out.print((char) c);
				bw.write(c);
			}
			bw.flush();
			bw.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void decode(int factor) {
		try {
			InputStream is = new FileInputStream("E:/SpringProject/encode.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(
					"E:/SpringProject/decode.txt", true));
			while (is.available() > 0) {
				int c = is.read();
				if ((c >= 65 && c <= 90)) {
					c -= 65;
					c = Math.abs(c + 26 - factor) % 26;
					c += 65;
				} else if (c >= 97 && c <= 122) {
					c -= 97;
					c = Math.abs(c + 26 - factor) % 26;
					c += 97;
				}
				System.out.print((char) c);
				bw.write(c);
			}
			bw.flush();
			bw.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
