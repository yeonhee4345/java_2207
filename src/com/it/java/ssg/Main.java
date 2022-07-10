package com.it.java.ssg;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		Scanner scan = new Scanner(System.in);
		System.out.printf("명령어를 입력하세요 : ");
		String command = scan.next();
		System.out.println("입력된 명령어 : "+command);
		int num = scan.nextInt();
		System.out.println("입력된 명령어 : "+num);
		scan.close();
		System.out.println("== 프로그램 끝 ==");
	}

}
