class DayException extends Exception {
	private String message;
	public DayException() {
		this.message = "";
	}
	public DayException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String toString() {
		return "Day should be in between 1 to 31: " + message;
	}
}
public class CustomExceeptionTest {
	public static void setDay(int day) throws DayException {
		if(day<1 || day>31) {
			throw new DayException(""+day);
		}
		System.out.println("Day " + day + " is SET");
	}
	public static void main(String[] args) {
		try {
			setDay(40);
		} catch (DayException e) {
			e.printStackTrace();
		}
	}

}
