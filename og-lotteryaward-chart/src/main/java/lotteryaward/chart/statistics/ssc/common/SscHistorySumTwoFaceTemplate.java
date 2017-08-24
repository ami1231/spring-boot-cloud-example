package lotteryaward.chart.statistics.ssc.common;

import java.util.HashMap;
import java.util.Map;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.common.ChartTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

public abstract class SscHistorySumTwoFaceTemplate implements StatisticsComponent {

	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {

		Integer awardResult = ChartUtil.getSumResultNumber(vo.getAwardResult());
		// 初始化
		int[] lastDistribution = ChartUtil.initInt(2);

		int distribution = getChartCompute().compute(awardResult);

		if (vo.getLastHistoryResult() != null && vo.getLastHistoryResult().containsKey(getKey())) {
			lastDistribution = getMapValue(vo.getLastHistoryResult(), getKey(), new int[0].getClass());
		}

		if (distribution == getChartTypeKey().getPvalue()) {
			lastDistribution[0]++;
		} else if (distribution == getChartTypeKey().getNvalue()) {
			lastDistribution[1]++;
		}

		Map<String, Object> map = new HashMap<>();
		map.put(getKey(), lastDistribution);

		return map;
	}

	protected abstract ChartCompute<Integer, Integer> getChartCompute();

	protected abstract ChartTypeKey getChartTypeKey();

	protected abstract String getKey();
}
