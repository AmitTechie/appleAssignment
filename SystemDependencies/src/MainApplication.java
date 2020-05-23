import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommandHandler commandHandler = new CommandHandler();
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"/Users/amitkumar/eclipse-workspace/SystemDependencies/src/inputCommadList"));
			String line = reader.readLine();
			while (line != null) {
				//System.out.println(line);
				commandHandler.handleCommand(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
