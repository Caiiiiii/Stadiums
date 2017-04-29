package Manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login {
	private boolean loginfalse = true;
	Scanner sc = new Scanner(System.in);
	public Login() throws IOException{
		System.out.println("****************欢迎使用体育场管理系统*****************");
		while(loginfalse){
		System.out.println(" 请选择注册或者登陆");		
		System.out.println(" 1:注册    2:登陆    3:管理员登陆    4:退出");
		int LoginChoose = sc.nextInt();
		sc.nextLine();
		switch (LoginChoose) {
		case 1:
			System.out.println("*********************************************");
			System.out.println(" 请输入你的账户名");
			String rUserId = sc.nextLine();
			System.out.println(" 请输入你的密码");
			String rUserPd = sc.nextLine();
			int rMessage = 0;
			try {
				rMessage = write(rUserId,rUserPd);
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			if(rMessage == 1){
				System.out.println("该用户已被注册");  
				System.out.println("*********************************************");
				
			}
			else if(rMessage == 2){
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				System.out.println("用户"+rUserId+"在"+new Date()+"创建成功");	
				System.out.println("*********************************************");
				new chooseStadium(rUserId);
				loginfalse = false;
				
			}		
			break;
		case 2:
			System.out.println("*********************************************");
			System.out.println(" 请输入你的账户名");
			String lUserId = sc.nextLine();
			System.out.println(" 请输入你的密码");
			String lUserPd = sc.nextLine();
			int lMessage = 0;
			try {
				lMessage = read(lUserId, lUserPd);
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			if(lMessage == 1){
				System.out.println("登陆成功");
				System.out.println("*********************************************");
				loginfalse = false;
				new chooseStadium(lUserId);
			}else if(lMessage == 3){
				System.out.println("密码错误");
				System.out.println("*********************************************");
			}else if(lMessage == 4){
				System.out.println("该用户未注册");
				System.out.println("*********************************************");
			}
			break;
		case 3:
			System.out.println(" 请输入你的管理员用户名");
			String rootuserId = sc.nextLine();
			System.out.println(" 请输入你的密码");
			String rootuserPd = sc.nextLine();
			if(rootuserId.equals("root")&&rootuserPd.equals("root")){
				System.out.println("登陆成功");
				System.out.println("*********************************************");
				rootStadium rs = new rootStadium();
				rs.readAllUse();
				loginfalse = false;
			}
			else{
				System.out.println("用户名或密码错误");
				System.out.println("*********************************************");
			}
			break;
		case 4:
			System.exit(0);
		default:
			break;
		}
		}
		
	}
	
	 public int write(String name ,String passwd) throws IOException{
		 BufferedReader br = new BufferedReader(
				 new FileReader("E:\\SS\\login.txt"));
		 BufferedWriter bw = new BufferedWriter(
				 new FileWriter("E:\\SS\\login.txt",true));
		 String line = null;
		 String arrs [] =null;
		 boolean isregister = false;
		 while ((line = br.readLine())!=null)
		 {
			 arrs=line.split(":");
			 if(name.equals(arrs[0]))
			 {	 
				 isregister = true;
				 return 1;				 
				 }
			 
			 }		
		 if(isregister == false)
		 {			
				 bw.write(name);
					bw.write(":");
					bw.write(passwd);
					bw.newLine();	
					bw.flush();
					return 2;
		 }			
		 br.close();
		 bw.close();
		 return 0;					
		}
	 
	 int logintimes = 0;
	 public int read(String name ,String passwd) throws IOException{
		 boolean isfind = false;		 
		 BufferedReader br = new BufferedReader(new FileReader("E:\\SS\\login.txt"));
		 String line = null;
		 String arrs [] =null;
		 while ((line = br.readLine())!=null)
		 {
			 arrs=line.split(":");
			 if(name.equals(arrs[0])){
				 if(passwd.equals(arrs[1])){
					 isfind = true;
					 return 1;
				 }else if (logintimes==2){
					 isfind = true;
					 return 2;					 
				 }				
				 else{
					 logintimes++;
					 isfind = true;
					 return 3;
				 }
			 }
		 }
		 if(isfind==false){
			 return 4;
		 }		 
		 br.close();
		return 0;
		
	 }
	
	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
			new Login();
	}

}
