package Manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class alterStadium {
		
	//write
	public void writeStadium(Map<Integer,Stadium >Stadiummap){
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("E:\\SS\\Stadium.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(Stadiummap);
			oos.flush();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}			
		}				
	}
	
	//read
	public Map<Integer,Stadium>readStadium(){
		   FileInputStream fis = null;  
	        ObjectInputStream ois = null;  
	        Map<Integer, Stadium> map = null;  
	try{
	            fis = new FileInputStream("E:\\SS\\Stadium.txt");  
	            ois = new ObjectInputStream(fis);  
	            map = (Map<Integer, Stadium>) ois.readObject();
	}
	catch (ClassNotFoundException e) {
		// TODO: handle exception
	}
	catch (FileNotFoundException e) {
		// TODO: handle exception
	}
	catch (IOException e) {
		// TODO: handle exception
		
		map = new HashMap<Integer,Stadium>();
	}
	return map;
}
}
