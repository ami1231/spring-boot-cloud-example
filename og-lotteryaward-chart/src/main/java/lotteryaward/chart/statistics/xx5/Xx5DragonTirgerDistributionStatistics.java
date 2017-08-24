package lotteryaward.chart.statistics.xx5;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.common.ChartThreeTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.util.ChartValueUtils;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;
import lotteryaward.chart.statistics.xx5.util.Xx5StatisticsUtil;

@Component
public class Xx5DragonTirgerDistributionStatistics implements StatisticsComponent {

	/**
	 * XX5龍虎走勢
	 * @return
	 */
	
	@Autowired
	@Qualifier("dragonTigerBalanceCompute")
	private ChartCompute<Integer,Integer> dragonTigerBalanceCompute;
	
	private String key = Xx5ChartType.DragonTigerDistribution.getKey();
	
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		
		Map<String, Object> map = new HashMap<>();
		Integer[] awardResult = ChartUtil.getSplitNumberIntegerArray(vo.getAwardResult());
		Integer value = awardResult[0]-awardResult[awardResult.length-1];
		Integer[] nowDistribution = Xx5StatisticsUtil.doDragonTiger(dragonTigerBalanceCompute, value,ChartThreeTypeKey.DragonTiger);
		if(vo.getLastResult()!=null && vo.getLastResult().containsKey(key)){
			Integer[] lastValue = getMapValue(vo.getLastResult(), key,new Integer[0].getClass());
			nowDistribution = ChartValueUtils.integerArrayValueMerge(nowDistribution,lastValue);	
		}
		map.put(key,nowDistribution);
		return map;
	}
}
