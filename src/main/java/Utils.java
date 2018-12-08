public class Utils {

	public UserNew newName(User u) {
		UserNew user = new UserNew(u.getName().toUpperCase());
		return user;
	}
}
