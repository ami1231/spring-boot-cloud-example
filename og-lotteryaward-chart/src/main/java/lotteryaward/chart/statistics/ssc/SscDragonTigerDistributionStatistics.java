package lotteryaward.chart.statistics.ssc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.common.ChartThreeTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.ssc.util.SscStatisticsUtil;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.vo.ChartResult;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

@Component
public class SscDragonTigerDistributionStatistics  implements StatisticsComponent{
	
	@Autowired
	@Qualifier("dragonTigerBalanceCompute")
	private ChartCompute<Integer,Integer> dragonTigerBalanceCompute;
	
	private String key = SscChartType.DragonTigerDisbution.getKey();

	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		
		ChartResult chartResult = vo.getLastResult();
		Integer[] resultArray =  ChartUtil.getSplitNumberIntegerArray(vo.getAwardResult());
		Map<String, Object> map = new HashMap<>();
		Integer[] lastDistribution = getMapValue(chartResult, key,Integer[].class);
		Integer[]  resultDistribution = SscStatisticsUtil.threeFaceCheck(dragonTigerBalanceCompute, resultArray[0] - resultArray[4], ChartThreeTypeKey.DragonTiger, lastDistribution);
		map.put(key, resultDistribution);
		return map;
	}
	
	
	



}
