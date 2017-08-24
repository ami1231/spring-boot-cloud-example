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
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

public class Xx5TodayNumberStatisticsTest extends AbstractStatisticsTest {

	@Autowired
	@Qualifier("xx5TodayNumberStatistics")
	private StatisticsComponent statistics;

	ChartStaisticsVo vo = new ChartStaisticsVo();

	String distributionKey = Xx5ChartType.TodayNumberStatistics.getKey();

	// 期望結果
	List<List<int[]>> expectDistribution = Arrays.asList(
			Arrays.asList(new int[][] { { 2, 12 }, { 1, 2 }, { 6, 4 }, { 4, 11 }, { 5, 8 } }),
			Arrays.asList(new int[][] { { 3, 11 }, { 1, 2 }, { 6, 4 }, { 4, 11 }, { 5, 8 } }),
			Arrays.asList(new int[][] { { 2, 12 }, { 1, 2 }, { 6, 4 }, { 4, 11 }, { 5, 8 } }),
			Arrays.asList(new int[][] { { 2, 12 }, { 2, 1 }, { 6, 4 }, { 4, 11 }, { 5, 8 } }),
			Arrays.asList(new int[][] { { 2, 12 }, { 1, 2 }, { 6, 4 }, { 4, 11 }, { 5, 8 } }),
			Arrays.asList(new int[][] { { 2, 12 }, { 1, 2 }, { 7, 3 }, { 4, 11 }, { 5, 8 } }),
			Arrays.asList(new int[][] { { 2, 12 }, { 1, 2 }, { 6, 4 }, { 4, 11 }, { 5, 8 } }),
			Arrays.asList(new int[][] { { 2, 12 }, { 1, 2 }, { 6, 4 }, { 5, 10 }, { 5, 8 } }),
			Arrays.asList(new int[][] { { 2, 12 }, { 1, 2 }, { 6, 4 }, { 4, 11 }, { 6, 7 } }),
			Arrays.asList(new int[][] { { 2, 12 }, { 1, 2 }, { 6, 4 }, { 4, 11 }, { 5, 8 } }),
			Arrays.asList(new int[][] { { 2, 12 }, { 1, 2 }, { 6, 4 }, { 4, 11 }, { 5, 8 } }));

	// 舊資料
	List<List<int[]>> distribution = Arrays.asList(
			Arrays.asList(new int[][] { { 2, 11 }, { 1, 1 }, { 6, 3 }, { 4, 10 }, { 5, 7 } }),
			Arrays.asList(new int[][] { { 2, 11 }, { 1, 1 }, { 6, 3 }, { 4, 10 }, { 5, 7 } }),
			Arrays.asList(new int[][] { { 2, 11 }, { 1, 1 }, { 6, 3 }, { 4, 10 }, { 5, 7 } }),
			Arrays.asList(new int[][] { { 2, 11 }, { 1, 1 }, { 6, 3 }, { 4, 10 }, { 5, 7 } }),
			Arrays.asList(new int[][] { { 2, 11 }, { 1, 1 }, { 6, 3 }, { 4, 10 }, { 5, 7 } }),
			Arrays.asList(new int[][] { { 2, 11 }, { 1, 1 }, { 6, 3 }, { 4, 10 }, { 5, 7 } }),
			Arrays.asList(new int[][] { { 2, 11 }, { 1, 1 }, { 6, 3 }, { 4, 10 }, { 5, 7 } }),
			Arrays.asList(new int[][] { { 2, 11 }, { 1, 1 }, { 6, 3 }, { 4, 10 }, { 5, 7 } }),
			Arrays.asList(new int[][] { { 2, 11 }, { 1, 1 }, { 6, 3 }, { 4, 10 }, { 5, 7 } }),
			Arrays.asList(new int[][] { { 2, 11 }, { 1, 1 }, { 6, 3 }, { 4, 10 }, { 5, 7 } }),
			Arrays.asList(new int[][] { { 2, 11 }, { 1, 1 }, { 6, 3 }, { 4, 10 }, { 5, 7 } }));

	@Before
	public void readyVo() {
		vo.setAwardResult("2,4,6,8,9");
		ChartResult lastResult = new ChartResult();
		lastResult.put(distributionKey, distribution);
		vo.setLastHistoryResult(lastResult);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testStaistics() {
		Map<String, Object> nowResult = statistics.chartRecord(vo);
		List<List<int[]>> distribution = (List<List<int[]>>) nowResult.get(distributionKey);
		for (int i = 0; i < distribution.size(); i++) {
			for(int j= 0; j<distribution.get(i).size();j++){
				Assert.assertArrayEquals(expectDistribution.get(i).get(j), distribution.get(i).get(j));
			}
		}
	}
}
