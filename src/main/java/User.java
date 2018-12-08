public class User implements Comparable<User> {

	private String name;

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(User o) {
		return 0;
	}

	@Override
	public String toString() {
		return "User{" + "name='" + name + '\'' + '}';
	}
}
