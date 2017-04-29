package Manager;

import java.util.Map;

public class rootStadium {
	  private static   Map<Integer,Stadium> map; 
	  private static alterStadium alterStadium;

  public rootStadium(){
		  
		  alterStadium = new alterStadium();
		  map = alterStadium.readStadium();	
	  }
  
  public void readAllUse(){
	  for(int i=1;i<26;i++)
	  System.out.println(map.get(i).getNO()+"号:"+map.get(i).getName()+",预约次数："+map.get(i).getUsedCount()
			  +",预约人："+map.get(i).getUsename());
  }
}
