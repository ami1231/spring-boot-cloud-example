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

public class Xx5DragonTigerTest extends AbstractStatisticsTest {

	@Autowired
	@Qualifier("xx5DragonTirgerDistributionStatistics")
	private StatisticsComponent statistics;
	
	ChartStaisticsVo vo = new ChartStaisticsVo();

	String distributionKey = Xx5ChartType.DragonTigerDistribution.getKey();
	//期望結果
	Integer[] expectDistribution = new Integer[]{-1,1};	
	
	@Before
	public void readyVo(){
		vo.setAwardResult("1,2,3,4,5");
		ChartResult lastResult = new ChartResult();
		lastResult.put(distributionKey, new Integer[]{1,-28});
		vo.setLastResult(lastResult);
	}
		
	@Test
	public void testStaistics() {
		Map<String,Object> nowResult = statistics.chartRecord(vo);
		Integer[] distribution =  (Integer[]) nowResult.get(distributionKey);
		Assert.assertArrayEquals(expectDistribution, distribution);

	}
}
