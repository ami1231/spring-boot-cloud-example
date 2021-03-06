package lotteryaward.chart.statistics.ssc;

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

public class SscHistoryBallBigSmallStatisticsTest extends  AbstractStatisticsTest{
	
	@Autowired
	@Qualifier("sscHistoryBallBigSmallStatistics")
	private StatisticsComponent statistics;


	private String distributionKey = SscChartType.HistroyBallBigSmall.getKey();
	  // 期望結果
	  List<int[]> expectDistribution = Arrays.asList(new int[][]{
	    {23,27},{24,30},{23,30},{25,25},{24,27}});

	  // 舊資料
	  List<int[]> distribution = Arrays.asList(new int[][] {
	    {23,26},{23,30},{23,29},{24,25},{24,26}});
	  // 1~5 顆 大小
	  @Before
	  public void readyVo() {
	    vo.setAwardResult("1,9,2,8,3");
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
