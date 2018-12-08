import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Test;

public class Day4Test {
	@Test
	public void test() {
		LocalDateTime localDateTime = LocalDateTime.parse("1518-06-12 00:00", Day4.DATE_TIME_FORMATTER);
		System.out.println(localDateTime);
	}
}
