package Manager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class chooseStadium {
		private boolean isntbook = true;
		Scanner sc = new Scanner(System.in);
		
		public chooseStadium(String name) throws IOException{
			
			
			
			CreateStadium cs = new CreateStadium();
			
			while(isntbook){
				System.out.println("��ѡ����Ҫִ�еĲ���");
				System.out.println(" 1:�鿴ʣ�ೡ��    2:Ԥ������   3:�˻�����   4:�˳�");
				int StadiumChoose = sc.nextInt();
				sc.nextLine();
				switch (StadiumChoose) {
				case 1:
					System.out.println("*********************************************");
					cs.readNotBook();
					System.out.println("*********************************************");
					break;
				case 2:
					System.out.println("��ѡ����ҪԤ���ĳ���");
					System.out.println("1����ë��  2��ƹ����  3������  4������  5������");
					int num = sc.nextInt();
					isntbook = false;
					if(num == 1){
						cs.readNotBookfocus("��ë��");
						System.out.println();
						System.out.println("��ѡ����ҪԤ���ĳ��ţ�");
						int BS = sc.nextInt();
						cs.bookStadium("��ë��", BS,name);
					}else if(num ==2){
						cs.readNotBookfocus("ƹ����");
						System.out.println();
						System.out.println("��ѡ����ҪԤ���ĳ��ţ�");
						int BS = sc.nextInt();
						cs.bookStadium("ƹ����", BS,name);
					}else if(num == 3){
						cs.readNotBookfocus("����");
						System.out.println();
						System.out.println("��ѡ����ҪԤ���ĳ��ţ�");
						int BS = sc.nextInt();
						cs.bookStadium("����", BS,name);
					}else if(num == 4){
						cs.readNotBookfocus("����");
						System.out.println();
						System.out.println("��ѡ����ҪԤ���ĳ��ţ�");
						int BS = sc.nextInt();
						cs.bookStadium("����", BS,name);
					}else if (num==5){
						isntbook = true;
					}
					
					break;
				case 3:
					
					System.out.println("��ѡ����Ҫ�˻��ĳ���");
				cs.readHadBook(name);
				int num1 = sc.nextInt();
				cs.returnStadium(num1);

					break;
				case 4:
					System.exit(0);
					break;
				default:
					break;
				}
			}
		}
}
		


