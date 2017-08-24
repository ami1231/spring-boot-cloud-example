package lotteryaward.chart.statistics.ssc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.xx5.common.Xx5HotColdTemplateStatistics;

public class SscHotColdStatistic extends Xx5HotColdTemplateStatistics {
	/**
	 * SSC 冷熱分析
	 * 
	 */

	@Autowired
	@Qualifier("hotColdCompute")
	private ChartCompute<Integer, Integer> hotColdCompute;

	private String key = SscChartType.HotColdStatistic.getKey();

	private String[] keys = new String[]{"first","second","third","fourth","fifth"};
	
	
	private int maxBallNum = 10; 
	
	private int minBallNum =0;
	
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

