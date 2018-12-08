import java.util.ArrayList;
import java.util.List;

public class Sort<T extends Comparable<T>> {

	public List<T> sort(List<T> thingsToSort) {
		if (thingsToSort.size() == 1) {
			return thingsToSort;
		} else {

			List<T> left  = thingsToSort.subList(0, thingsToSort.size() / 2);
			List<T> right = thingsToSort.subList(thingsToSort.size() / 2, thingsToSort.size());
			return merge(sort(left), sort(right));
		}
	}

	private List<T> merge(List<T> left, List<T> right) {
		List<T> result = new ArrayList<>();
		if (left.isEmpty()) {
			return right;
		}
		if (right.isEmpty()) {
			return left;
		}
		if (left.get(0).compareTo(right.get(0)) <= 0) {
			result.add(left.get(0));
			result.addAll(merge(left.subList(1, left.size()), right));
			return result;
		} else {
			result.add(right.get(0));
			result.addAll(merge(left, right.subList(1, right.size())));
			return result;
		}

	}
}
