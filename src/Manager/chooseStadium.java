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
				System.out.println("请选择你要执行的操作");
				System.out.println(" 1:查看剩余场地    2:预定场地   3:退还场地   4:退出");
				int StadiumChoose = sc.nextInt();
				sc.nextLine();
				switch (StadiumChoose) {
				case 1:
					System.out.println("*********************************************");
					cs.readNotBook();
					System.out.println("*********************************************");
					break;
				case 2:
					System.out.println("请选择你要预定的场地");
					System.out.println("1、羽毛球场  2、乒乓球场  3、篮球场  4、足球场  5、返回");
					int num = sc.nextInt();
					isntbook = false;
					if(num == 1){
						cs.readNotBookfocus("羽毛球场");
						System.out.println();
						System.out.println("请选择你要预定的场号：");
						int BS = sc.nextInt();
						cs.bookStadium("羽毛球场", BS,name);
					}else if(num ==2){
						cs.readNotBookfocus("乒乓球场");
						System.out.println();
						System.out.println("请选择你要预定的场号：");
						int BS = sc.nextInt();
						cs.bookStadium("乒乓球场", BS,name);
					}else if(num == 3){
						cs.readNotBookfocus("篮球场");
						System.out.println();
						System.out.println("请选择你要预定的场号：");
						int BS = sc.nextInt();
						cs.bookStadium("篮球场", BS,name);
					}else if(num == 4){
						cs.readNotBookfocus("足球场");
						System.out.println();
						System.out.println("请选择你要预定的场号：");
						int BS = sc.nextInt();
						cs.bookStadium("足球场", BS,name);
					}else if (num==5){
						isntbook = true;
					}
					
					break;
				case 3:
					
					System.out.println("请选择你要退还的场地");
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
		


