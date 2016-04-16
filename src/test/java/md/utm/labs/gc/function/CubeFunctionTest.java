package md.utm.labs.gc.function;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import md.utm.labs.gc.function.CubeFunction;
import md.utm.labs.gc.function.Function;

@RunWith(Parameterized.class)
public class CubeFunctionTest {
	
	private static final double PRECISION = 0.000001;
	private double x;
	private double y;
	Function function = CubeFunction.newInstance();

	public CubeFunctionTest(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	@Parameters(name = "f({0}) = {1}")
	public static Double[][] parameters() {
		return new Double[][] {
			{ 0.0, 0.0 },
			{ 1.0, 1.0 },
			{ 2.0, 8.0 },
			{ -1.0, -1.0 },
			{ -2.0, -8.0 }
		};
	}
	
	@Test
	public void canEvaluateTheFunction() {
		assertEquals(y, function.evaluate(x), PRECISION);
	}
}
