package lotteryaward.chart.statistics.xx5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.xx5.common.Xx5RoadBeadsSumThreeFaceTemplate;

@Component
public class Xx5RoadBeadsTailBigSmallStatistics extends Xx5RoadBeadsSumThreeFaceTemplate {

	/**
	 * Xx5  尾和大小路珠
	 */

	@Autowired
	@Qualifier("bigSmallCompute")
	private ChartCompute<Integer, Integer> bigSmallCompute;

	private String key =Xx5ChartType.RoadBeadsTailBigSmall.getKey();

	@Override
	protected ChartCompute<Integer, Integer> getChartCompute() {
		Integer value = 6;
		bigSmallCompute = ChartUtil.initChartComputeParam(bigSmallCompute, value);
		return bigSmallCompute;
	}

	@Override
	protected String getKey() {
		return key;
	}

}
