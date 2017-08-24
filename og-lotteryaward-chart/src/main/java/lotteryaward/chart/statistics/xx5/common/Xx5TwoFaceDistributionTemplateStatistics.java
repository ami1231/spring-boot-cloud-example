package lotteryaward.chart.statistics.xx5.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.common.ChartTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.k3.util.K3StatisticsUtil;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

public abstract class Xx5TwoFaceDistributionTemplateStatistics implements StatisticsComponent{

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		
		Integer[] awardResult = ChartUtil.getSplitNumberIntegerArray(vo.getAwardResult());
		Map<String, Object> map = new HashMap<>();
		List<Integer[]> lastValue = null;
		List<Integer[]> nowValue = new ArrayList<>();
		if(vo.getLastResult()!=null && vo.getLastResult().containsKey(getKey())){
			lastValue = getMapValue(vo.getLastResult(), getKey() , List.class);
		}
		for (int i = 0; i < awardResult.length; i++) {
			nowValue.add(K3StatisticsUtil.doSingelDoubleOrBigSmall(getChartCompute(), awardResult[i], getChartTypeKey(), lastValue.get(i)));		
		}
		map.put( getKey(), nowValue);
		return map;
	}
	
	protected abstract ChartCompute<Integer,Integer> getChartCompute();
	
	protected abstract ChartTypeKey getChartTypeKey();
	
	protected abstract String getKey();
}
