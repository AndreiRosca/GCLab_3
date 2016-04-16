package md.utm.labs.gc.function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IntervalTest {

	private static final double PRECISION = 0.0000001;
	Interval closedInterval = new IntervalBuilder(IntervalType.CLOSED).from(-3).to(3).build();
	Interval openInterval = new IntervalBuilder(IntervalType.OPEN).from(-3).to(3).build();

	@Test
	public void canGetStartingPointFromClosedInterval() {
		assertEquals(-3, closedInterval.getStartingPoint(), PRECISION);
	}
	
	@Test
	public void canGetStartingPointFromOpenInterval() {
		assertEquals(-2, openInterval.getStartingPoint(), PRECISION);
	}
	
	@Test
	public void canGetEndingPointFromClosedInterval() {
		assertEquals(3, closedInterval.getEndingPoint(), PRECISION);
	}
	
	@Test
	public void canGetEndingPointFromOpenInterval() {
		assertEquals(2, openInterval.getEndingPoint(), PRECISION);
	}
	
	@Test
	public void canCheckIfThePointIsWhithinTheOpenIntervalBounds() {
		assertTrue(openInterval.isWhithinBounds(0));
	}
	
	@Test
	public void canCheckIfThePointIsWhithinTheClosedIntervalBounds() {
		assertTrue(closedInterval.isWhithinBounds(0));
	}
	
	@Test
	public void canCheckIfThePointIsNotWhithinTheOpenIntervalBounds() {
		assertFalse(openInterval.isWhithinBounds(-3));
	}
	
	@Test
	public void canCheckIfThePointIsNotWhithinTheClosedIntervalBounds() {
		assertFalse(closedInterval.isWhithinBounds(-4));
	}
}
