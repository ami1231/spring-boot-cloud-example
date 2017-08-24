package lotteryaward.chart.statistics.xx5;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lotteryaward.chart.statistics.AbstractStatisticsTest;
import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.vo.ChartResult;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

public class Xx5NumberDistributionTest extends AbstractStatisticsTest {

	@Autowired
	@Qualifier("xx5NumberDistributionStatistics")
	private StatisticsComponent statistics;

	ChartStaisticsVo vo = new ChartStaisticsVo();
	
	String distributionKey = Xx5ChartType.NumberDistribution.getKey();

	// 期望結果
	int[] expectDistribution = new int[] { 1, 1, -1, -1, -1, -1, 1, 1, 1, -6, -11 };
	// 舊資料
	int[] distribution = new int[] { -1, -2, 1, 1, 1, 1, -1, 1, -1, -5, -10 };

	@Before
	public void readyVo() {
		vo.setAwardResult("1,2,7,8,9");
		ChartResult lastResult = new ChartResult();
		lastResult.put(distributionKey, distribution);
		vo.setLastResult(lastResult);
	}

	@Test
	public void testStaistics() {
		Map<String, Object> nowResult = statistics.chartRecord(vo);
		int [] distribution = (int[]) nowResult.get(distributionKey);
		Assert.assertArrayEquals(expectDistribution, distribution);

	}
}
