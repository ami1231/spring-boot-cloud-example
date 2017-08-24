package lotteryaward.chart.statistics.ssc;

import java.util.ArrayList;
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

public class SscDragonTigerDistributionTest  extends  AbstractStatisticsTest{
	
	@Autowired
	@Qualifier("sscDragonTigerDistributionStatistics")
	private StatisticsComponent statistics;
	
	String distributionKey = SscChartType.DragonTigerDisbution.getKey();

	//預期結果 升平降

	List<Integer[]> expectDistribution = Arrays.asList(new Integer[][]{{1,-2,-1},{-2,1,-1},{-2,-2,1}});
	
	List<ChartStaisticsVo> testData = new ArrayList<>();


	@Override
	@Before
	public void readyVo() {
		//
		
		ChartStaisticsVo vo = new ChartStaisticsVo();
		vo.setAwardResult("9,1,7,8,0");
		ChartResult lastResult = new ChartResult();
		//測試資料 龍
		Integer[] lastDistribution = new Integer[]{-1,-1,1};
		lastResult.put(distributionKey, lastDistribution);
		vo.setLastResult(lastResult);
		testData.add(vo);
		
		vo = new ChartStaisticsVo();
		vo.setAwardResult("0,1,7,8,9");
		lastResult = new ChartResult();
		//測試資料 虎
		lastDistribution = new Integer[]{-1,-1,1};
		lastResult.put(distributionKey, lastDistribution);
		vo.setLastResult(lastResult);
		testData.add(vo);
		
		vo = new ChartStaisticsVo();
		vo.setAwardResult("0,1,7,8,0");
		lastResult = new ChartResult();
		//測試資料 和
		lastDistribution = new Integer[]{-1,-1,1};
		lastResult.put(distributionKey, lastDistribution);
		vo.setLastResult(lastResult);
		testData.add(vo);
		
		
	}

	@Override
	@Test
	public void testStaistics() {
		
		for(int i =0 ; i<testData.size();i++){
			
			Map<String, Object> map =  statistics.chartRecord(testData.get(i));
			Integer[]  result = (Integer[])map.get(distributionKey);
			Assert.assertArrayEquals(result, expectDistribution.get(i));
		}
		
		
	}


}
