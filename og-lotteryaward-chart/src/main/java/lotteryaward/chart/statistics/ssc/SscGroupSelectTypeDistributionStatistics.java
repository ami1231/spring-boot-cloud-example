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
import lotteryaward.chart.statistics.common.ChartThreeTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.ssc.util.SscStatisticsUtil;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.vo.ChartResult;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

@Component
public class SscGroupSelectTypeDistributionStatistics implements StatisticsComponent{
	
	@Autowired
	@Qualifier("groupSelectTypeCompute")
	private ChartCompute<Integer[],Integer> groupSelectTypeCompute;
	
	private String key = SscChartType.GroupSelectType.getKey();

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {

		Integer[] resultArray =  ChartUtil.getSplitNumberIntegerArray(vo.getAwardResult());
		Map<String, Object> map = new HashMap<>();
		ChartResult chartResult = vo.getLastResult();
		List<Integer[]> lastDistribution = new ArrayList<>();
		List<Integer[]> distribution = new ArrayList<>();
		
		if(chartResult!=null && chartResult.containsKey(key)){
			lastDistribution = getMapValue(chartResult, key,List.class);
		}
		//前中後三
		for(int i=0;i<resultArray.length-2;i++){
			Integer[] value = new Integer[]{resultArray[i],resultArray[i+1],resultArray[i+2]};
			
			Integer[] lastArray = null;			
			if(!CollectionUtils.isEmpty(lastDistribution)){
				lastArray = lastDistribution.get(i);
			}
		
			distribution.add( SscStatisticsUtil.threeFaceCheck(groupSelectTypeCompute, value, ChartThreeTypeKey.GroupSelectType, lastArray)); 
		}
		
		map.put(key, distribution);
		
		return map;
	}
	
	
	
}
