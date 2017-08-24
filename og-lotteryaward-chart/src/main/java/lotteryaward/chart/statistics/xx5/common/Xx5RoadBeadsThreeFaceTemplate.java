package lotteryaward.chart.statistics.xx5.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotteryaward.chart.statistics.HistoryDayStatisticsComponent;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

public abstract class Xx5RoadBeadsThreeFaceTemplate implements HistoryDayStatisticsComponent {

	@SuppressWarnings({ "unchecked", "null", "unused" })
	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		Integer[] awardResult = ChartUtil.getSplitNumberIntegerArray(vo.getAwardResult());
		List<List<Integer>> roadBeads = getMapValue(vo.getLastResult(), getKey(), List.class);
		if(roadBeads == null){
			for(Integer s : awardResult ){
				roadBeads.add(new ArrayList<>());
			}
		}
		for (int i = 0; i < awardResult.length; i++) {
			roadBeads.get(i).add(getChartCompute().compute(awardResult[i]));
		}
		Map<String,Object> map = new HashMap<String, Object>();
		map.put(getKey(), roadBeads);
		return map;
	}

	protected abstract ChartCompute<Integer, Integer> getChartCompute();

	protected abstract String getKey();
}
