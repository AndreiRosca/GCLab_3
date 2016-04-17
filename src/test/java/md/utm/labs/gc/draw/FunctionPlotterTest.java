package md.utm.labs.gc.draw;

import static md.utm.labs.gc.AllTests.hasItems;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import md.utm.labs.gc.algorithm.BresenhamLineAlgorithm;
import md.utm.labs.gc.function.CubeFunction;
import md.utm.labs.gc.function.Function;
import md.utm.labs.gc.function.Interval;
import md.utm.labs.gc.function.IntervalBuilder;
import md.utm.labs.gc.function.IntervalType;

public class FunctionPlotterTest {

	FunctionPlotter plotter;
	Interval closedInterval;

	@Before
	public void setUp() {
		closedInterval = new IntervalBuilder(IntervalType.CLOSED).from(-4).to(4).build();
		Function function = CubeFunction.newInstance();
		plotter = FunctionPlotter.newInstance(BresenhamLineAlgorithm.newInstance(), function, closedInterval);
	}

	@Test
	public void canPlotTheFunction() {
		List<Point> functionPoints = plotter.plot();
		assertThat(functionPoints, hasItems(list(Point.create(-3, -27), Point.create(3, 27), Point.create(1, 1))));
	}
	
	public List<Point> list(Point... points) {
		return Arrays.asList(points);
	}
}
