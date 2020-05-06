
public class ParsedIntent {

	private String parsedIntentName;
	private int countIntent;
	private int sumAppearCount;
	private int sumQueryCount;

	public ParsedIntent(String parsedIntentName, int countIntent, int sumAppearCount, int sumQueryCount) {
		super();
		this.parsedIntentName = parsedIntentName;
		this.countIntent = countIntent;
		this.sumAppearCount = sumAppearCount;
		this.sumQueryCount = sumQueryCount;
	}

	public String getParsedIntentName() {
		return parsedIntentName;
	}

	public void setParsedIntentName(String parsedIntentName) {
		this.parsedIntentName = parsedIntentName;
	}

	public int getCountIntent() {
		return countIntent;
	}

	public void setCountIntent(int countIntent) {
		this.countIntent = countIntent;
	}

	public int getSumAppearCount() {
		return sumAppearCount;
	}

	public void setSumAppearCount(int sumAppearCount) {
		this.sumAppearCount = sumAppearCount;
	}

	public int getSumQueryCount() {
		return sumQueryCount;
	}

	public void setSumQueryCount(int sumQueryCount) {
		this.sumQueryCount = sumQueryCount;
	}

}
