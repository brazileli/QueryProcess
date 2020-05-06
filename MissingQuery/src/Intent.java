
public class Intent {

	public Intent(String intentName, int count, String answerYN) {
		super();
		IntentName = intentName;
		this.count = count;
		this.answerYN = answerYN;
	}

	private String IntentName;
	private int count;
	private String answerYN;

	public String getIntentName() {
		return IntentName;
	}

	public void setIntentName(String intentName) {
		IntentName = intentName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getAnswerYN() {
		return answerYN;
	}

	public void setAnswerYN(String answerYN) {
		this.answerYN = answerYN;
	}

}
