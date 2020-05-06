import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;

public class IntentParser {

	public static void main(String args[]) {

		HashMap<String, Integer> appearHash = new HashMap<String, Integer>();
		HashMap<String, Integer> queryHash = new HashMap<String, Integer>();

		try {
			File file = new File("C:\\Users\\DKU\\eclipse-workspace\\IntentParser\\src\\intentList.txt");
			BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
			String str = null;
			while ((str = bf.readLine()) != null) {
				appearHash.put(str.split("\t")[0], Integer.parseInt(str.split("\t")[1]));
				queryHash.put(str.split("\t")[0], Integer.parseInt(str.split("\t")[2]));
			}
			bf.close();
			
			file = new File("C:\\Users\\DKU\\eclipse-workspace\\IntentParser\\src\\ParsedIntentList.txt");
			bf = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
			BufferedWriter fw = new BufferedWriter(new FileWriter("cluster.txt",false));
			
			str = null;
			while ((str = bf.readLine()) != null) {
				String[] temp = str.split("\t");
				String parsedIntentName = temp[0];
				
			
				int sumAppearCount = 0;
				int sumQueryCount = 0;
				for(int i=1; i<temp.length; i++) {
					sumAppearCount += appearHash.get(temp[i]);
					sumQueryCount += queryHash.get(temp[i]);
				}
				
				String w_String = parsedIntentName+"\t"+(temp.length-1)+"\t"+sumAppearCount+"\t"+sumQueryCount+"\n";
				//System.out.println(parsedIntentName+" : "+(temp.length-1)+" , "+sumAppearCount+" , "+sumQueryCount);
				fw.write(w_String);
				fw.flush();
				
			}
			fw.close();
			bf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
