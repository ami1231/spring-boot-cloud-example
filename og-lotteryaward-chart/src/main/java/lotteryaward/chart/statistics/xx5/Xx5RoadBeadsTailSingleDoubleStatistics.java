package lotteryaward.chart.statistics.xx5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.xx5.common.Xx5RoadBeadsTwoFaceTemplate;

@Component
public class Xx5RoadBeadsTailSingleDoubleStatistics extends Xx5RoadBeadsTwoFaceTemplate {

	/**
	 * Xx5 尾和單雙 路珠
	 */

	@Autowired
	@Qualifier("singleDoubleCompute")
	private ChartCompute<Integer, Integer> singleDoubleCompute;

	private String key = Xx5ChartType.RoadBeadsTailSingleDouble.getKey();
	
	@Override
	protected ChartCompute<Integer, Integer> getChartCompute() {
		return singleDoubleCompute;
	}

	@Override
	protected String getKey() {
		return key;
	}

}
