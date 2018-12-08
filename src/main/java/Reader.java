import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reader {

	protected final BufferedReader reader;
	protected final List<String>   lines;

	protected Reader(URI url) {
		try {
			this.reader = new BufferedReader(new FileReader(new File(url)));
		} catch (Exception e) {
			throw new RuntimeException("couldnt read the file " + url, e);
		}
		lines = reader.lines().collect(Collectors.toList());
	}

	protected Reader(String content) {
		this.reader = new BufferedReader(new StringReader(content));
		lines = reader.lines().collect(Collectors.toList());
	}

	public static BufferedReader of(String path) {
		return new Reader(path).reader;
	}

	public static BufferedReader ofContent(String content) {
		return new BufferedReader(new StringReader(content));
	}

	public List<String> getLines() {
		return lines;
	}
}
