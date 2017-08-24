package lotteryaward.chart.statistics.xx5;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;
import lotteryaward.chart.statistics.xx5.util.Xx5StatisticsUtil;

@Component
public class Xx5NowTimeDistributionStatistic implements StatisticsComponent{
	
	/**
	 * XX5 即時更新頁面
	 * 
	 */

	@Autowired
	@Qualifier("numberCombinationCompute")
	private ChartCompute<Integer[],Integer> numberCombinationCompute;

	@Autowired
	@Qualifier("bigSmallBalanceCompute")
	private ChartCompute<Integer,Integer> bigSmallBalanceCompute;
	
	@Autowired
	@Qualifier("singleDoubleCompute")
	private ChartCompute<Integer,Integer> singleDoubleCompute;
	
	@Autowired
	@Qualifier("singleDoubleBalanceCompute")
	private ChartCompute<Integer,Integer> singleDoubleBalanceCompute;
	
	@Autowired
	@Qualifier("dragonTigerBalanceCompute")
	private ChartCompute<Integer,Integer> dragonTigerBalanceCompute;
	
	private String numberCombinationKey = Xx5ChartType.NumberCombination.getKey();
	private String bigSmallKey = Xx5ChartType.BigSmall.getKey();
	private String singleDoubleKey = Xx5ChartType.SingleDouble.getKey();
	private String sumKey = Xx5ChartType.Sum.getKey();
	private String dragonTigerKey = Xx5ChartType.DragonTiger.getKey();
	private String pariNumKey  = Xx5ChartType.PairNum.getKey();
	
	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		Map<String, Object> map = new HashMap<>();
		Integer sum = ChartUtil.getSumResultNumber(vo.getAwardResult());
		Integer[] awardResult = ChartUtil.getSplitNumberIntegerArray(vo.getAwardResult());
		//大小、單雙
		Integer[] bigSmallDistribution = new Integer[awardResult.length];
		Integer[] singleDoubleDistribution = new Integer[awardResult.length];
		Integer [] value= new Integer[]{6,11};
		bigSmallBalanceCompute = ChartUtil.initChartComputeParam(bigSmallBalanceCompute, value);
		singleDoubleBalanceCompute = ChartUtil.initChartComputeParam(singleDoubleBalanceCompute, 11);
		
		for(int i =0;i<awardResult.length;i++){
			bigSmallDistribution[i] = bigSmallBalanceCompute.compute(awardResult[i]);
			singleDoubleDistribution[i] = singleDoubleBalanceCompute.compute(awardResult[i]);
		}
		//總和
		Integer[] sumDistribution = new Integer[3];
		value= new Integer[]{30,30};
		bigSmallBalanceCompute = ChartUtil.initChartComputeParam(bigSmallBalanceCompute, value);
		singleDoubleCompute = ChartUtil.initChartComputeParam(singleDoubleCompute, 30);
		sumDistribution[0]=sum;
		sumDistribution[1]=bigSmallBalanceCompute.compute(sum);
		sumDistribution[2]=singleDoubleCompute.compute(sum);
		
		//龍虎
		Integer dragonTigerDistribution = dragonTigerBalanceCompute.compute(awardResult[0]-awardResult[awardResult.length-1]);
		
		//組合(前 中 後 三)
		Integer[] numberCombinationDistribution = new Integer[3];
		for(int i=0;i<awardResult.length-2;i++){
			Integer[] ball = new Integer[]{awardResult[i],awardResult[i+1],awardResult[i+2]};
			numberCombinationDistribution[i]= numberCombinationCompute.compute(ball);
		}
		//對子號
		map.put(pariNumKey, Xx5StatisticsUtil.checkPairNum(vo.getLastResult(),awardResult,vo.getLastAwardResult()));
		
		map.put(bigSmallKey,bigSmallDistribution);
		map.put(singleDoubleKey,singleDoubleDistribution);
		map.put(sumKey,sumDistribution);
		map.put(dragonTigerKey,dragonTigerDistribution);
		map.put(numberCombinationKey, numberCombinationDistribution);
		
		return map;
	}
}
