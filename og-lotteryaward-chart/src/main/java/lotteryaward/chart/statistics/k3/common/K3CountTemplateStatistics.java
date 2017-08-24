package lotteryaward.chart.statistics.k3.common;

import java.util.HashMap;
import java.util.Map;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.k3.util.K3StatisticsUtil;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

/**
 * 計算快3 大小,單雙出現幾個共用模板
 * @author Ami
 *
 */
public abstract class K3CountTemplateStatistics implements StatisticsComponent {

	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		Map<String, Object> map = new HashMap<>();
		Integer[] values = new Integer[4];
		Integer[] lastValues = getMapValue(vo.getLastResult(), getKey(), Integer[].class);
		
		values = K3StatisticsUtil.doSingelDoubleOrBigSmallCount(getChartCompute(),
				vo.getAwardResult(), getCheckValue(), lastValues);
		map.put(getKey(), values);
		return map;
	}

	protected abstract ChartCompute<Integer,Integer> getChartCompute();
	
	protected abstract Integer getCheckValue();
	
	protected abstract String getKey();
}
