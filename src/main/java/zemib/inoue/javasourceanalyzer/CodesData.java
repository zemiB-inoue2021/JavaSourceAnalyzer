package zemib.inoue.javasourceanalyzer;

import java.util.HashMap;

public class CodesData {
	public HashMap<String, Directory> directorymap;

	public void putDirectoryMap(String s, Directory n) {
		directorymap.put(s, n);
	}

}