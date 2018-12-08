import java.io.IOException;
import java.net.URI;

public class Main {

	public static void main(String[] args) throws IOException {
		Day5 day5 = new Day5("dabAcCaCBAcCcaDA");
//		Day5 day5 = new Day5(URI.create("file:///C:/Users/Corentin/Downloads/day5.txt"));

		System.out.println(day5.one());
	}

}
