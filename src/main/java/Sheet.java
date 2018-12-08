import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Sheet {
	private Set<Coordinates> zonesTaken;

	public Sheet() {
		this.zonesTaken = new HashSet<>();
	}



	public void register(Rectangle r) {
		for (int x = r.getX(); x < r.getX() + r.getW(); x++) {
			for (int y = r.getY(); y < r.getY() + r.getH(); y++) {
				zonesTaken.add(new Coordinates(x, y));
			}
		}
	}

	public boolean isAlone(Rectangle r) {
		for (int x = r.getX(); x < r.getX() + r.getW(); x++) {
			for (int y = r.getY(); y < r.getY() + r.getH(); y++) {
				if(zonesTaken.contains(new Coordinates(x, y))) {
					return false;
				}
			}
		}
		return true;
	}

	public String result() {
		return String.valueOf(zonesTaken.size());
	}
}
