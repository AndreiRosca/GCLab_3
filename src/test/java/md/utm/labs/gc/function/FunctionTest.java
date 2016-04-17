package md.utm.labs.gc.function;

import static md.utm.labs.gc.AllTests.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import md.utm.labs.gc.draw.Point;

public class FunctionTest {

	Function function = CubeFunction.newInstance();
	Interval closedInterval = new IntervalBuilder(IntervalType.CLOSED).from(-3).to(3).build();
	Interval openInterval = new IntervalBuilder(IntervalType.OPEN).from(-3).to(3).build();

	@Test
	public void canEvaluateTheGivenFunctionOnTheSpecifiedClosedInterval() {
		List<Point> functionPoints = function.evaluate(closedInterval);
		assertThat(functionPoints, hasItems(list(Point.create(0, 0), Point.create(1, 1), Point.create(3, 27))));
	}

	@Test
	public void canEvaluateTheGivenFunctionOnTheSpecifiedOpenInterval() {
		List<Point> functionPoints = function.evaluate(openInterval);
		assertThat(functionPoints, not(hasItems(list(Point.create(-3, -27), Point.create(3, 27)))));
	}

	private List<Point> list(Point... points) {
		return Arrays.asList(points);
	}
}
