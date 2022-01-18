package zemib.inoue.javasourceanalyzer;

import java.util.ArrayList;
import java.util.List;

public abstract class MethodOrConstructor {
	private String name;
	private List<Param> params = new ArrayList<Param>();
	private String returnType;
	private int loc;
	private int cyclo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Param> getParams() {
		return params;
	}

	public void setParams(List<Param> params) {
		this.params = params;
	}

	public void addParam(Param param) {
		this.params.add(param);
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public int getLoc() {
		return loc;
	}

	public void setLoc(int loc) {
		this.loc = loc;
	}

	public int getCyclo() {
		return cyclo;
	}

	public void setCyclo(int cyclo) {
		this.cyclo = cyclo;
	}

	public void incCyclo() {
		this.cyclo++;
	}

}
