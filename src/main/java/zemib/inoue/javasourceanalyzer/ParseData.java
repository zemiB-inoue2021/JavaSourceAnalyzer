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

	public Package getPackage(String s) {
		for (Package p : packages) {
			if (p.getName() == s) {
				return p;
			}
		}
		Package newpackage = new Package(s);
		packages.add(newpackage);
		return newpackage;
	}
}
