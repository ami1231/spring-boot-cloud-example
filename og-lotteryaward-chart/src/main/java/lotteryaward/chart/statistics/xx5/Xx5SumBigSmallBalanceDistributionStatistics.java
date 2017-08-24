package lotteryaward.chart.statistics.xx5;

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
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

@Component
public class Xx5SumBigSmallBalanceDistributionStatistics implements StatisticsComponent {

	/**
	 * Xx5   總和分佈 大小和 
	 * 
	 * 
	 */
	
	@Autowired
	@Qualifier("bigSmallBalanceCompute")
	private ChartCompute<Integer,Integer> bigSmallBalanceCompute;
	
	private String key = Xx5ChartType.SumBigSmall.getKey();	
	
	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		Map<String ,Object> map = new HashMap<>();
		Integer [] value = new Integer[]{30,30};
		bigSmallBalanceCompute = ChartUtil.initChartComputeParam(bigSmallBalanceCompute, value);
		Integer sumValue = ChartUtil.getSumResultNumber(vo.getAwardResult());
		Integer [] lastDistribution= (Integer[]) getMapValue(vo.getLastResult(), key, new Integer[0].getClass());
		Integer [] nowDistribution = SscStatisticsUtil.threeFaceCheck(bigSmallBalanceCompute, sumValue, ChartThreeTypeKey.BigSmall, lastDistribution);
		map.put(key, nowDistribution);
		return map;
	}

}
