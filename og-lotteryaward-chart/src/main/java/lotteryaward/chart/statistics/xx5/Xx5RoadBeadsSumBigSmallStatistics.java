package lotteryaward.chart.statistics.xx5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.xx5.common.Xx5RoadBeadsSumThreeFaceTemplate;

@Component
public class Xx5RoadBeadsSumBigSmallStatistics extends Xx5RoadBeadsSumThreeFaceTemplate {

	/**
	 * Xx5  總和大小路珠
	 */

	@Autowired
	@Qualifier("bigSmallBalanceCompute")
	private ChartCompute<Integer, Integer> bigSmallBalanceCompute;

	private String key =Xx5ChartType.RoadBeadsSumBigSmall.getKey();

	@Override
	protected ChartCompute<Integer, Integer> getChartCompute() {
		Integer[] value = new Integer[] {30, 30 };
		bigSmallBalanceCompute = ChartUtil.initChartComputeParam(bigSmallBalanceCompute, value);
		return bigSmallBalanceCompute;
	}

	@Override
	protected String getKey() {
		return key;
	}

}
