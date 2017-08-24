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

public class Xx5NowTimeDistributionTest extends AbstractStatisticsTest {

	@Autowired
	@Qualifier("xx5NowTimeDistributionStatistic")
	private StatisticsComponent statistics;

	private String numberCombinationKey = Xx5ChartType.NumberCombination.getKey();
	private String bigSmallKey = Xx5ChartType.BigSmall.getKey();
	private String singleDoubleKey = Xx5ChartType.SingleDouble.getKey();
	private String sumKey = Xx5ChartType.Sum.getKey();
	private String dragonTigerKey = Xx5ChartType.DragonTiger.getKey();
    private String pairNumKey = Xx5ChartType.PairNum.getKey();
    
	// 預期結果
	Integer[] expectSumBigSmallSingleDouble = new Integer[] {25, -1, 1};
	Integer expectDragonTiger = 1;
	Integer[] expectOneToFiveBigSmall = new Integer[] { 0,-1,-1,1,-1};
	Integer[] expectOneToFiveSingleDouble = new Integer[] { 0,1,-1,1,-1 };
	// 0:雜六 1:半順 2:順子
	Integer[] expectFrontMiddleBehindThree = new Integer[] { 0,0,0 };
	Integer[] expectPairNum = new Integer[]{2,1,1,1,2};
	
	//舊資料
	Integer[] lastPairNum = new Integer[]{1,1,1,1,1};
	@Override
	@Before
	public void readyVo() {
		vo.setAwardResult("11,1,4,7,2");
		vo.setLastAwardResult("11,2,7,4,2");
		ChartResult lastResult = new ChartResult();
		lastResult.put(pairNumKey, lastPairNum);
		vo.setLastResult(lastResult);
	}

	@Override
	@Test
	public void testStaistics() {

		Map<String, Object> map = statistics.chartRecord(vo);
		
		Integer[] sumBigSmallSingleDouble = (Integer[]) map.get(sumKey);
		Assert.assertArrayEquals(sumBigSmallSingleDouble, expectSumBigSmallSingleDouble);

		Integer dragonTiger = (Integer) map.get(dragonTigerKey);
		Assert.assertEquals(dragonTiger, expectDragonTiger);

		Integer[] oneToFiveBigSmall = (Integer[]) map.get(bigSmallKey);
		Assert.assertArrayEquals(oneToFiveBigSmall, expectOneToFiveBigSmall);

		Integer[] oneToFiveSingleDouble = (Integer[]) map.get(singleDoubleKey);
		Assert.assertArrayEquals(oneToFiveSingleDouble, expectOneToFiveSingleDouble);

		Integer[] frontMiddleBehindThree = (Integer[]) map.get(numberCombinationKey);
		Assert.assertArrayEquals(frontMiddleBehindThree, expectFrontMiddleBehindThree);
		
		Integer[]  pairNum = (Integer[])map.get(pairNumKey);
		Assert.assertArrayEquals(pairNum, expectPairNum);

	}

}