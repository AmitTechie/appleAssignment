package dependency;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Installed {

		Set<String> installedSoftware;

		public Installed() {
			super();
			installedSoftware = new HashSet<String>();
		}
		
		
		public boolean installSoftware(String software) {
			
			if (software.isEmpty()) {
				return false;
			}
			
			if (installedSoftware.contains(software)) {
				printMsg(software+" is already installed.");
				return false;
			}
			
			installedSoftware.add(software);
			printMsg("        Installing "+software);
			return true;			
		}
		
		public boolean uninstallSoftware(String software) {
			
			if (software.isEmpty()) {
				return false;
			}
			
			if (installedSoftware.contains(software)) {
				installedSoftware.remove(software);
				printMsg("          Removing "+software);
				return true;
			}
			printMsg("      "+software+" is not installed.");
			return false;			
		}
		
		public boolean isAlreadyInstalledSoftware(String name) {
			return installedSoftware.contains(name);
		}
		
		public void printMsg(String s) {
			System.out.println(s);
		}
		
		public List<String> listInstalledSoftare() {
			for(String s : this.installedSoftware) {
				printMsg("    "+s);
			}
			
			List<String> intalledList = new ArrayList<String>();
			intalledList.addAll(installedSoftware);
			return intalledList;
		}


		
}
