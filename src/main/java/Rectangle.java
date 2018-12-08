import java.util.Objects;
import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class Rectangle {

	private int x;
	private int y;
	private int h;
	private int w;
	private int id;

	private Rectangle(int id, int x, int y, int h, int w) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
	}

	public static Rectangle of(int id, int x, int y, int w, int h) {
		return new Rectangle(id, x, y, h, w);
	}

	public static Rectangle from(String s) {
		int at        = s.indexOf('@');
		int semicolon = s.indexOf(',');
		int colon     = s.indexOf(':');
		int hash      = s.indexOf('#');
		int cross     = s.indexOf('x');

		int id = Integer.parseInt(s.substring(hash + 1, at - 1));
		int x  = Integer.parseInt(s.substring(at + 2, semicolon));
		int y  = Integer.parseInt(s.substring(semicolon + 1, colon));
		int w  = Integer.parseInt(s.substring(colon + 2, cross));
		int h  = Integer.parseInt(s.substring(cross + 1));
		return new Rectangle(id, x, y, h, w);
	}

	public boolean overlap(Rectangle r) {
		return this.x < r.x + r.w && this.x + this.w > r.x && this.y < r.y + r.h && this.h + this.y > r.y;
	}

	public Rectangle area(Rectangle r) {

		int w_area = abs(max(this.x, r.x) - min(this.x + this.w, r.x + r.w));
		int h_area = abs(max(this.y, r.y) - min(this.y+ this.h, r.y + r.h));
		return Rectangle.of(new Random().nextInt(),
				max(this.x, r.x),
				max(this.y, r.y),
				w_area,
				h_area);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Rectangle rectangle = (Rectangle) o;
		return id == rectangle.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getH() {
		return h;
	}

	public int getW() {
		return w;
	}

	public int getId() {
		return id;
	}
}
