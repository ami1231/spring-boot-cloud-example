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

public class Xx5SumDistributionTest extends AbstractStatisticsTest {

	@Autowired
	@Qualifier("xx5SumDistributionStatistics")
	private StatisticsComponent statistics;

	ChartStaisticsVo vo = new ChartStaisticsVo();

	String distributionKey = Xx5ChartType.SumDistribution.getKey();

	// 期望結果
	Integer[] expectDistribution = new Integer[] { -561, -230, -396, -63, -76, -84, -21, -49, -6, -70, -3, -15, -30, -24, -2, -1, -11, 1, -9, -8, -25, -18, -28, -22, -46, -206, -56, -265, -5, -234, -89};

	// 舊資料
	Integer[] distribution = new Integer[] { -560, -229, -395, -62, -75, -83, -20, -48, -5, -69, -2, -14, -29, -23, -1, 1, -10, -22, -8, -7, -24, -17, -27, -21, -45, -205, -55, -264, -4, -233, -88};

	@Before
	public void readyVo() {
		vo.setAwardResult("10,05,06,08,03");
		ChartResult lastResult = new ChartResult();
		lastResult.put(distributionKey, distribution);
		vo.setLastResult(lastResult);
	}

	@Test
	public void testStaistics() {
		Map<String, Object> nowResult = statistics.chartRecord(vo);
		Integer[] distribution = (Integer[]) nowResult.get(distributionKey);
		Assert.assertArrayEquals(expectDistribution, distribution);

	}
}
