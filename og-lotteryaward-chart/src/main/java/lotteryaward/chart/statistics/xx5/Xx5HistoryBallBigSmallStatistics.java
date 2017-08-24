package lotteryaward.chart.statistics.xx5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartThreeTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.xx5.common.Xx5HistoryThreeFaceDistributionTemplateStatistics;

@Component
public class Xx5HistoryBallBigSmallStatistics extends Xx5HistoryThreeFaceDistributionTemplateStatistics {
	
	/**
	 * Xx5歷史大小
	 */
	
	@Autowired
	@Qualifier("bigSmallBalanceCompute")
	private ChartCompute<Integer, Integer> bigSmallBalanceCompute;

	@Override
	protected ChartCompute<Integer, Integer> getChartCompute() {
		Integer[] value = new Integer[] { 6, 11 };
		bigSmallBalanceCompute = ChartUtil.initChartComputeParam(bigSmallBalanceCompute, value);
		return bigSmallBalanceCompute;
	}

	@Override
	protected ChartThreeTypeKey getChartThreeTypeKey() {
		return ChartThreeTypeKey.BigSmall;
	}

	@Override
	protected String getKey() {
		return Xx5ChartType.HistoryBallBigSmall.getKey();
	}

}
