package md.utm.labs.gc.request;

import md.utm.labs.gc.draw.FunctionPlotter;
import md.utm.labs.gc.draw.Point;

public abstract class GraphRequest {

	private FunctionPlotter plotter;
	
	public GraphRequest(FunctionPlotter plotter) {
		this.plotter = plotter;
	}
	
	protected void graph() {
		for (Point point : plotter.plot())
			draw(point);
	}

	public abstract void draw(Point point);
}
