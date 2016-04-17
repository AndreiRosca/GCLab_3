package md.utm.labs.gc.request;

import md.utm.labs.gc.draw.FunctionPlotter;

public abstract class UpdateFunctionRequest {

	private FunctionPlotter plotter;

	public UpdateFunctionRequest(FunctionPlotter plotter) {
		this.plotter = plotter;
	}

	public void updateFunctionLabel() {
		setNewFunctionLabel(plotter.getFunction().toString());
	}

	public abstract void setNewFunctionLabel(String newLabel);
}
