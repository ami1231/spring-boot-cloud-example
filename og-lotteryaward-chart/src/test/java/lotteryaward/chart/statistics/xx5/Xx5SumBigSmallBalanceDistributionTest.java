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

public class Xx5SumBigSmallBalanceDistributionTest extends AbstractStatisticsTest {

	@Autowired
	@Qualifier("xx5SumBigSmallBalanceDistributionStatistics")
	private StatisticsComponent statistics;

	ChartStaisticsVo vo = new ChartStaisticsVo();

	String distributionKey = Xx5ChartType.SumBigSmall.getKey();
	
	//期望結果
	Integer[] expectDistribution = new Integer[]{1,-6,-1};	
	
	//舊資料
	Integer[] distribution = new Integer[]{-1,-5,1};
	
	@Before
	public void readyVo(){
		vo.setAwardResult("1,4,7,10,11");
		ChartResult lastResult = new ChartResult();
		lastResult.put(distributionKey, distribution);
		vo.setLastResult(lastResult);
	}
	
	
	@Test
	public void testStaistics() {
		Map<String,Object> nowResult = statistics.chartRecord(vo);
		Integer[] distribution =  (Integer[]) nowResult.get(distributionKey);
		Assert.assertArrayEquals(expectDistribution, distribution);
		
	}
}
