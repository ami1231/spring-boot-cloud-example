package lotteryaward.chart.statistics.xx5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.xx5.common.Xx5RoadBeadsThreeFaceTemplate;

@Component
public class Xx5RoadBeadsBigSmallStatistics extends Xx5RoadBeadsThreeFaceTemplate {

	/**
	 * Xx5 大小路珠
	 */

	@Autowired
	@Qualifier("bigSmallBalanceCompute")
	private ChartCompute<Integer, Integer> bigSmallBalanceCompute;

	private String key =Xx5ChartType.RoadBeadsBigSmall.getKey();

	@Override
	protected ChartCompute<Integer, Integer> getChartCompute() {
		Integer[] value = new Integer[] { 6, 11 };
		bigSmallBalanceCompute = ChartUtil.initChartComputeParam(bigSmallBalanceCompute, value);
		return bigSmallBalanceCompute;
	}

	@Override
	protected String getKey() {
		return key;
	}

}
