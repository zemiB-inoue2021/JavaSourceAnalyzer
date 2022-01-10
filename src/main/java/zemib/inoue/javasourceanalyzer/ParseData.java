package zemib.inoue.javasourceanalyzer;

import java.util.ArrayList;
import java.util.List;

public class ParseData {
	private List<Package> packages = new ArrayList<Package>();

	public List<Package> getPackages() {
		return packages;
	}

	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}

	public void addPackage(Package p) {
		this.packages.add(p);
	}

}
