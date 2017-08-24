package lotteryaward.chart.statistics.ssc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.ssc.util.SscStatisticsUtil;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;


/**
 * 綜合分析
 * @author aronlin
 *
 */
@Component
public class SscComplexStatistics  implements StatisticsComponent{
	
	@Autowired
	@Qualifier("singleDoubleCompute")
	private ChartCompute<Integer,Integer> singleDoubleCompute;
	
	@Autowired
	@Qualifier("dragonTigerBalanceCompute")
	private ChartCompute<Integer,Integer> dragonTigerBalanceCompute;
	
	@Autowired
	@Qualifier("bigSmallCompute")
	private ChartCompute<Integer,Integer> bigSmallCompute;
	
	@Autowired
	@Qualifier("numberCombinationCompute")
	private ChartCompute<Integer[],Integer> numberCombinationCompute;
	
	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		
		Map<String, Object> map = new HashMap<>();
		Integer[] resultArray =  ChartUtil.getSplitNumberIntegerArray(vo.getAwardResult());
		
		//計算總和大小單雙
		Integer sumValue = ChartUtil.getSumResultNumber(vo.getAwardResult());
		bigSmallCompute = ChartUtil.initChartComputeParam(bigSmallCompute,23);
		Integer SumBigSmall = bigSmallCompute.compute(sumValue);
		Integer SumSingleDouble = singleDoubleCompute.compute(sumValue);
		Integer[] SumBigSmallSingleDouble = new Integer[] {sumValue,SumBigSmall,SumSingleDouble};
		map.put(SscChartType.SumBigSmallSingleDouble.getKey(), SumBigSmallSingleDouble);
		
		//計算龍虎
		Integer dragonTiger = dragonTigerBalanceCompute.compute(resultArray[0]-resultArray[4]);
		map.put(SscChartType.DragonTiger.getKey(), dragonTiger);
		
		//計算1-5大小 1-5球单双
		bigSmallCompute = ChartUtil.initChartComputeParam(bigSmallCompute,5);
		
		Integer[] oneToFiveBigSmall = new Integer[5];
		Integer[] oneToFiveSingleDouble = new Integer[5];
		for(int i = 0 ; i < resultArray.length; i++){
			oneToFiveBigSmall[i] =bigSmallCompute.compute(resultArray[i]);
			oneToFiveSingleDouble[i] = singleDoubleCompute.compute(resultArray[i]);
		}
		map.put(SscChartType.OneToFiveBigSmall.getKey(), oneToFiveBigSmall);
		map.put(SscChartType.OneToFiveSingleDouble.getKey(), oneToFiveSingleDouble);
		
		Integer[] frontMiddleBehindThree = new Integer[3];
		for(int i=0;i<resultArray.length-2;i++){
			Integer[] value = new Integer[]{resultArray[i],resultArray[i+1],resultArray[i+2]};
			frontMiddleBehindThree[i]= numberCombinationCompute.compute(value);
		}
		map.put(SscChartType.FrontMiddleBehindThree.getKey(), frontMiddleBehindThree);
		
		//對子號
		map.put(SscChartType.PairNum.getKey(), SscStatisticsUtil.checkPairNum(vo.getLastResult(),vo.getAwardResult(),vo.getLastAwardResult()));

		return map;
	}
	
	

}
