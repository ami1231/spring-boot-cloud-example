package lotteryaward.chart.statistics.xx5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lotteryaward.chart.statistics.AbstractStatisticsTest;
import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.vo.ChartResult;

public class Xx5HistoryBallBigSmallTest extends AbstractStatisticsTest {

	@Autowired
	@Qualifier("xx5HistoryBallBigSmallStatistics")
	private StatisticsComponent statistics;

	private String distributionKey = Xx5ChartType.HistoryBallBigSmall.getKey();
	// 期望結果
	List<int[]> expectDistribution = Arrays.asList(new int[][]{
		{23,26,12},{24,30,11},{24,29,8},{25,25,10},{24,27,6}});

	// 舊資料
	List<int[]> distribution = Arrays.asList(new int[][] {
		{23,26,11},{23,30,11},{23,29,8},{24,25,10},{24,26,6}});

	@Before
	public void readyVo() {
		vo.setAwardResult("11,9,10,8,3");
		ChartResult lastResult = new ChartResult();
		lastResult.put(distributionKey, distribution);
		vo.setLastHistoryResult(lastResult);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testStaistics() {
		Map<String,Object> nowResult = statistics.chartRecord(vo);
		List<int[]> distribution =  (List<int[]>) nowResult.get(distributionKey);
		for(int i =0;i<distribution.size();i++){
			Assert.assertArrayEquals(expectDistribution.get(i), distribution.get(i));
		}

	}

}
