import java.util.AbstractMap;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;
import sun.applet.resources.MsgAppletViewer_sv;

public class Guard {
	@Override
	public String toString() {
		return "Guard{" + "id=" + id + ", minutesAsleep=" + getMinutesAsleep() + ", mostSleptMinute=" + mostSleptMinute() + '}';
	}

	public int getMinutesAsleep() {
		return minutesAsleep.entrySet().stream().mapToInt(Map.Entry::getValue).sum();
	}

	public int mostSleptMinute() {
		return minutesAsleep.entrySet()
				.stream()
				.max(Comparator.comparingInt(Map.Entry::getValue))
				.orElse(new AbstractMap.SimpleEntry<>(1, 0))
				.getKey();
	}

	public int mostTimesSleptMinute() {
		return minutesAsleep.getOrDefault(mostSleptMinute(), 0);
	}

	private int                   id;
	private Map<Integer, Integer> minutesAsleep;
	private int                   lastMinutesAsleep;

	public Guard(int id) {
		this.id = id;
		minutesAsleep = new HashMap<>();

	}

	public void fallAsleepAt(int minutes) {
		lastMinutesAsleep = minutes;
	}

	private void asleepAt(int minutes) {
		if (!minutesAsleep.containsKey(minutes)) {
			minutesAsleep.put(minutes, 1);
		} else {
			minutesAsleep.put(minutes, minutesAsleep.get(minutes) + 1);
		}
	}

	public void wakesUpAt(int minutes) {
		IntStream.range(lastMinutesAsleep, minutes).boxed().forEach(this::asleepAt);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Guard guard = (Guard) o;
		return id == guard.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public int getId() {
		return id;
	}

	public int getMostAsleepMinute() {
		return 0;
	}
}
