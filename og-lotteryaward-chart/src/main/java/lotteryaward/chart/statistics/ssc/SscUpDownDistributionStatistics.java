package lotteryaward.chart.statistics.ssc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartThreeTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.ssc.common.SscThreeFaceDistributionTemplateStatistics;

@Component
public class SscUpDownDistributionStatistics extends SscThreeFaceDistributionTemplateStatistics{
	
	@Autowired
	@Qualifier("upDownCompute")
	private ChartCompute<Integer,Integer> upDownCompute;
	
	@Override
	protected ChartCompute<Integer, Integer> getChartCompute() {
		return upDownCompute;
	}

	@Override
	protected ChartThreeTypeKey getChartTypeKey() {
		return ChartThreeTypeKey.UpDown;
	}

	@Override
	protected String getKey() {
		return SscChartType.UpDownDisbution.getKey();
	}
}