import java.net.URI;

public class Day5 extends Reader {
	protected Day5(URI url) {
		super(url);
	}

	protected Day5(String content) {
		super(content);
	}

	public int one() {
		String str = getLines().get(0);

		for(int i = 0; i < str.length() - 1; i++) {
			if(Math.abs(str.charAt(i) - str.charAt(i+1)) == 32) {
				str = (i > 0 ? str.substring(0, i) : "") + (i < str.length() - 2 ? str.substring(i + 2) : "");
				i-=2;
				if(i<-1)
					i++;
			}
		}
		return str.length();

	}

	private boolean cancel(char c1, char c2) {
		boolean b1 = c1 != c2 && c1 == Character.toUpperCase(c2);
		boolean b2 = c1 != c2 && c1 == Character.toLowerCase(c2);
		return b1 || b2;
	}

}
