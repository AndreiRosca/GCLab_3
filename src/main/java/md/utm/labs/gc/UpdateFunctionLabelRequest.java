package md.utm.labs.gc;

import javafx.scene.control.TitledPane;
import md.utm.labs.gc.draw.FunctionPlotter;

public class UpdateFunctionLabelRequest {

	private FunctionPlotter plotter;

	public UpdateFunctionLabelRequest(FunctionPlotter plotter) {
		this.plotter = plotter;
	}

	public void updateLabel(TitledPane titledPane) {
		titledPane.setText(plotter.getFunction().toString());
	}
}
