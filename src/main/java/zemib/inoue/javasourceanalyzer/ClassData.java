package zemib.inoue.javasourceanalyzer;

public class ClassData extends Node{
	public String classname;
	public int noa;
	public int noi;
	
	public void setNoa(int noa) {
		this.noa = noa;
	}
	
	public void setNoi(int noi) {
		this.noi = noi;
	}
	
	public int getNoa() {
		return noa;
	}

	public int getNoi() {
		return noi;
	}
	
	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}
}
