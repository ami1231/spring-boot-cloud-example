package lotteryaward.chart.statistics.ssc;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lotteryaward.chart.statistics.AbstractStatisticsTest;
import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.vo.ChartResult;

public class SscComplexStatisticsTest  extends AbstractStatisticsTest {

	@Autowired
	@Qualifier("sscComplexStatistics")
	private StatisticsComponent statistics;
	
	String sumBigSmallSingleDoubleKey = SscChartType.SumBigSmallSingleDouble.getKey();
	String dragonTigerKey = SscChartType.DragonTiger.getKey();
	String oneToFiveBigSmallKey = SscChartType.OneToFiveBigSmall.getKey();
	String oneToFiveSingleDoubleKey = SscChartType.OneToFiveSingleDouble.getKey();
	String frontMiddleBehindThreeKey = SscChartType.FrontMiddleBehindThree.getKey();
	String pairNumKey = SscChartType.PairNum.getKey();
	
	//預期結果
	Integer[] expectSumBigSmallSingleDouble = new Integer[]{11,-1,1};
	Integer expectDragonTiger = 1;
	Integer[] expectOneToFiveBigSmall = new Integer[]{-1,-1,-1,-1,-1};
	Integer[] expectOneToFiveSingleDouble = new Integer[]{-1,-1,-1,1,-1};
	// 0:雜六 1:半順  2:順子 3:對子 4:豹子
	Integer[] expectFrontMiddleBehindThree = new Integer[]{3,1,1};
	Integer[] expectPairNum = new Integer[]{2,1,1,1,3};
	
	
	@Override
	@Before
	public void readyVo() {
		
	
		vo.setAwardResult    ("4,0,4,3,0");
		vo.setLastAwardResult("4,1,3,1,0");
		ChartResult lastResult = new ChartResult();
		//上次對子號結果
		Integer[] pairNum = new Integer[]{1,1,1,1,2};
		lastResult.put(pairNumKey, pairNum);
		vo.setLastResult(lastResult);
	}

	@Override
	@Test
	public void testStaistics() {
		
		Map<String, Object> map =  statistics.chartRecord(vo);
		Integer[]  sumBigSmallSingleDouble = (Integer[])map.get(sumBigSmallSingleDoubleKey);
		Assert.assertArrayEquals(sumBigSmallSingleDouble, expectSumBigSmallSingleDouble);
		
		Integer dragonTiger = (Integer)map.get(dragonTigerKey);
		Assert.assertEquals(dragonTiger, expectDragonTiger);
		
		Integer[]  oneToFiveBigSmall = (Integer[])map.get(oneToFiveBigSmallKey);
		Assert.assertArrayEquals(oneToFiveBigSmall, expectOneToFiveBigSmall);
		
		Integer[] oneToFiveSingleDouble = (Integer[])map.get(oneToFiveSingleDoubleKey);
		Assert.assertArrayEquals(oneToFiveSingleDouble, expectOneToFiveSingleDouble);
		
		Integer[]  frontMiddleBehindThree = (Integer[])map.get(frontMiddleBehindThreeKey);
		Assert.assertArrayEquals(frontMiddleBehindThree, expectFrontMiddleBehindThree);
		
		Integer[]  pairNum = (Integer[])map.get(pairNumKey);
		Assert.assertArrayEquals(pairNum, expectPairNum);

	}

}
