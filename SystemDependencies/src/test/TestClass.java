package test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import dependency.CommandHandler;

public class TestClass {

	@Test
    public void testSystemDepenency() {
		
		CommandHandler commandHandler = new CommandHandler();
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"/Users/amitkumar/eclipse-workspace/SystemDependencies/src/inputCommadList"));
			String line = reader.readLine();
			while (line != null) {
				commandHandler.handleCommand(line);
								
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
		//I could have added the test cases here but because of time constraint I have't added test cases here..
		
	}
	
}
