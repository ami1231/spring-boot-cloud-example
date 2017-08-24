package lotteryaward.chart.statistics.ssc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.ssc.common.SscTwoFaceDistributionTemplateStatistics;


@Component
public class SscSingleDoubleDistributionStatistics extends SscTwoFaceDistributionTemplateStatistics{
	
	@Autowired
	@Qualifier("singleDoubleCompute")
	private ChartCompute<Integer,Integer> singleDoubleCompute;

	@Override
	protected ChartCompute<Integer, Integer> getChartCompute() {
		return singleDoubleCompute;
	}

	@Override
	protected ChartTypeKey getChartTypeKey() {
		return ChartTypeKey.SingleDouble;
	}

	@Override
	protected String getKey() {
		return SscChartType.SingleDoubleDisbution.getKey();
	}

}