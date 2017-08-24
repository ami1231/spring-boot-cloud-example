package lotteryaward.chart.statistics.ssc.common;

import java.util.HashMap;
import java.util.Map;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.common.ChartTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.ssc.util.SscStatisticsUtil;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

public abstract class SscTwoFaceDistributionTemplateStatistics implements StatisticsComponent{

	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		Map<String, Object> map = new HashMap<>();

		map.put(getKey(), SscStatisticsUtil.twoFaceDistribution
				(vo, getKey(), getChartCompute(), getChartTypeKey()));
		return map;
	}
	
	protected abstract ChartCompute<Integer,Integer> getChartCompute();
	
	protected abstract ChartTypeKey getChartTypeKey();
	
	protected abstract String getKey();
	

}
