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
	  System.out.println(map.get(i).getNO()+"��:"+map.get(i).getName()+",ԤԼ������"+map.get(i).getUsedCount()
			  +",ԤԼ�ˣ�"+map.get(i).getUsename());
  }
}
