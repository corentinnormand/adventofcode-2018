public class UserNew implements Comparable<UserNew> {

	private String name;

	public UserNew(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(UserNew o) {
		return 0;
	}

	@Override
	public String toString() {
		return "UserNew{" + "name='" + name + '\'' + '}';
	}
}
