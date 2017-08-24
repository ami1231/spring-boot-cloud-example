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
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

/**
 * 
 * @author Ami
 * 和值走勢
 */
@Component
public class K3NumberSumStatistics implements StatisticsComponent {

	@Autowired
	@Qualifier("sumRangeCompute")
	private ChartCompute<String,Integer[]> sumRangeCompute;

	private String key = K3ChartType.NumberSum.getKey();
	
	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		Map<String,Object> resultMap = new HashMap<>();
		Integer[] params = new Integer[2];
		params[0] = 3;
		params[1] = 18;
		ChartUtil.initChartComputeParam(sumRangeCompute, params);
		Integer[] values = sumRangeCompute.compute(vo.getAwardResult());
		Integer[] lastValues = getMapValue(vo.getLastResult(), key,Integer[].class);		
		values = ChartValueUtils.integerArrayValueMerge(values, lastValues);
		resultMap.put(key, values);
		return resultMap;
	}

}

