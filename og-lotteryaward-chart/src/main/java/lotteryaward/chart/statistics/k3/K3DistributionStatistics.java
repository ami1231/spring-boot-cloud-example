package lotteryaward.chart.statistics.k3;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.util.ChartValueUtils;
import lotteryaward.chart.statistics.vo.ChartResult;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

@Component
public class K3DistributionStatistics implements StatisticsComponent {

	@Autowired
	@Qualifier("distributionCompute")
	private ChartCompute<String,int[]> distributionCompute;

	@Autowired
	@Qualifier("distributionCountCompute")
	private ChartCompute<String,int[]> distributionCountCompute;
	
	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		String distributionKey = K3ChartType.Distribution.getKey();
		String distributionCountKey = K3ChartType.DistributionCount.getKey();
		
		Map<String, Object> map = new HashMap<>();
		String awardResult = vo.getAwardResult();
		ChartResult chartResult = vo.getLastResult();

		//compute 參數初始化
		ChartUtil.initChartComputeParam(distributionCompute,6);
		ChartUtil.initChartComputeParam(distributionCountCompute,6);
		
		int[] distributionArray = distributionCompute.compute(awardResult);
		int[] lastDistribution = getMapValue(chartResult, distributionKey, int[].class);
		distributionArray = ChartValueUtils.intArrayValueMerge(distributionArray, lastDistribution);
		//號碼分布
		map.put(distributionKey, distributionArray);

		int[] distributionCountArray = distributionCountCompute.compute(awardResult);
		//是否多重號
		map.put(distributionCountKey, distributionCountArray);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.putAll(map);
		return resultMap;
		
	}
	
}