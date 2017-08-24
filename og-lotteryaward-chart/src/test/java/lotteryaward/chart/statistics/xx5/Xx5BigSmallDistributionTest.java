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

public class Xx5BigSmallDistributionTest extends AbstractStatisticsTest {

	@Autowired
	@Qualifier("xx5BigSmallBalanceDistributionStatistics")
	private StatisticsComponent statistics;

	ChartStaisticsVo vo = new ChartStaisticsVo();

	String distributionKey = Xx5ChartType.BigSmallDistribution.getKey();
	
	//期望結果
	List<Integer[]> expectDistribution = Arrays.asList(
			new Integer[][]{{-9,1},{-1,1},{-1,1},{-1,1},{-1,1}});	
	
	//舊資料
	List<Integer[]> distribution = Arrays.asList(
			new Integer[][]{{-8,1},{1,-5},{1,-8},{1,-9},{1,-8}});	
	
	@Before
	public void readyVo(){
		vo.setAwardResult("1,2,3,4,5");
		ChartResult lastResult = new ChartResult();
		lastResult.put(distributionKey, distribution);
		vo.setLastResult(lastResult);
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testStaistics() {
		Map<String,Object> nowResult = statistics.chartRecord(vo);
		List<Integer[]> distribution =  (List<Integer[]>) nowResult.get(distributionKey);
		for(int i =0;i<distribution.size();i++){
			Assert.assertArrayEquals(expectDistribution.get(i), distribution.get(i));
		}

	}
}
