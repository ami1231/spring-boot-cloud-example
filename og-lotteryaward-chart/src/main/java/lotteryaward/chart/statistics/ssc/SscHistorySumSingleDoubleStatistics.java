package lotteryaward.chart.statistics.ssc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.ssc.common.SscHistorySumTwoFaceTemplate;

@Component
public class SscHistorySumSingleDoubleStatistics extends SscHistorySumTwoFaceTemplate {

	@Autowired
	@Qualifier("singleDoubleCompute")
	private ChartCompute<Integer, Integer> singleDoubleCompute;

	@Override
	protected ChartCompute<Integer, Integer> getChartCompute() {
		// 塞入平衡值
		return singleDoubleCompute;
	}

	@Override
	protected ChartTypeKey getChartTypeKey() {
		return ChartTypeKey.SingleDouble;
	}

	@Override
	protected String getKey() {
		return SscChartType.HistorySumSingleDouble.getKey();
	}

}