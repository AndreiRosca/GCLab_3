package md.utm.labs.gc;

import javafx.scene.control.TitledPane;
import md.utm.labs.gc.draw.FunctionPlotter;
import md.utm.labs.gc.request.UpdateFunctionRequest;

public class UpdateFunctionLabelRequest extends UpdateFunctionRequest {

	private String newLabel;

	public UpdateFunctionLabelRequest(FunctionPlotter plotter) {
		super(plotter);
	}

	public void updateLabel(TitledPane titledPane) {
		super.updateFunctionLabel();
		titledPane.setText(newLabel);
	}

	@Override
	public void setNewFunctionLabel(String newLabel) {
		this.newLabel = newLabel;
	}
}
