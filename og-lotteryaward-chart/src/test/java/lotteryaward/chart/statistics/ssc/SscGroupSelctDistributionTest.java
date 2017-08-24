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

public class SscGroupSelctDistributionTest  extends  AbstractStatisticsTest{
	
	@Autowired
	@Qualifier("sscGroupSelectTypeDistributionStatistics")
	private StatisticsComponent statistics;

	String distributionKey = SscChartType.GroupSelectType.getKey();
	//组三组六豹子
	//預期結果
	List<Integer[]> expectDistribution = Arrays.asList(new Integer[][]{{-2,1,-1},{1,-9,-1},{-2,-1,1}});


	@Override
	@Before
	public void readyVo() {
		
		vo.setAwardResult("1,2,9,9,9"); //組六  組三 豹子
		ChartResult lastResult = new ChartResult();
		//測試資料
		List<Integer[]> lastDistribution = Arrays.asList(new Integer[][]{{-1,-1,1},{-1,-8,1},{-1,1,-7}});
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

