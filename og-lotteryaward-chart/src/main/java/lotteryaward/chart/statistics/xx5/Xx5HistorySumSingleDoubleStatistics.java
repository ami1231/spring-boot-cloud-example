package lotteryaward.chart.statistics.xx5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartThreeTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.xx5.common.Xx5HistorySumThreeFaceTemplate;

@Component
public class Xx5HistorySumSingleDoubleStatistics extends Xx5HistorySumThreeFaceTemplate {

	/**
	 * 即開畫面 歷史總和單雙
	 * 
	 */
	
	@Autowired
	@Qualifier("singleDoubleBalanceCompute")
	private ChartCompute<Integer, Integer> singleDoubleBalanceCompute;

	@Override
	protected ChartCompute<Integer, Integer> getChartCompute() {
		// 塞入平衡值
		singleDoubleBalanceCompute = ChartUtil.initChartComputeParam(singleDoubleBalanceCompute, 30);
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