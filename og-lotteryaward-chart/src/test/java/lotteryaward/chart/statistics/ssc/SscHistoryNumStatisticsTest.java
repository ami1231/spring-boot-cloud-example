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

/**
 * 歷史號碼統計
 * @author aronlin
 *
 */
public class SscHistoryNumStatisticsTest  extends  AbstractStatisticsTest{
	
	@Autowired
	@Qualifier("sscHistoryNumStatistics")
	private StatisticsComponent statistics;
	
	private String numKey = SscChartType.HistoryNum.getKey();
	
	private String bigSmallKey = SscChartType.HistoryNumBigSmall.getKey();
	
	private String singleDoubleKey = SscChartType.HistoryNumSingleDouble.getKey();
	
	private String dragonTigerKey = SscChartType.HistoryNumDragonTiger.getKey();
	
	//預期結果
	Integer[] expectNum = new Integer[]{1,1,3,2,6,7,9,6,10,2};
	Integer[] expectBigSmall =  new Integer[]{4,2};
	Integer[] expectSingleDouble = new Integer[]{4,2};
	Integer[] expectDragonTiger = new Integer[]{1,1,3};

	@Override
	@Before
	public void readyVo() {
		vo.setAwardResult("1,3,6,8,9");
		ChartResult lastHistoryResult = new ChartResult();
		//測試資料
		Integer[] numData = new Integer[]{1,0,3,1,6,7,8,6,9,1};
		lastHistoryResult.put(numKey, numData);
		
		Integer[] bigSmallData = new Integer[]{1,0};
		lastHistoryResult.put(bigSmallKey, bigSmallData);
		
		Integer[] singleDoubleData = new Integer[]{1,0};
		lastHistoryResult.put(singleDoubleKey, singleDoubleData);
		
		Integer[] dragonTigerData  = new Integer[]{1,0,3};
		lastHistoryResult.put(dragonTigerKey, dragonTigerData);
		vo.setLastHistoryResult(lastHistoryResult);;
		
	}

	@Override
	@Test
	public void testStaistics() {
		
		Map<String, Object> map = statistics.chartRecord(vo);
		
		Integer[]  num = (Integer[])map.get(numKey);
		Assert.assertArrayEquals(num, expectNum);
	
		Integer[]  bigSmall = (Integer[])map.get(bigSmallKey);
		Assert.assertArrayEquals(bigSmall, expectBigSmall);

		Integer[]  singleDouble = (Integer[])map.get(singleDoubleKey);
		Assert.assertArrayEquals(singleDouble, expectSingleDouble);
	
		
		Integer[]  dragonTiger = (Integer[])map.get(dragonTigerKey);
		Assert.assertArrayEquals(dragonTiger, expectDragonTiger);
	
		
	}

}
