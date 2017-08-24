package lotteryaward.chart.statistics.ssc.common;

import java.util.HashMap;
import java.util.Map;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.common.ChartThreeTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.ssc.util.SscStatisticsUtil;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

public abstract class SscThreeFaceDistributionTemplateStatistics  implements StatisticsComponent{

	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		Map<String, Object> map = new HashMap<>();
		map.put(getKey(), SscStatisticsUtil.threeFaceDistribution
				(vo, getKey(), getChartCompute(), getChartTypeKey()));
		return map;
	}
	
	protected abstract ChartCompute<Integer,Integer> getChartCompute();
	
	protected abstract ChartThreeTypeKey getChartTypeKey();
	
	protected abstract String getKey();
}
