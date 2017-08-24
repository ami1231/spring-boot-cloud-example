package lotteryaward.chart.statistics.k3;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.common.ChartTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.k3.util.K3StatisticsUtil;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

/**
 * 
 * @author Ami
 *
 */
@Component
public class K3SumSingleDoubleStatistics implements StatisticsComponent {

	@Autowired
	@Qualifier("singleDoubleCompute")
	private ChartCompute<Integer,Integer> singleDoubleCompute;
	
	private String key = K3ChartType.SumSingleDouble.getKey();	
	
	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		Map<String, Object> map = new HashMap<>();
		Integer sumValue = ChartUtil.getSumResultNumber(vo.getAwardResult());
		Integer[] values = new Integer[0];
		Integer[] lastValues = getMapValue(vo.getLastResult(), key, Integer[].class);
		
		values = K3StatisticsUtil.
				doSingelDoubleOrBigSmall(singleDoubleCompute, sumValue, ChartTypeKey.SingleDouble, lastValues);
		
		map.put(key, values);
		
		return map;
	}
}
