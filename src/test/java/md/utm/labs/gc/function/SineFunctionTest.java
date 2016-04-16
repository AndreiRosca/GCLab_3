package md.utm.labs.gc.function;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import md.utm.labs.gc.function.Function;
import md.utm.labs.gc.function.SineFunction;

@RunWith(Parameterized.class)
public class SineFunctionTest {

	private static final double PRECISION = 0.000001;
	private double x;
	private double y;
	Function function = SineFunction.newInstance();
	
	public SineFunctionTest(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	@Parameters(name = "f({0}) = {1}")
	public static Double[][] parameters() {
		return new Double[][] {
				{ 0.0, 0.0},
				{ Math.PI / 4, 1.3 },
				{ Math.PI, 0.0 },
				{ 15 * Math.PI / 180, 1.3 / 2 }
		};
	}

	@Test
	public void canEvaluateTheFunction() {
		assertEquals(y, function.evaluate(x), PRECISION);
	}
}
