package lotteryaward.chart.statistics.xx5;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.util.ChartValueUtils;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

@Component
public class Xx5SumDistributionStatistics implements StatisticsComponent {

	/**
	 * Xx5 總和走勢
	 * 
	 */

	@Autowired
	@Qualifier("fixNumberCompute")
	private ChartCompute<Integer, Integer[]> fixNumberCompute;

	private String key = Xx5ChartType.SumDistribution.getKey();

	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer sumValue = ChartUtil.getSumResultNumber(vo.getAwardResult());
		fixNumberCompute = ChartUtil.initChartComputeParam(fixNumberCompute, 31);
		
		Integer [] nowDistribution = fixNumberCompute.compute(sumValue-14);
		Integer [] lastDistribution = getMapValue(vo.getLastResult(), key, nowDistribution.getClass());
		if(lastDistribution !=null){
			ChartValueUtils.integerArrayValueMerge(nowDistribution, lastDistribution);
		} 
		map.put(key, nowDistribution);
		return map;
	}

}
