public class Unit {

	private char unit;
	private Unit previousUnit;
	private Unit nextUnit;

	public Unit(char unit, Unit previousUnit) {
		this.unit = unit;
		this.previousUnit = previousUnit;
		if (this.previousUnit != null) {
			this.previousUnit.nextUnit = this;
		}
	}

	public String print(String s) {
		if (nextUnit != null) {
			s += String.valueOf(unit) + nextUnit.print(s);
		} else {
			s += String.valueOf(unit);
		}
		return s;
	}

	public void setPreviousUnit(Unit previousUnit) {
		this.previousUnit = previousUnit;
	}

	public void setNextUnit(Unit nextUnit) {
		this.nextUnit = nextUnit;
	}

	public void react() {
		if (nextUnit != null && cancel(this.unit, this.nextUnit.getUnit())) {
			if (this.previousUnit != null) {
				this.previousUnit.setNextUnit(nextUnit.nextUnit);
			}
			this.nextUnit.getNextUnit().setPreviousUnit(previousUnit);
			this.nextUnit.getNextUnit().react();
		} else {
			if (nextUnit != null)
				this.nextUnit.react();
		}
	}

	public long size(long i) {
		i++;
		if (nextUnit == null) {
			return i;
		}
		System.out.println("size : " + i);
		return nextUnit.size(i);
	}

	public Unit getPreviousUnit() {
		return previousUnit;
	}

	public Unit getNextUnit() {
		return nextUnit;
	}

	private boolean cancel(char c1, char c2) {
		boolean b1 = c1 != c2 && c1 == Character.toUpperCase(c2);
		boolean b2 = c1 != c2 && c1 == Character.toLowerCase(c2);
		return b1 || b2;
	}

	public char getUnit() {
		return unit;
	}
}
