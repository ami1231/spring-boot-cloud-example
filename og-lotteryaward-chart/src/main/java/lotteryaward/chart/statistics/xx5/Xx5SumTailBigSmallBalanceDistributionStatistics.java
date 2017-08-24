package lotteryaward.chart.statistics.xx5;

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

@Component
public class Xx5SumTailBigSmallBalanceDistributionStatistics implements StatisticsComponent {

	/**
	 * Xx5   總和分佈 尾大尾小
	 * 
	 * 
	 */
	
	@Autowired
	@Qualifier("bigSmallCompute")
	private ChartCompute<Integer,Integer> bigSmallCompute;
	
	private String key = Xx5ChartType.TailBigSmall.getKey();	
	
	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		Map<String ,Object> map = new HashMap<>();
		Integer value = ChartUtil.getSumResultNumber(vo.getAwardResult())%10;
		Integer [] lastDistribution= (Integer[]) getMapValue(vo.getLastResult(), key, new Integer[0].getClass());
		Integer [] nowDistribution = K3StatisticsUtil.doSingelDoubleOrBigSmall(bigSmallCompute, value, ChartTypeKey.BigSmall, lastDistribution);
		map.put(key, nowDistribution);
		return map;
	}

}
