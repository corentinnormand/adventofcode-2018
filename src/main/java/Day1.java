import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Day1 extends Reader {

	private static final Map<Character, Function<String, Integer>> MAP = new HashMap<>();

	static {
		MAP.put('+', Integer::valueOf);
		MAP.put('-', (i) -> -Integer.valueOf(i));
	}

	private int frequency;

	protected Day1(URI uri) {
		super(uri);
	}

	protected Day1(String path) {
		super(path);
	}

	public String one() throws IOException {
		reader.mark(4000);
		int collect = reader.lines().map(s -> MAP.get(s.charAt(0)).apply(s.substring(1))).mapToInt(i -> i).sum();

		reader.reset();
		System.out.println(collect);
		return String.valueOf(collect);
	}

	public String two() throws IOException {
		String s;
		frequency = 0;

		Set<Integer> frequencies = new HashSet<>();
		frequencies.add(0);
		int size = 0;
//		reader.mark(0);
//		reader.reset();
		while ((s = loop(frequencies, size)) == null) {
//			reader.mark(0);
			reader.reset();
		}
		return s;

	}

	private String loop(Set<Integer> frequencies, int size) throws IOException {
		String s;
		while ((s = reader.readLine()) != null) {
			Integer change = MAP.get(s.charAt(0)).apply(s.substring(1));
			this.frequency += change;
			System.out.println("freq : " + this.frequency);
			if (frequencies.contains(this.frequency)) {
				return String.valueOf(this.frequency);
			}
			frequencies.add(this.frequency);
			size++;
		}
		return null;
	}

}
