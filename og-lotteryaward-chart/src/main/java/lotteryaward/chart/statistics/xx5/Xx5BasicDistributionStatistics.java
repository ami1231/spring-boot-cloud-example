package lotteryaward.chart.statistics.xx5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.util.ChartValueUtils;
import lotteryaward.chart.statistics.vo.ChartResult;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

@Component
public class Xx5BasicDistributionStatistics implements StatisticsComponent {

	/**
	 * XX5基本走勢
	 * 
	 */

	@Autowired
	@Qualifier("fixNumberCompute")
	private ChartCompute<Integer, Integer[]> fixNumberCompute;

	private String key = Xx5ChartType.Distribution.getKey();

	@SuppressWarnings("unchecked")
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {

		Map<String, Object> map = new HashMap<>();
		
		List<Integer[]> nowDistribution = new ArrayList<>();
		fixNumberCompute = ChartUtil.initChartComputeParam(fixNumberCompute, 11);
		
		ChartResult chartResult = vo.getLastResult();
		Integer[] awardResult = ChartUtil.getSplitNumberIntegerArray(vo.getAwardResult());
		for (int i = 0; i < awardResult.length; i++) {
			// 每球的定位走勢
			Integer[] distributionArray = fixNumberCompute.compute(awardResult[i]);
			nowDistribution.add(distributionArray);
		}
		if (chartResult != null && chartResult.containsKey(key)) {
			List<Integer[]> lastDistribution = getMapValue(chartResult, key, List.class);
			if (!CollectionUtils.isEmpty(lastDistribution)) {
				nowDistribution = ChartValueUtils.listIntegerArrayValueMerge(nowDistribution, lastDistribution);
			}
		}
		// 號碼分布
		map.put(key, nowDistribution);
		return map;
	}
}
