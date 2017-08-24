package lotteryaward.chart.statistics.ssc;

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
public class SscBasicDistributionStatistics implements StatisticsComponent {
	
	
	@Autowired
	@Qualifier("fixNumberCompute")
	private ChartCompute<Integer,Integer[]> fixNumberCompute;
	
	private String key = SscChartType.Distribution.getKey();
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		
		Map<String, Object> map = new HashMap<>();
		
		String awardResult = vo.getAwardResult();
		ChartResult chartResult = vo.getLastResult();
		
		List<Integer[]> nowdistribution = new ArrayList<>();
			
		fixNumberCompute = ChartUtil.initChartComputeParam(fixNumberCompute,10);
		
		Integer[] array =  ChartUtil.getSplitNumberIntegerArray(awardResult);
		
		for(int i = 0; i < array.length;i++){
			//每球的定位走勢 fixNumberCompute 方法從 n+1 號球開始判斷
			Integer[] distributionArray = fixNumberCompute.compute(array[i]+1);
			nowdistribution.add(distributionArray);
		}
		if(chartResult!=null && chartResult.containsKey(key)){
			List<Integer[]> lastDistribution = getMapValue(vo.getLastResult(), key,List.class);
			if(!CollectionUtils.isEmpty(lastDistribution)){
				nowdistribution = ChartValueUtils.listIntegerArrayValueMerge(nowdistribution, lastDistribution);
			}
		
		}
		//號碼分布
		map.put(key, nowdistribution);
		
	
		return map;
		
	}

}
