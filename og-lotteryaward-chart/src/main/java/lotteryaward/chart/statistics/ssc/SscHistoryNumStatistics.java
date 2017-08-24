package lotteryaward.chart.statistics.ssc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.common.ChartThreeTypeKey;
import lotteryaward.chart.statistics.common.ChartTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.ssc.util.SscStatisticsUtil;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.vo.ChartResult;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

@Component
public class SscHistoryNumStatistics implements StatisticsComponent{
	
	@Autowired
	@Qualifier("singleDoubleCompute")
	private ChartCompute<Integer,Integer> singleDoubleCompute;
	
	@Autowired
	@Qualifier("dragonTigerBalanceCompute")
	private ChartCompute<Integer,Integer> dragonTigerBalanceCompute;
	
	@Autowired
	@Qualifier("bigSmallCompute")
	private ChartCompute<Integer,Integer> bigSmallCompute;
	
	
	private String numKey = SscChartType.HistoryNum.getKey();
	
	private String bigSmallKey = SscChartType.HistoryNumBigSmall.getKey();
	
	private String singleDoubleKey = SscChartType.HistoryNumSingleDouble.getKey();
	
	private String dragonTigerKey = SscChartType.HistoryNumDragonTiger.getKey();
	
	private Integer ballNumLength = 10;
	
	private Integer twoFaceLength = 2;
	
	private Integer threeFaceLength = 3;

	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		ChartResult chartResult = vo.getLastHistoryResult();
		Map<String, Object> map = new HashMap<>();
		Integer[] resultArray =  ChartUtil.getSplitNumberIntegerArray(vo.getAwardResult());
		
		//歷史號碼
		map.put(numKey, SscStatisticsUtil.historyNumStatistics(chartResult, resultArray, numKey, ballNumLength));	
		//歷史大小
		bigSmallCompute = ChartUtil.initChartComputeParam(bigSmallCompute,5);
		map.put(bigSmallKey, SscStatisticsUtil.historyTwoFaceStatistics(chartResult, resultArray, bigSmallCompute
				,ChartTypeKey.BigSmall, bigSmallKey, twoFaceLength));
		
		//歷史單雙
		map.put(singleDoubleKey, SscStatisticsUtil.historyTwoFaceStatistics(chartResult, resultArray, singleDoubleCompute
				,ChartTypeKey.SingleDouble, singleDoubleKey, twoFaceLength));
		
		//歷史龍虎和
		map.put(dragonTigerKey, SscStatisticsUtil.historyThreeFaceStatistics(chartResult, resultArray[0]- resultArray[4], dragonTigerBalanceCompute
				, ChartThreeTypeKey.DragonTiger, dragonTigerKey, threeFaceLength));
		
		
		return map;
	}
	
	

}
