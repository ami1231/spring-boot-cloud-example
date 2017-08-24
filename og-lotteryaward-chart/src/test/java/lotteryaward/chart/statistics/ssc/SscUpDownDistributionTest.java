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

public class SscUpDownDistributionTest extends  AbstractStatisticsTest{
	
	@Autowired
	@Qualifier("sscUpDownDistributionStatistics")
	private StatisticsComponent statistics;

	String distributionKey = SscChartType.UpDownDisbution.getKey();

	//預期結果 升平降
	List<Integer[]> expectDistribution = Arrays.asList(new Integer[][]{{-2,-2,1},{-2,-2,1},{1,-1,-2},{1,-4,-1},{-1,1,-2}});


	@Override
	@Before
	public void readyVo() {
		//降 降 升 升 平
		vo.setAwardResult("0,1,7,8,9");
		vo.setLastAwardResult("1,2,3,6,9");
		ChartResult lastResult = new ChartResult();
		//測試資料
		List<Integer[]> lastDistribution = Arrays.asList(new Integer[][]{{-1,-1,1},{-1,-1,1},{-3,1,-1},{-1,-3,1},{1,-1,-1}});
		lastResult.put(distributionKey, lastDistribution);
		vo.setLastResult(lastResult);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Test
	public void testStaistics() {
		Map<String, Object> map =  statistics.chartRecord(vo);
		
		List<Integer[]>  result = (List<Integer[]> )map.get(distributionKey);
		
		for(int i =0 ; i<result.size();i++){
			Assert.assertArrayEquals(result.get(i), expectDistribution.get(i));
		}
		
	}

}

