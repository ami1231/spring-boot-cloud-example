package lotteryaward.chart.statistics.ssc;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lotteryaward.chart.statistics.AbstractStatisticsTest;
import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.vo.ChartResult;

public class SscHistorySumSingleDoubleTest extends AbstractStatisticsTest {

	@Autowired
	@Qualifier("sscHistorySumSingleDoubleStatistics")
	private StatisticsComponent statistics;

	private String distributionKey = SscChartType.HistorySumSingleDouble.getKey();
	// 期望結果
	int[] expectDistribution = {23,26};

	// 舊資料
	int[] distribution ={23,25};

	@Before
	public void readyVo() {
		vo.setAwardResult("1,8,9,5,1");
		ChartResult lastResult = new ChartResult();
		lastResult.put(distributionKey, distribution);
		vo.setLastHistoryResult(lastResult);
	}

	@Test
	public void testStaistics() {
		Map<String,Object> nowResult = statistics.chartRecord(vo);
		int[] distribution =  (int[]) nowResult.get(distributionKey);
		Assert.assertArrayEquals(expectDistribution, distribution);
	}
}
