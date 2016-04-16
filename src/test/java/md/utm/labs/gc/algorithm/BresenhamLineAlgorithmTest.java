package md.utm.labs.gc.algorithm;

import static md.utm.labs.gc.AllTests.hasItems;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import md.utm.labs.gc.Point;

public class BresenhamLineAlgorithmTest {

	BresenhamLineAlgorithm plotter = BresenhamLineAlgorithm.newInstance();
	
	@Test
	public void catDrawObliqueLine() {
		List<Point> linePoints = plotter.getLinePoints(Point.create(0, 1), Point.create(6, 4));
		assertThat(linePoints, hasItems(list(Point.create(0, 1), Point.create(6, 4))));
	}
	
	@Test
	public void canDrawTwoPixelVerticalLine() {
		List<Point> linePoints = plotter.getLinePoints(Point.create(0, 0), Point.create(2, 2));
		assertThat(linePoints, hasItems(list(Point.create(0, 0), Point.create(2, 2), Point.create(1, 1))));
	}
	
	@Test
	public void canDrawOnePixelHorizontalLine() {
		List<Point> linePoints = plotter.getLinePoints(Point.create(0, 0), Point.create(3, 0));
		assertThat(linePoints, hasItems(list(Point.create(0, 0), Point.create(3, 0))));
	}
	
	private List<Point> list(Point... points) {
		return Arrays.asList(points);
	}
}
