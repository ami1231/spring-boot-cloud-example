package lotteryaward.chart.statistics.ssc.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.common.ChartTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

public abstract class SscHistoryTwoFaceTemplate implements StatisticsComponent {

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {

		Integer[] awardResult = ChartUtil.getSplitNumberIntegerArray(vo.getAwardResult());
		// 初始化
		List<int[]> lastDistribution = ChartUtil.initListInt(awardResult.length, 2);

		int[] distribution = new int[awardResult.length];
		for (int i = 0; i < awardResult.length; i++) {
			distribution[i] = getChartCompute().compute(awardResult[i]);
		}

		if (vo.getLastHistoryResult() != null && vo.getLastHistoryResult().containsKey(getKey())) {
			lastDistribution = getMapValue(vo.getLastHistoryResult(), getKey(), List.class);
		}

		for (int i = 0; i < distribution.length; i++) {
			if (distribution[i] == getChartTypeKey().getPvalue()) {
				lastDistribution.get(i)[0]++;
			} else{
				lastDistribution.get(i)[1]++;
			}
		}

		Map<String, Object> map = new HashMap<>();
		map.put(getKey(), lastDistribution);

		return map;
	}

	protected abstract ChartCompute<Integer, Integer> getChartCompute();

	protected abstract ChartTypeKey getChartTypeKey();

	protected abstract String getKey();
}
