import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.HOUR_OF_DAY;
import static java.time.temporal.ChronoField.MINUTE_OF_HOUR;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import static java.time.temporal.ChronoField.YEAR;

public class Day4 extends Reader {

	public static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder().appendValue(YEAR, 4)
			.appendLiteral('-')
			.appendValue(MONTH_OF_YEAR, 2)
			.appendLiteral('-')
			.appendValue(DAY_OF_MONTH, 2)
			.appendLiteral(' ')
			.appendValue(HOUR_OF_DAY, 2)
			.appendLiteral(':')
			.appendValue(MINUTE_OF_HOUR, 2)
			.toFormatter();

	private Map<Integer, Guard> guards;
	private List<Entry>         entries;

	public Day4(String content) {
		super(content);
		guards = new HashMap<>();
		entries = new ArrayList<>();

	}

	public Day4(URI uri) {
		super(uri);
		guards = new HashMap<>();
		entries = new ArrayList<>();
	}

	public String one() throws IOException {
		String s;
		while ((s = reader.readLine()) != null) {
			LocalDateTime date = LocalDateTime.parse(s.substring(s.indexOf('[') + 1, s.indexOf(']')),
					DATE_TIME_FORMATTER);
			entries.add(new Entry(date, s.substring(s.indexOf(']') + 2)));

		}

		entries.sort(Comparator.comparing(Entry::getDate));
		Guard b = null;
		for (Entry e : entries) {
			if (!e.getText().contains("wakes up") && !e.getText().contains("falls asleep")) {
				Integer id = Integer.valueOf(e.getText()
						.substring(e.getText().indexOf('#') + 1, e.getText().indexOf('b') - 1));
				if ((b = guards.get(id)) == null) {
					b = new Guard(id);
				}
				guards.put(b.getId(), b);
			} else {
				if (e.getText().contains("wakes up")) {
					b.wakesUpAt(e.getDate().getMinute());
				} else if (e.getText().contains("falls asleep")) {
					b.fallAsleepAt(e.getDate().getMinute());
				}
			}
		}

		Guard guard = guards.entrySet()
				.stream()
				.max(Comparator.comparingInt(e -> e.getValue().getMinutesAsleep()))
				.map(Map.Entry::getValue)
				.orElseThrow(() -> new RuntimeException("no guard found"));
		return String.valueOf(guard);
	}

	public String two() {
		return guards.entrySet().stream().max(Comparator.comparingInt(e -> e.getValue().mostTimesSleptMinute())).orElseThrow(() -> new RuntimeException("oui")).toString();
	}
}
