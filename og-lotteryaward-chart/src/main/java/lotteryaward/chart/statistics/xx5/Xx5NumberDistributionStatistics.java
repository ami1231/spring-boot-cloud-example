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
public class Xx5NumberDistributionStatistics implements StatisticsComponent {
	
	/**
	 * Xx5 號碼分佈-號碼
	 * 
	 * */
	
	@Autowired
	@Qualifier("distributionCompute")
	private ChartCompute<String,int[]> distributionCompute;
	
	private String key =Xx5ChartType.NumberDistribution.getKey();
	
	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		Map<String, Object> map =new HashMap<>(); 
		
		distributionCompute = ChartUtil.initChartComputeParam(distributionCompute, 11);
		int [] nowDistribution =distributionCompute.compute(vo.getAwardResult());	
		if(vo.getLastResult()!=null && vo.getLastResult().containsKey(key)){
			int [] lastDistribution = getMapValue(vo.getLastResult(), key, nowDistribution.getClass());
			nowDistribution = ChartValueUtils.intArrayValueMerge(nowDistribution, lastDistribution);
		}
		map.put(key, nowDistribution);
		
		return map;
	}
}
