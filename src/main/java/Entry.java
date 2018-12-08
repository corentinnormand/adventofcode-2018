import java.time.LocalDate;
import java.time.LocalDateTime;

public class Entry {
	private LocalDateTime localDateTime;
	private String text;

	public Entry(LocalDateTime localDateTime, String text) {
		this.localDateTime = localDateTime;
		this.text = text;
	}

	public LocalDateTime getDate() {
		return localDateTime;
	}

	public String getText() {
		return text;
	}
}
