import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day2 {

	public void one() throws IOException {
		BufferedReader r      = Reader.of("C:\\Users\\Corentin\\Downloads\\day2.txt");
		String         s;
		int            count1 = 0;
		int            count2 = 0;
		while ((s = r.readLine()) != null) {
			if (contains(2, s)) {
				count1++;
			}

			if (contains(3, s)) {
				count2++;
			}
		}

		System.out.println(count1 * count2);

	}

	private boolean contains(int numberOfChar, String s) {
		Map<Character, Integer> characterCount = new HashMap<>();
		for (int j = 0; j < s.toCharArray().length; j++) {
			char key = s.charAt(j);
			if (characterCount.containsKey(key)) {
				characterCount.put(key, characterCount.get(key) + 1);
			} else {
				characterCount.put(key, 1);
			}
		}
		for (Map.Entry<Character, Integer> e : characterCount.entrySet()) {
			if (e.getValue() == numberOfChar) {
				return true;
			}
		}
		return false;
	}

	public String two() throws IOException {
		BufferedReader r = Reader.of("C:\\Users\\Corentin\\Downloads\\day2.txt");
		String         line;
		List<String>   l = new ArrayList<>();
		String s = "";
		while ((line = r.readLine()) != null) {
			for (String str : l) {
				if (compare(line, str) == 1) {
					for (int i = 0; i < str.toCharArray().length; i++) {
						if (str.charAt(i) == line.charAt(i)) {
							s += str.charAt(i);
						}
					}
				}
			}
			l.add(line);
		}
		return s;
	}

	private int compare(String s1, String s2) {
		int diff = 0;
		for (int i = 0; i < s1.toCharArray().length; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				diff++;
			}
		}
		return diff;
	}
}
