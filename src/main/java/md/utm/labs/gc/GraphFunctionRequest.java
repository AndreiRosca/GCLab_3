package md.utm.labs.gc;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import md.utm.labs.gc.draw.FunctionPlotter;
import md.utm.labs.gc.draw.Point;
import md.utm.labs.gc.request.GraphRequest;

public class GraphFunctionRequest extends GraphRequest {

	private final NumberAxis xAxis = new NumberAxis();
	private final NumberAxis yAxis = new NumberAxis();
	private final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
	private XYChart.Series<Number, Number> series = new XYChart.Series<>();

	public GraphFunctionRequest(FunctionPlotter plotter) {
		super(plotter);
	}

	public void graph(AnchorPane anchorPane) {
		super.graph();
		setLineChartProperties();
		anchorPane.getChildren().add(lineChart);
	}

	private void setLineChartProperties() {
		lineChart.setCreateSymbols(false);
		lineChart.setLegendVisible(false);
		lineChart.setMaxWidth(400);
		lineChart.getData().add(series);
	}

	@Override
	public void draw(Point point) {
		series.getData().add(new XYChart.Data<>(point.getX(), point.getY()));
	}
}
