package lotteryaward.chart.statistics.xx5.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.common.ChartThreeTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

public abstract class Xx5HistoryThreeFaceDistributionTemplateStatistics implements StatisticsComponent {

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {

		Integer[] awardResult = ChartUtil.getSplitNumberIntegerArray(vo.getAwardResult());
		// 初始化
		List<int[]> lastDistribution = ChartUtil.initListInt(awardResult.length, 3);

		int[] distribution = new int[awardResult.length];
		for (int i = 0; i < awardResult.length; i++) {
			distribution[i] = getChartCompute().compute(awardResult[i]);
		}

		if (vo.getLastHistoryResult() != null && vo.getLastHistoryResult().containsKey(getKey())) {
			lastDistribution = getMapValue(vo.getLastHistoryResult(), getKey(), List.class);
		}

		for (int i = 0; i < distribution.length; i++) {
			if (distribution[i] == getChartThreeTypeKey().getPvalue()) {
				lastDistribution.get(i)[0]++;
			} else if (distribution[i] == getChartThreeTypeKey().getNvalue()) {
				lastDistribution.get(i)[1]++;
			} else if (distribution[i] == getChartThreeTypeKey().getIvalue()) {
				lastDistribution.get(i)[2]++;
			}
		}

		Map<String, Object> map = new HashMap<>();
		map.put(getKey(), lastDistribution);

		return map;
	}

	protected abstract ChartCompute<Integer, Integer> getChartCompute();

	protected abstract ChartThreeTypeKey getChartThreeTypeKey();

	protected abstract String getKey();
}
