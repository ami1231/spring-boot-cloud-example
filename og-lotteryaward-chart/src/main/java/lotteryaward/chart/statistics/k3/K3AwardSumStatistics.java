package lotteryaward.chart.statistics.k3;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.common.ChartTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

@Component
public class K3AwardSumStatistics implements StatisticsComponent{

	@Autowired
	@Qualifier("bigSmallCompute")
	private ChartCompute<Integer,Integer> bigSmallCompute;
	
	@Autowired
	@Qualifier("singleDoubleCompute")
	private ChartCompute<Integer,Integer> singleDoubleCompute;
	
	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		
		ChartUtil.initChartComputeParam(bigSmallCompute, 11);
		
		Map<String, Object> map =new HashMap<>(); 
		Integer result = ChartUtil.getSumResultNumber(vo.getAwardResult());
		map.put(ChartTypeKey.BigSmall.getKey(), bigSmallCompute.compute(result));
		map.put(ChartTypeKey.SingleDouble.getKey(), singleDoubleCompute.compute(result));		
		map.put("sumValue", result);
		Map<String, Object> resultMap =new HashMap<>(); 
		resultMap.put(K3ChartType.AwardSum.getKey(), map);
		return resultMap;
	}

}
