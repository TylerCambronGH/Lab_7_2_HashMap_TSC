import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner scanner;
		try {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            Random r = new Random();
			scanner = new Scanner(new File("dictionary.csv"));
            int rsi = 0;
            String[] randomSearch = new String[5];
            System.out.println("Building Hash Map...");
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
				String key = line[0];
				String value = "";
				for (int i=1; i < line.length; i++) {
					value += line[i];
				}
                hashMap.put(key, value);
                System.out.println("Adding \"" + key + "\", \"" + value + "\" to hash map.");
                int rand = r.nextInt(10);
                if (rand == 1 && rsi < 5) {
                    randomSearch[rsi] = key;
                    rsi++;
                }
            }
			scanner.close();

            for (String key: randomSearch)  {
                System.out.println("\nSearching for key: " + key + "\n Hash Code: " + key.hashCode() + "\n Value: " + hashMap.get(key));
            }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}    
    }
}
