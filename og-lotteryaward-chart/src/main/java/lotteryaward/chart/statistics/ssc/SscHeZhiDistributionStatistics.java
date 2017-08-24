package lotteryaward.chart.statistics.ssc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.ssc.common.SscTwoFaceDistributionTemplateStatistics;

@Component
public class SscHeZhiDistributionStatistics  extends SscTwoFaceDistributionTemplateStatistics{
	
	
	@Autowired
	@Qualifier("heZhiCompute")
	private ChartCompute<Integer,Integer> heZhiCompute;
	
	@Override
	protected ChartCompute<Integer, Integer> getChartCompute() {
		return heZhiCompute;
	}

	@Override
	protected ChartTypeKey getChartTypeKey() {
		return ChartTypeKey.HeZhi;
	}

	@Override
	protected String getKey() {
		return SscChartType.HeZhiDisbution.getKey();
	}
			

}
