import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MissingQuery {

	public static void main(String args[]) {
		HashMap<String, Intent> totalMap = new HashMap<String, Intent>();
		ArrayList<String> totalList = new ArrayList<String>();
		ArrayList<String> existList = new ArrayList<String>();

		try {
			File file = new File("C:\\Users\\DKU\\eclipse-workspace\\MissingQuery\\total.txt");
			BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
			String str = null;
			while (((str = bf.readLine()) != null)) {
				String[] temp = str.split("\t");
				String intentName = temp[0];
				int count = Integer.parseInt(temp[1]);
				String answerYN = temp[2];
				Intent tempIntent = new Intent(intentName, count, answerYN);
				totalMap.put(intentName+answerYN, tempIntent);
				totalList.add(intentName+answerYN);
			}
			
			bf.close();

			file = new File("C:\\Users\\DKU\\eclipse-workspace\\MissingQuery\\exist.txt");
			bf = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));

			while (((str = bf.readLine()) != null)) {
				String[] temp = str.split("\t");
				String intentName = temp[0];
				String answerYN = temp[2];
				existList.add(intentName+answerYN);
			}

			bf.close();
			
			System.out.println(totalList.size());
			System.out.println(totalMap.size());
			System.out.println(existList.size());
			
			BufferedWriter fw = new BufferedWriter(new FileWriter("missingQuery.txt", false));
			
			for(int i=0; i<existList.size(); i++) {
				for(int j=0; j<totalList.size();j++) {
					if(totalList.get(j)==null)
						continue;
					else if(totalList.get(j).compareTo(existList.get(i))==0){
						totalList.set(j, null);
						break;
					}
				}
			}
			
			for(int i=0; i<totalList.size(); i++)
				if(totalList.get(i) !=null) {
					Intent tempIntent = totalMap.get(totalList.get(i));
					String tempStr = tempIntent.getIntentName()+"\t"+tempIntent.getCount()+"\t"+tempIntent.getAnswerYN()+"\n";
					fw.write(tempStr);
					//fw.write(totalList.get(i)+"\n");
					fw.flush();
				}
			
			fw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
