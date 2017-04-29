package Manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class CreateStadium {

	  private static   Map<Integer,Stadium> map; 
	  private static alterStadium alterStadium;

//	
//	  static{
//		  alterStadium = new alterStadium();
//		  map = alterStadium.readStadium();
//		  Stadium s1 = new  Stadium(1, 1, "羽毛球场",0, null, 0);
//		  map.put(1, s1);
//		  Stadium s2 = new  Stadium(2, 2, "羽毛球场",0, null, 0);
//		  map.put(2, s2);
//		  Stadium s3 = new  Stadium(3, 3, "羽毛球场",0, null, 0);
//		  map.put(3, s3);
//		  Stadium s4 = new  Stadium(4, 4, "羽毛球场",0, null, 0);
//		  map.put(4, s4);
//		  Stadium s5 = new  Stadium(5, 5, "羽毛球场",0, null, 0);
//		  map.put(5, s5);
//		  Stadium s6 = new  Stadium(6, 6, "羽毛球场",0, null, 0);
//		  map.put(6, s6);
//		  Stadium s7 = new  Stadium(7, 7, "羽毛球场",0, null, 0);
//		  map.put(7, s7);
//		  
//		  Stadium s8 = new  Stadium(8, 1, "乒乓球场",0, null, 0);
//		  map.put(8, s8);
//		  Stadium s9 = new  Stadium(9, 2, "乒乓球场",0, null, 0);
//		  map.put(9, s9);
//		  Stadium s10 = new  Stadium(10, 3, "乒乓球场",0, null, 0);
//		  map.put(10, s10);
//		  Stadium s11 = new  Stadium(11, 4, "乒乓球场",0, null, 0);
//		  map.put(11, s11);
//		  Stadium s12 = new  Stadium(12, 5, "乒乓球场",0, null, 0);
//		  map.put(12, s12);
//		  Stadium s13 = new  Stadium(13, 6, "乒乓球场",0, null, 0);
//		  map.put(13, s13);
//		  Stadium s14 = new  Stadium(14, 7, "乒乓球场",0, null, 0);
//		  map.put(14, s14);
//		  Stadium s15 = new  Stadium(15, 8, "乒乓球场",0, null, 0);
//		  map.put(15, s15);
//		  
//		  Stadium s16 = new  Stadium(16, 1, "篮球场",0, null, 0);
//		  map.put(16, s16);
//		  Stadium s17 = new  Stadium(17, 2, "篮球场",0, null, 0);
//		  map.put(17, s17);
//		  Stadium s18 = new  Stadium(18, 3, "篮球场",0, null, 0);
//		  map.put(18, s18);
//		  Stadium s19 = new  Stadium(19, 4, "篮球场",0, null, 0);
//		  map.put(19, s19);
//		  Stadium s20 = new  Stadium(20, 5, "篮球场",0, null, 0);
//		  map.put(20, s20);
//		  Stadium s21 = new  Stadium(21, 6, "篮球场",0, null, 0);
//		  map.put(21, s21);
//		  Stadium s22 = new  Stadium(22, 7, "篮球场",0, null, 0);
//		  map.put(22, s22);
//		  Stadium s23 = new  Stadium(23, 8, "篮球场",0, null, 0);
//		  map.put(23, s23);
//		  
//		  Stadium s24 = new  Stadium(24, 1, "足球场",0, null, 0);
//		  map.put(24, s24);
//		  Stadium s25 = new  Stadium(25, 2, "足球场",0, null, 0);
//		  map.put(25, s25);
//		  
//	  alterStadium.writeStadium(map);
//	  
//	  }
	  
	  public CreateStadium(){
		  
		  alterStadium = new alterStadium();
		  map = alterStadium.readStadium();
		
	  }
	  

	  
	  public void readNotBook(){               // 查看未被预定的场地
		  for(int i = 1;i<26;i++){
			  if(i>1){
				  String n = map.get(i-1).getName();
			  
				  if(!map.get(i).getName().equals(n)){
					  	System.out.println();
				  }
			  if(map.get(i).getIsUsed()==0){
			  System.out.print(map.get(i).getNO()+"号  "+map.get(i).getName()+"|");
		  }
			 
		  }else
			  if(map.get(i).getIsUsed()==0){
				  System.out.print(map.get(i).getNO()+"号  "+map.get(i).getName()+"|");
			  }
		  
		  }
		  System.out.println();
	  }
	  
	  public void readNotBookfocus(String name){                                //读取未被预定的场地
		  for(int i = 1;i<26;i++){
			  if(map.get(i).getIsUsed()==0 && map.get(i).getName().equals(name)){
			  System.out.print(map.get(i).getNO()+"号 :"+map.get(i).getName()+"|");
			  	}
		  }
	  }
	  
	  public void readHadBook(String usename)                               //读取指定用户预定的场地
	  {
		  for(int i= 1;i<26;i++){
			  if(map.get(i).getUsename()!=null){
			  if(map.get(i).getUsename().equals(usename)){
				  System.out.println("编号："+map.get(i).getId()+"  "+map.get(i).getName());
			  }
		  }
		  }
		  
	  }
	  public void bookStadium(String name,int No,String usename){                      //预定场地
		  for(int i=1;i<26;i++){
			  if(map.get(i).getName().equals(name)&&map.get(i).getNO()==No)
			  {
				  int id = map.get(i).getId();
				 int usedcount = map.get(i).getUsedCount();
				 int isused = 1;
				 Stadium st = new Stadium();
				 st.setId(id);
				 st.setIsUsed(isused);
				 st.setName(name);
				 st.setNO(No);
				 st.setUsename(usename);
				 st.setUsedCount(usedcount+1);
				 map.put(id, st);
				 alterStadium.writeStadium(map);
				 System.out.println("预定"+No+"号"+name+"成功！");
				 
			  }
		  }
		  
	  }
	  
	  public void returnStadium(int Id){                 //退还场地
		  for(int i=1;i<26;i++){
			  if(map.get(i).getId()==Id){
				  	String name = map.get(i).getName();
				  	int No = map.get(i).getNO();
					 int usedcount = map.get(i).getUsedCount();
					 int isused = 0;
					 Stadium st2 = new Stadium();
					 st2.setId(Id);
					 st2.setIsUsed(isused);
					 st2.setName(name);
					 st2.setNO(No);
					 st2.setUsename(null);
					 st2.setUsedCount(usedcount);
					 map.put(Id, st2);
					 alterStadium.writeStadium(map);
					 System.out.println("退还"+map.get(i).getNO()+"号"+name+"成功！");
					 
					 
			  }
		  }
		  
	  }
	  public void readStadium(){
		  for(int i = 1;i<26;i++){
			  System.out.println(map.get(i).getNO()+map.get(i).getName());
		  }
	  }
 


}
