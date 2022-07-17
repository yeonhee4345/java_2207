package com.it.java.ssg;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		Scanner scan = new Scanner(System.in);
		int lastid=0;
		
		List<Article> articles = new ArrayList<>();
		
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
				int id = lastid+1;
				lastid = id;
				System.out.printf("제목 : ");
				String title = scan.nextLine();
				System.out.printf("내용 : ");
				String body = scan.nextLine();
				Article article = new Article(id, title, body);
				articles.add(article);
				System.out.printf("%d번 글이 생성되었습니다.\n",id);
			}
			else if(command.equals("article list")) {
				if(articles.size() == 0) {
					System.out.println("게시글이 없습니다.");
					continue;
				}
//				1번 게시물 부터 2,3,4 순서대로
//				for(int i =0; i <articles.size(); i++) {
//					Article article = articles.get(i);
//				}
//				최신게시물부터
				System.out.println("번호  |    제목");
				for(int i = articles.size()-1; i>=0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d    |    %s\n" , article.id, article.title);
				}
			}
			
			else if(command.startsWith("article detail")) {
				String[] commandbits = command.split(" ");
				int id = Integer.parseInt(commandbits[2]); // "2" => 2
				
				Article foundArticle = null;
				
				for(int i =0; i <articles.size(); i++) {
					Article article = articles.get(i);
					if(article.id == id) {
						
						foundArticle = article;
						break;
					}
				}
				if(foundArticle == null) {					
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);	
					continue;
				}
				System.out.printf("번호 : %d\n",foundArticle.id);
				System.out.printf("날짜 : 2022-07-16 12:41:15\n");
				System.out.printf("제목 : %s\n",foundArticle.title);
				System.out.printf("내용 : %s\n",foundArticle.body);	
			}
			
			else if (command.startsWith("article delete")) {
				String[] commandbits = command.split(" ");
				int id = Integer.parseInt(commandbits[2]);
				
				
				int foundIndex = -1;
				
				for(int i =0; i <articles.size(); i++) {
					Article article = articles.get(i);
					if(article.id == id) {
						foundIndex = i;		
						break;
					}
				}
				if(foundIndex == -1) {					
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);	
					continue;
				}
				articles.remove(foundIndex);
				System.out.printf("%d번 게시물이  삭제되었습니다.\n",id);
			}
			
			else {
				System.out.printf("%s는 존재하지 않는 명령어입니다.\n",command);
			}
		}
		
		scan.close();
		System.out.println("== 프로그램 끝 ==");
	}
}
class Article{
	int id;
	String title;
	String body;
	Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
}
