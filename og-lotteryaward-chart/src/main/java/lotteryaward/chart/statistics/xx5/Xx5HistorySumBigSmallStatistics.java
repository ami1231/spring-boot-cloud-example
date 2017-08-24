package lotteryaward.chart.statistics.xx5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartThreeTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.xx5.common.Xx5HistorySumThreeFaceTemplate;

@Component
public class Xx5HistorySumBigSmallStatistics extends Xx5HistorySumThreeFaceTemplate {
	
	/**
	 * 即開畫面 歷史總和大小
	 * 
	 */
	
	@Autowired
	@Qualifier("bigSmallBalanceCompute")
	private ChartCompute<Integer, Integer> bigSmallBalanceCompute;

	@Override
	protected ChartCompute<Integer, Integer> getChartCompute() {
		Integer[] value = new Integer[] { 30, 30 };
		// 塞入平衡值
		bigSmallBalanceCompute = ChartUtil.initChartComputeParam(bigSmallBalanceCompute, value);
		return bigSmallBalanceCompute;
	}

	@Override
	protected ChartThreeTypeKey getChartThreeTypeKey() {
		return ChartThreeTypeKey.BigSmall;
	}

	@Override
	protected String getKey() {
		return Xx5ChartType.HistorySumBigSmall.getKey();
	}

}