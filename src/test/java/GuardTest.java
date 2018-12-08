import org.junit.Test;

public class GuardTest {

	@Test
	public void test() {
		Guard g = new Guard(1);
		g.fallAsleepAt(1);
		g.fallAsleepAt(1);

		System.out.println(g);
	}

}