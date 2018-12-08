import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day3 extends Reader {

	private Sheet           sheet;
	private List<Rectangle> rectangles;

	public Day3(String path) {
		super(path);
		sheet = new Sheet();
		//		this.reader = Reader.ofContent("#1 @ 1,3: 4x4\n#2 @ 3,1: 4x4\n#3 @ 5,5: 2x2");
	}

	public String one() throws IOException {
		String s;
		rectangles = new ArrayList<>();
		while ((s = reader.readLine()) != null) {
			Rectangle newRect = Rectangle.from(s);
			for (Rectangle r : rectangles) {
				if (r.overlap(newRect)) {
					sheet.register(r.area(newRect));
				}
			}
			rectangles.add(newRect);
		}

		return String.valueOf(sheet.result());
	}

	public String two() {
		for (Rectangle r : rectangles) {
			if (sheet.isAlone(r)) {
				return String.valueOf(r.getId());
			}
		}
		return "not found";
	}

	;
}
