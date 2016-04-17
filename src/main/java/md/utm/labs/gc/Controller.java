package md.utm.labs.gc;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import md.utm.labs.gc.draw.FunctionPlotter;
import md.utm.labs.gc.draw.FunctionPlotterFactory;

public class Controller implements Initializable {

	@FXML
	private TitledPane firstFunctionPane;

	@FXML
	private TitledPane secondFunctionPane;

	@FXML
	private TitledPane thirdFunctionPane;

	@FXML
	private AnchorPane firstFunctionAnchorPane;

	@FXML
	private AnchorPane secondFunctionAnchorPane;

	@FXML
	private AnchorPane thirdFunctionAnchorPane;

	@FXML
	private Slider coefficientSlider;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		graphFunctions();
		coefficientSlider.valueProperty().addListener(new SliderChangeListener());
	}

	private class SliderChangeListener implements ChangeListener<Number> {
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
			clearGraphs();
			graphFunctions(newValue.doubleValue());
		}

		private void clearGraphs() {
			clearMenuItemPressed();
		}
	}

	private void graphFunctions(double coefficient) {
		FunctionPlotter plotter = FunctionPlotterFactory.getSinePlotter(coefficient);
		new GraphFunctionRequest(plotter).graph(firstFunctionAnchorPane);
		new UpdateFunctionLabelRequest(plotter).updateLabel(firstFunctionPane);

		plotter = FunctionPlotterFactory.getCosinePlotter(coefficient);
		new GraphFunctionRequest(plotter).graph(secondFunctionAnchorPane);
		new UpdateFunctionLabelRequest(plotter).updateLabel(secondFunctionPane);

		new GraphFunctionRequest(FunctionPlotterFactory.getCubePlotter()).graph(thirdFunctionAnchorPane);
	}

	private void graphFunctions() {
		graphFunctions(2.0);
	}

	@FXML
	public void quitMenuItemPressed() {
		Platform.exit();
	}

	@FXML
	public void clearMenuItemPressed() {
		firstFunctionAnchorPane.getChildren().clear();
		secondFunctionAnchorPane.getChildren().clear();
		thirdFunctionAnchorPane.getChildren().clear();
	}
}
