package lotteryaward.chart.statistics.xx5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

@Component
public class Xx5RoadBeadsDragonTigerStatistics implements StatisticsComponent {

	/**
	 * Xx5 龍虎 路珠
	 */

	@Autowired
	@Qualifier("dragonTigerBalanceCompute")
	private ChartCompute<Integer, Integer> dragonTigerBalanceCompute;

	private String key = Xx5ChartType.RoadBeadsDragonTiger.getKey();
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		Map<String, Object> map = new HashMap<>();
		List<Integer> lastResult= new ArrayList<>();
		Integer[] awardResult = ChartUtil.getSplitNumberIntegerArray(vo.getAwardResult());
		Integer value = awardResult[0]-awardResult[awardResult.length-1];
		if(vo.getLastResult()!=null && vo.getLastResult().containsKey(key)){
			lastResult = new ArrayList<>(getMapValue(vo.getLastResult(), key,List.class));
		}
		lastResult.add(dragonTigerBalanceCompute.compute(value));
		map.put(key,lastResult);
		return map;
	}
}
