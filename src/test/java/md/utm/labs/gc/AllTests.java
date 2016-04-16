package md.utm.labs.gc;

import java.util.Collection;
import java.util.List;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import md.utm.labs.gc.algorithm.BresenhamLineAlgorithmTest;
import md.utm.labs.gc.draw.FunctionPlotterTest;
import md.utm.labs.gc.function.CosineFunctionTest;
import md.utm.labs.gc.function.CubeFunctionTest;
import md.utm.labs.gc.function.FunctionTest;
import md.utm.labs.gc.function.IntervalTest;
import md.utm.labs.gc.function.SineFunctionTest;

@RunWith(Suite.class)
@SuiteClasses({ BresenhamLineAlgorithmTest.class, CosineFunctionTest.class, CubeFunctionTest.class,
		SineFunctionTest.class, FunctionTest.class, FunctionPlotterTest.class, IntervalTest.class })
public class AllTests {

	public static CollectionMatcher hasItems(List<Point> actual) {
		return new CollectionMatcher(actual);
	}

	public static class CollectionMatcher extends BaseMatcher<List<Point>> {
		private List<Point> expected;

		public CollectionMatcher(List<Point> actual) {
			this.expected = actual;
		}

		@Override
		public boolean matches(Object item) {
			if (!(item instanceof Collection))
				return false;
			@SuppressWarnings("unchecked")
			List<Point> actual = (List<Point>) item;
			return actual.containsAll(expected);
		}

		@Override
		public void describeTo(Description description) {
			description.appendText(expected.toString());
		}
	}
}
