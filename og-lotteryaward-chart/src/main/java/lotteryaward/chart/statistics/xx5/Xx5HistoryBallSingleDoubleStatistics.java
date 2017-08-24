package lotteryaward.chart.statistics.xx5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartThreeTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.xx5.common.Xx5HistoryThreeFaceDistributionTemplateStatistics;

@Component
public class Xx5HistoryBallSingleDoubleStatistics extends Xx5HistoryThreeFaceDistributionTemplateStatistics {
	
	/**
	 * Xx5歷史單雙
	 * 
	 * 
	 */
	
	@Autowired
	@Qualifier("singleDoubleBalanceCompute")
	private ChartCompute<Integer, Integer> singleDoubleBalanceCompute;

	@Override
	protected ChartCompute<Integer, Integer> getChartCompute() {
		// 塞入平衡值
		singleDoubleBalanceCompute = ChartUtil.initChartComputeParam(singleDoubleBalanceCompute, 11);
		return singleDoubleBalanceCompute;
	}

	@Override
	protected ChartThreeTypeKey getChartThreeTypeKey() {
		return ChartThreeTypeKey.SingleDouble;
	}

	@Override
	protected String getKey() {
		return Xx5ChartType.HistorySumSingleDouble.getKey();
	}

}
