package lotteryaward.chart.statistics.xx5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.xx5.common.Xx5HotColdTemplateStatistics;

@Component
public class Xx5HotColdStatistic extends Xx5HotColdTemplateStatistics {
	/**
	 * XX5冷熱分析
	 * 
	 */

	@Autowired
	@Qualifier("hotColdCompute")
	private ChartCompute<Integer, Integer> hotColdCompute;

	private String key = Xx5ChartType.HotColdStatistic.getKey();

	private String[] keys = new String[]{"first","second","third","fourth","fifth"};
	
	
	private int maxBallNum = 11; 
	
	private int minBallNum =1;
	
	@Override
	protected ChartCompute<Integer, Integer> getChartCompute() {
		return hotColdCompute;
	}

	@Override
	protected String getKey() {
		return key;
	}

	@Override
	protected String[] getKeys() {
		return keys;
	}

	@Override
	protected int getMaxBallCount() {
		return maxBallNum;
	}

	@Override
	protected int getMinBallNum() {
		return minBallNum;
	}


}
