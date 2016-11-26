package devproblem;

public class GrapeComponent {

	private double percentage;
	private int year;
	private String variety;
	
	public GrapeComponent(double percentage, int year, String variety) {
		this.percentage = percentage;
		this.year = year;
		this.variety = variety;
	}

	public double getPercentage() {
		return percentage;
	}
	
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	public String getVariety() {
		return variety;
	}
	
	public void setVariety(String variety) {
		this.variety = variety;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}

}
