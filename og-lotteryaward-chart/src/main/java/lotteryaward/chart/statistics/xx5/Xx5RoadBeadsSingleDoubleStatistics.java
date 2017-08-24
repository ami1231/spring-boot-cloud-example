package lotteryaward.chart.statistics.xx5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.xx5.common.Xx5RoadBeadsThreeFaceTemplate;

@Component
public class Xx5RoadBeadsSingleDoubleStatistics extends Xx5RoadBeadsThreeFaceTemplate {

	/**
	 * Xx5 單雙路珠
	 */

	@Autowired
	@Qualifier("singleDoubleBalanceCompute")
	private ChartCompute<Integer, Integer> singleDoubleBalanceCompute;

	private String key =Xx5ChartType.RoadBeadsSingleDouble.getKey();
	
	@Override
	protected ChartCompute<Integer, Integer> getChartCompute() {
		Integer value = 11;
		singleDoubleBalanceCompute = ChartUtil.initChartComputeParam(singleDoubleBalanceCompute, value);
		return singleDoubleBalanceCompute;
	}

	@Override
	protected String getKey() {
		return key;
	}

}
