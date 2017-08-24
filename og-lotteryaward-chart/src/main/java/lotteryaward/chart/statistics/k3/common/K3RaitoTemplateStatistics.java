package lotteryaward.chart.statistics.k3.common;

import java.util.HashMap;
import java.util.Map;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.common.ChartTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.k3.util.K3StatisticsUtil;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

/**
 * 統計K3大小單雙 走勢比例
 * @author Ami
 *
 */
public abstract class K3RaitoTemplateStatistics implements StatisticsComponent{

	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		Map<String, Object> map = new HashMap<>();
		Integer[] lastValues = getMapValue(vo.getLastResult(), getKey(), Integer[].class);
		map.put(getKey(), 
				K3StatisticsUtil.doSingelDoubleOrBigSmallRatio(getChartCompute(), vo.getAwardResult(), getChartTypeKey(), lastValues));
		return map;
	}

	protected abstract ChartCompute<Integer,Integer> getChartCompute();
	
	protected abstract ChartTypeKey getChartTypeKey();
	
	protected abstract String getKey();
}
