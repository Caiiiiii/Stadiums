package Manager;

import java.io.Serializable;

public class Stadium implements Serializable {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private int NO;
	private String name;
	private int usedCount;
	private String usename;
    private int isUsed;
	
	public String getUsename() {
		return usename;
	}
	public Stadium(int id, int nO, String name, int usedCount, String usename, int isUsed) {
		super();
		this.id = id;
			this.NO = nO;
		this.name = name;
		this.usedCount = usedCount;
		this.usename = usename;
		this.isUsed = isUsed;
	}
	@Override
	public String toString() {
		return "Stadium [id=" + id + ", NO=" + NO + ", name=" + name + ", usedCount=" + usedCount + ", usename="
				+ usename + ", isUsed=" + isUsed + "]";
	}
	public void setUsename(String usename) {
		this.usename = usename;
	}
	public Stadium() {
		super();
	}
	
	public int getNO() {
		return NO;
	}
	public void setNO(int nO) {
		NO = nO;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUsedCount() {
		return usedCount;
	}
	public void setUsedCount(int usedCount) {
		this.usedCount = usedCount;
	}
	public int getIsUsed() {
		return isUsed;
	}
	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	
	
}
