package lotteryaward.chart.statistics.ssc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.ssc.common.SscHistoryTwoFaceTemplate;
import lotteryaward.chart.statistics.util.ChartUtil;

@Component
public class SscHistoryBallBigSmallStatistics extends SscHistoryTwoFaceTemplate {

	@Autowired
	@Qualifier("bigSmallCompute")
	private ChartCompute<Integer, Integer> bigSmallCompute;

	@Override
	protected ChartCompute<Integer, Integer> getChartCompute() {
		bigSmallCompute = ChartUtil.initChartComputeParam(bigSmallCompute, 5);
		return bigSmallCompute;
	}

	@Override
	protected ChartTypeKey getChartTypeKey() {
		return ChartTypeKey.SingleDouble;
	}

	@Override
	protected String getKey() {
		return SscChartType.HistroyBallBigSmall.getKey();
	}

}
