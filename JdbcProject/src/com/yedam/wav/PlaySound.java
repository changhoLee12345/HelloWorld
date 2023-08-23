package com.yedam.wav;

import java.io.File;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlaySound {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		Thread music = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					File a = new File("src/com/yedam/wav/sample.wav");
					AudioInputStream b = AudioSystem.getAudioInputStream(a);
					Clip c = AudioSystem.getClip();
					c.open(b);
					c.start();
					// Thread.sleep(c.getMicrosecondLength() / 1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		music.start();

		boolean run = true;
		while (run) {
			System.out.println("1.add 2.list 3.mail 4.exit");
			System.out.println(">> ");
			int menu = scn.nextInt();
			scn.nextLine();
			switch (menu) {
			case 1:
				System.out.println("addddddd");
				break;
			case 2:
				System.out.println("listtttttt");
				break;
			case 3:
				mailing();
				break;
			case 4:
				System.out.println("terminating prog.");
				run = false;
			}
		}
		System.out.println("end of prog.");
	} // end of main.

	static void mailing() {
		System.out.print("수신자메일: ");
		String to = scn.nextLine();
		System.out.print("제목: ");
		String title = scn.nextLine();
		System.out.print("내용: ");
		String content = scn.nextLine();

		StringBuilder sb = new StringBuilder();
		sb.append("<p>비밀번호 초기화 안내 메일</p>");
		sb.append("<p>");
		sb.append(content);
		sb.append("</p>");
		sb.append("<b>Good Bye!!</b>");
		content = sb.toString();

		SendMail mail = new SendMail();
		mail.sendMail(to, title, content);
	}
}
