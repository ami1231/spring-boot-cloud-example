package lotteryaward.chart.statistics.k3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

/**
 * 
 * @author Ami
 *
 */
@Component
public class K3FixNumberDistributionStatistics implements StatisticsComponent{

	@Autowired
	@Qualifier("fixNumberCompute")
	private ChartCompute<Integer,Integer[]> fixNumberCompute;
	
	private String key = K3ChartType.FixDistribution.getKey();
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		Map<String, Object> map = new HashMap<>();
		String awardResult = vo.getAwardResult();
		ChartResult chartResult = vo.getLastResult();
		ChartUtil.initChartComputeParam(fixNumberCompute,6);
		
		List<Integer[]> fixDistributions = new ArrayList<Integer[]>();		
		
		List<Integer[]> lastFixDistributions = getMapValue(chartResult, key, List.class);	

		Integer index = 0;
		for(String s:ChartUtil.getSplitNumberArray(awardResult)){
			Integer result = Integer.valueOf(s);
			Integer[] distributionArray = fixNumberCompute.compute(result);
			Integer[] lastDistribution =  lastFixDistributions.get(index);			
			distributionArray = ChartValueUtils.integerArrayValueMerge(distributionArray, lastDistribution);						
			index++;
			fixDistributions.add(distributionArray);
		}
		//號碼分布
		map.put(key,fixDistributions);
		return map;
	}

}
