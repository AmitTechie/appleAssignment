package dependency;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DependencyManager {
	
	Map<String, Integer> dependencyCountMap;
	Map<String, List<String>> dependencyMap;
	Installed installedSoftware;
	public DependencyManager() {
		super();
		this.dependencyCountMap = new HashMap<>();
		this.dependencyMap = new HashMap<>();
		this.installedSoftware = new Installed();
		
	}
	

	public void addDependency(List<String> dlist) {
		
		if (dlist == null || dlist.size() < 2) {
			return;
		}
		
		for(int i=1; i< dlist.size(); i++) {
			addDependency(dlist.get(0), dlist.get(i));
		}
	}
	
	// dependency from a -> b
	public void addDependency(String a, String b) {
		this.dependencyCountMap.put(a, this.dependencyCountMap.getOrDefault(a, 0));
		// increase inbound map
		this.dependencyCountMap.put(b, this.dependencyCountMap.getOrDefault(b, 0)+1); 
		
		
		List<String> dlist = this.dependencyMap.getOrDefault(a, new ArrayList<String>());
		dlist.add(b);
		
		this.dependencyMap.put(a, dlist);
	}
	
	
	public void remove(String software) {
		if (!this.dependencyCountMap.containsKey(software)){
			System.out.print("Error, no such software to remove: "+software);
			return;
		}
		
		if (this.dependencyCountMap.get(software) > 0) {
			printMsg("     "+software+" is still needed.");
			return;
		}
		
		//remove..
		if (this.installedSoftware.uninstallSoftware(software)) {
			//dependencyCountMap.put(software, dependencyCountMap.get(software)-1);
			
			if (this.dependencyMap.containsKey(software)) {
				for (String s : dependencyMap.get(software)) {
					dependencyCountMap.put(s, dependencyCountMap.get(s)-1);
					removeHelper(s);
				}
			}
			
		}		
		
	}

	private void removeHelper(String software) {
		if (!this.dependencyCountMap.containsKey(software)){
			return;
		}
		
		if (this.dependencyCountMap.get(software) > 0) {
			return;
		}
		
		//remove..
		if (this.installedSoftware.uninstallSoftware(software)) {
		
			if (this.dependencyMap.containsKey(software)) {
				for (String s : dependencyMap.get(software)) {
					dependencyCountMap.put(s, dependencyCountMap.get(s)-1);
					removeHelper(s);
				}
			}
		}
		
	}

	
	public List<String> install(String software) {
		
		if (software.isEmpty()) {
			return null;
		}
		
		if (this.installedSoftware.isAlreadyInstalledSoftware(software)) {
			printMsg(software+" is already installed.");
			return null;
		}
		
		List<String> installedSoftwareList = new ArrayList<>();
		
		installedSoftwareList.add(software);
		this.installedSoftware.installSoftware(software);
		if (this.dependencyMap.containsKey(software)) {
			for (String s : dependencyMap.get(software)) {
				if (this.installedSoftware.isAlreadyInstalledSoftware(s)) {
					continue;
				}
				if (this.installedSoftware.installSoftware(s)) {
					installedSoftwareList.add(s);
				}
			}
		}
		return installedSoftwareList;
	}
	
	public List<String> listInstalledSoftare() {
		return installedSoftware.listInstalledSoftare();
	}
	
	public void printMsg(String s) {
		System.out.println(s);
	}

	
}
