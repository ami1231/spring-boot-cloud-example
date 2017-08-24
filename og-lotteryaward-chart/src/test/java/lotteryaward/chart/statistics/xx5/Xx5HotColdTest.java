package lotteryaward.chart.statistics.xx5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lotteryaward.chart.statistics.AbstractStatisticsTest;
import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

public class Xx5HotColdTest extends AbstractStatisticsTest {

	@Autowired
	@Qualifier("xx5HotColdStatistic")
	private StatisticsComponent statistics;

	ChartStaisticsVo vo = new ChartStaisticsVo();

	String distributionKey = Xx5ChartType.HotColdStatistic.getKey();

	String[] keys = new String[] { "first", "second", "third", "fourth", "fifth" };

	// 期望結果
	Map<String, Object> first = new HashMap<>();
	List<Map<String, Object>> hot = new ArrayList<>();

	String expectDistribution = "{third=[[], [{ballNum=4, count=3}, {ballNum=5, count=3}, {ballNum=7, count=2}, {ballNum=8, count=3}, {ballNum=9, count=3}], [{ballNum=1, count=1}, {ballNum=2, count=1}, {ballNum=3, count=1}, {ballNum=6, count=1}, {ballNum=10, count=1}, {ballNum=11, count=1}]], fifth=[[{ballNum=4, count=4}, {ballNum=7, count=5}], [{ballNum=10, count=3}, {ballNum=11, count=2}], [{ballNum=1, count=1}, {ballNum=2, count=1}, {ballNum=3, count=1}, {ballNum=5, count=1}, {ballNum=6, count=1}, {ballNum=8, count=0}, {ballNum=9, count=1}]], fourth=[[{ballNum=6, count=4}], [{ballNum=1, count=2}, {ballNum=3, count=2}, {ballNum=4, count=2}, {ballNum=5, count=2}, {ballNum=7, count=2}, {ballNum=9, count=2}, {ballNum=11, count=3}], [{ballNum=2, count=0}, {ballNum=8, count=1}, {ballNum=10, count=0}]], first=[[{ballNum=5, count=5}], [{ballNum=1, count=2}, {ballNum=3, count=2}, {ballNum=6, count=3}, {ballNum=9, count=2}, {ballNum=11, count=2}], [{ballNum=2, count=1}, {ballNum=4, count=1}, {ballNum=7, count=1}, {ballNum=8, count=1}, {ballNum=10, count=0}]], second=[[{ballNum=5, count=4}, {ballNum=9, count=4}], [{ballNum=1, count=2}, {ballNum=3, count=2}, {ballNum=4, count=2}, {ballNum=10, count=2}], [{ballNum=2, count=1}, {ballNum=6, count=0}, {ballNum=7, count=1}, {ballNum=8, count=1}, {ballNum=11, count=1}]]}";

	// Integer[] expectDistribution = new Integer[] { -561, -230, -396, -63,
	// -76, -84, -21, -49, -6, -70, -3, -15, -30,
	// -24, -2, -1, -11, 1, -9, -8, -25, -18, -28, -22, -46, -206, -56, -265,
	// -5, -234, -89 };

	// 舊資料
	List<String> twentyResult = Arrays.asList("6,9,10,11,1", "5,1,4,7,2", "5,1,7,11,3", "5,3,11,6,4", "5,3,9,7,4",
			"1,11,5,9,4", "5,7,8,11,4", "3,9,8,6,5", "1,10,9,4,6", "6,5,4,1,7", "9,10,5,4,7", "11,9,2,5,7", "4,5,9,6,7",
			"8,5,1,9,7", "6,2,4,5,9", "11,4,5,3,10", "2,4,6,3,10", "3,9,7,8,10", "9,8,3,1,11", "7,5,8,6,11");

	@Before
	public void readyVo() {
		vo.setTwentyResult(twentyResult);
	}

	@Test
	public void testStaistics() {
//		Gson gson = new Gson();
//		Map<String, Object> nowResult = statistics.chartRecord(vo);
//		String distribution = gson.toJson(nowResult.get(distributionKey));
//		Assert.assertEquals(distribution, expectDistribution);
	}
}
