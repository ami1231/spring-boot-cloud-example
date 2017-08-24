package lotteryaward.chart.statistics.xx5.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.common.ChartThreeTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;
import lotteryaward.chart.statistics.xx5.util.Xx5StatisticsUtil;

public abstract class Xx5HotColdTemplateStatistics implements StatisticsComponent {

	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		List<int[]> ballCounts = Xx5StatisticsUtil.doHotCold(vo.getTwentyResult(), getMinBallNum(),getMaxBallCount() );
		Map<String, Object> treeMap = new HashMap<>();
		// 取得第幾顆球
		for (int i = 0; i < ballCounts.size(); i++) {
			List<List<Map<String, Object>>> list = new ArrayList<>();
			List<Map<String, Object>> hot = new ArrayList<>();
			List<Map<String, Object>> warm = new ArrayList<>();
			List<Map<String, Object>> cold = new ArrayList<>();
			// 判斷每顆球是否為 Hot Warm Cold
			for (int j = 0; j < ballCounts.get(i).length; j++) {
				Map<String, Object> map = new LinkedHashMap<>();
				map.put("ballNum", j + 1);
				map.put("count", ballCounts.get(i)[j]);
				Integer type = getChartCompute().compute(ballCounts.get(i)[j]);
				if (type.equals(ChartThreeTypeKey.HotCold.getPvalue())) {
					hot.add(map);
				} else if (type.equals(ChartThreeTypeKey.HotCold.getIvalue())) {
					warm.add(map);
				} else {
					cold.add(map);
				}
			}
			list.add(hot);
			list.add(warm);
			list.add(cold);
			treeMap.put(getKeys()[i], list);
		}

		Map<String, Object> lastMap = new HashMap<>();
		lastMap.put(getKey(), treeMap);
		return lastMap;
	}

	protected abstract ChartCompute<Integer, Integer> getChartCompute();

	protected abstract String getKey();

	protected abstract String[] getKeys();

	protected abstract int getMinBallNum();

	protected abstract int getMaxBallCount();
}
