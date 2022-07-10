package com.it.java.ssg;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		Scanner scan = new Scanner(System.in);
		int lastid=0;
		while(true) {
			System.out.printf("명령어를 입력하세요 : ");
			String command = scan.nextLine();
			command = command.trim();
			if(command.length()==0){
				continue;
			}
			if(command.equals("exit")) {
				break;
			}
			if(command.equals("article write")) {
				lastid++;
				System.out.printf("제목 : ");
				String title = scan.nextLine();
				System.out.printf("내용 : ");
				String body = scan.nextLine();
				System.out.printf("%d번 글이 생성되었습니다.\n",lastid);
				
			}
			else if(command.equals("article list")) {
				if(lastid>0) {
					System.out.printf("%d개의 게시글이 있습니다\n",lastid);
				}
				else {
					System.out.println("게시글이 없습니다.");
				}
			}
			else {
				System.out.printf("%s는 존재하지 않는 명령어입니다.\n",command);
			}
		}
		
		scan.close();
		System.out.println("== 프로그램 끝 ==");
	}

}
