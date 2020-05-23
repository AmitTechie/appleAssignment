package dependency;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandHandler {
	DependencyManager dependencyManager;
	
	public CommandHandler() {
		super();
		this.dependencyManager = new DependencyManager();
	}



	public List<String> handleCommand(String command) {
		
		
		//System.out.println(command);
		if(command.isEmpty()) {
			return null;
		}
		
		
		String[] commandItems = command.split("\\s+");
		
		switch (commandItems[0]) {
		case "INSTALL":
			System.out.println(command);
			
			List<String> intalledList = new ArrayList<String>();
			
			for(int i=1;i<commandItems.length; i++) {
				List<String> res = dependencyManager.install(commandItems[i]);
				if (res != null) {
					intalledList.addAll(res);					
				}

			}
			return intalledList;

		case "REMOVE":
			System.out.println(command);
			for(int i=1;i<commandItems.length; i++) {
				dependencyManager.remove(commandItems[i]);
			}
			break;
			
		case "LIST":
				System.out.println(command);				
			return dependencyManager.listInstalledSoftare();

		case "END":
			System.out.println(command);
			return null;

			
		case "DEPEND":
			System.out.println(command);
			dependencyManager.addDependency(Arrays.asList(Arrays.copyOfRange(commandItems, 1, commandItems.length)));
			return null;
		
		default:

			break;
		}
		return null;
		
		
	}

}
