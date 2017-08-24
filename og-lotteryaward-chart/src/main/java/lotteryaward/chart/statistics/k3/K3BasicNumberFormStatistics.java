package lotteryaward.chart.statistics.k3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.common.ChartTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartValueUtils;
import lotteryaward.chart.statistics.vo.ChartResult;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

/**
 * 
 * @author Ami
 *
 */
@Component
public class K3BasicNumberFormStatistics implements StatisticsComponent {

	@Autowired
	@Qualifier("tripleSameCompute")
	private ChartCompute<String,Integer> tripleCompute;
	
	@Autowired
	@Qualifier("doubleSameCompute")	
	private ChartCompute<String,Integer> doubleCompute;
	
	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		
		String tripleSameKey=ChartTypeKey.TripleSame.getKey();		
		String doubleSameKey=ChartTypeKey.DoubleSame.getKey();		
		String threeDifferentKey=K3ChartType.ThreeDifferent.getKey();
		
		
		Map<String,Object> resultMap = new HashMap<>();
		ChartResult lastResult = vo.getLastResult();
		String awardResult = vo.getAwardResult();
		
		Integer lastTriple = getMapValue(lastResult, tripleSameKey, Integer.class);
		Integer lastDouble = getMapValue(lastResult, doubleSameKey, Integer.class);
		Integer lastThreeDifferent = getMapValue(lastResult, threeDifferentKey, Integer.class);
		
		Integer tripleSmaeValue = tripleCompute.compute(awardResult);
		Integer doubleSmaeValue = doubleCompute.compute(awardResult);
		Integer threeDifferentValue = 0;
		Set<String> set = Arrays.stream(vo.getAwardResult().split(COMMADN)).collect(Collectors.toSet());
		if(set.size()==3){
			threeDifferentValue = 1;
		}else{
			threeDifferentValue = -1;
		}
		
		tripleSmaeValue = ChartValueUtils.singleValueMerge(tripleSmaeValue, lastTriple);
		doubleSmaeValue = ChartValueUtils.singleValueMerge(doubleSmaeValue, lastDouble);
		threeDifferentValue = ChartValueUtils.singleValueMerge(threeDifferentValue, lastThreeDifferent);
		
		resultMap.put(tripleSameKey, tripleSmaeValue);
		resultMap.put(doubleSameKey, doubleSmaeValue);
		resultMap.put(threeDifferentKey, threeDifferentValue);
		
		return resultMap;
	}

}
