package zemib.inoue.javasourceanalyzer;

import java.util.HashMap;

public class ProjectData {
	public HashMap<String, Directory> project;

	public void putDirectoryMap(String s, Directory n) {
		project.put(s, n);
	}

}