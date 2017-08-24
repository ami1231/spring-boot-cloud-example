package lotteryaward.chart.statistics.ssc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartThreeTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.ssc.common.SscThreeFaceDistributionTemplateStatistics;

@Component
public class SscZeroOneTwoDistributionStatistics extends SscThreeFaceDistributionTemplateStatistics{
	
	@Autowired
	@Qualifier("zeroOneTwoCompute")
	private ChartCompute<Integer,Integer> zeroOneTwoCompute;
	
	@Override
	protected ChartCompute<Integer, Integer> getChartCompute() {
		return zeroOneTwoCompute;
	}

	@Override
	protected ChartThreeTypeKey getChartTypeKey() {
		return ChartThreeTypeKey.ZeroOneTwo;
	}

	@Override
	protected String getKey() {
		return SscChartType.ZeroOneTwoDisbution.getKey();
	}
}
