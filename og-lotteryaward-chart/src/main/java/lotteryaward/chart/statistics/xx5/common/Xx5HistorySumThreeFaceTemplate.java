package lotteryaward.chart.statistics.xx5.common;

import java.util.HashMap;
import java.util.Map;

import lotteryaward.chart.statistics.HistoryDayStatisticsComponent;
import lotteryaward.chart.statistics.common.ChartThreeTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

public abstract class Xx5HistorySumThreeFaceTemplate implements HistoryDayStatisticsComponent {

	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {

		Integer awardResult = ChartUtil.getSumResultNumber(vo.getAwardResult());
		// 初始化
		int[] lastDistribution = ChartUtil.initInt(3);

		int distribution = getChartCompute().compute(awardResult);

		if (vo.getLastHistoryResult() != null && vo.getLastHistoryResult().containsKey(getKey())) {
			lastDistribution = getMapValue(vo.getLastHistoryResult(), getKey(), new int[0].getClass());
		}

		if (distribution == getChartThreeTypeKey().getPvalue()) {
			lastDistribution[0]++;
		} else if (distribution == getChartThreeTypeKey().getNvalue()) {
			lastDistribution[1]++;
		} else if (distribution == getChartThreeTypeKey().getIvalue()) {
			lastDistribution[2]++;
		}

		Map<String, Object> map = new HashMap<>();
		map.put(getKey(), lastDistribution);

		return map;
	}

	protected abstract ChartCompute<Integer, Integer> getChartCompute();

	protected abstract ChartThreeTypeKey getChartThreeTypeKey();

	protected abstract String getKey();
}
