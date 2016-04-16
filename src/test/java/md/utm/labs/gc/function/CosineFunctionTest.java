package md.utm.labs.gc.function;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import md.utm.labs.gc.function.CosineFunction;
import md.utm.labs.gc.function.Function;

@RunWith(Parameterized.class)
public class CosineFunctionTest {

	private static final double PRECISION = 0.0000001;
	private double x;
	private double y;
	Function function = CosineFunction.newInstance();
	
	public CosineFunctionTest(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	@Parameters(name = "f({0}) = {1}")
	public static Double[][] parameters() {
		return new Double[][] {
			{ 0.0, 4.0 },
			{ Math.PI / 4, 0.0 },
			{ 30 * Math.PI / 180, 2.0 },
			{ Math.PI / 2, -4.0 }
		};
	}
	
	@Test
	public void canEvaluateTheFunction() {
		assertEquals(y, function.evaluate(x), PRECISION);
	}
}
