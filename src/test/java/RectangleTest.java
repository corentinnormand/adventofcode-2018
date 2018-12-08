import org.junit.Test;

public class RectangleTest {
	@Test
	public void test() {
		Rectangle r = Rectangle.from("#1 @ 306,433: 16x11");
		System.out.println(r);
	}

	@Test
	public void test_01() {
		Rectangle r = Rectangle.of(1, 1, 1, 10, 10);

		System.out.println(r.overlap(r));

	}

}
