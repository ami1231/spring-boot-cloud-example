package lotteryaward.chart.statistics.ssc.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import lotteryaward.chart.statistics.common.ChartThreeTypeKey;
import lotteryaward.chart.statistics.common.ChartTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.k3.util.K3StatisticsUtil;
import lotteryaward.chart.statistics.ssc.SscChartType;
import lotteryaward.chart.statistics.ssc.SscNumCombineType;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.util.ChartValueUtils;
import lotteryaward.chart.statistics.vo.ChartResult;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

public class SscStatisticsUtil {
	
	
	
	public static Integer[] threeFaceCheck(ChartCompute<Integer,Integer> compute,Integer value,ChartThreeTypeKey type,Integer[] lastValue){
		Integer result = compute.compute(value);
		return SscStatisticsUtil.check(result, type, lastValue);
	}
	public static Integer[] threeFaceCheck(ChartCompute<Integer[],Integer> compute,Integer[] value,ChartThreeTypeKey type,Integer[] lastValue){
		Integer result = compute.compute(value);
		return SscStatisticsUtil.check(result, type, lastValue);
	}
	
	public static Integer[] check(Integer result,ChartThreeTypeKey type,Integer[] lastValue){
		
		Integer[] array = null;
		if(result.equals(type.getPvalue())){
			   //0 升 大 單 組三
			array =new Integer[]{1,-1,-1};			
		}else if(result.equals(type.getNvalue())){
			   //1 平 小 雙 組六
			array =new Integer[]{-1,1,-1};			
		}else{ //2 降 和 和 豹子
			array =new Integer[]{-1,-1,1};	
		}
		if(lastValue!=null && lastValue.length>0){
			array = ChartValueUtils.integerArrayValueMerge(array,lastValue);			
		}
		return array;
		
	}
	
	@SuppressWarnings("unchecked")
	public static List<Integer[]> twoFaceDistribution(ChartStaisticsVo vo ,String key ,ChartCompute<Integer,Integer> compute ,ChartTypeKey type){

		ChartResult chartResult = vo.getLastResult();
		Integer[] resultArray =  ChartUtil.getSplitNumberIntegerArray( vo.getAwardResult());
		
		List<Integer[]> distribution = new ArrayList<>();
		List<Integer[]> lastDistribution = new ArrayList<>();

		if(chartResult!=null && chartResult.containsKey(key)){
			lastDistribution = (List<Integer[]> ) chartResult.get(key);
		}
		
		for(int i = 0; i < resultArray.length;i++){
			Integer[] array = null;
			Integer[] lastArray = null;			
			if(!CollectionUtils.isEmpty(lastDistribution)){
				lastArray = lastDistribution.get(i);
			}
			//計算每球大小且merge 新舊資料
			array = K3StatisticsUtil.
						doSingelDoubleOrBigSmall(compute,resultArray[i], type, lastArray);
			distribution.add(array);			
		}
		
		return distribution;
		
		
	}
	
	@SuppressWarnings("unchecked")
	public static List<Integer[]> threeFaceDistribution(ChartStaisticsVo vo ,String key ,ChartCompute<Integer,Integer> compute ,ChartThreeTypeKey type){

		ChartResult chartResult = vo.getLastResult();
		Integer[] resultArray =  ChartUtil.getSplitNumberIntegerArray(vo.getAwardResult());
		
		Integer[] lastResultArray =  ChartUtil.getSplitNumberIntegerArray(vo.getLastAwardResult());

		List<Integer[]> distribution = new ArrayList<>();
		List<Integer[]> lastDistribution = new ArrayList<>();

		if(chartResult!=null && chartResult.containsKey(key)){
			lastDistribution = (List<Integer[]> ) chartResult.get(key);
		}
		
		for(int i = 0; i < resultArray.length;i++){
			Integer[] array = null;
			Integer[] lastArray = null;			
			Integer value = null;
			if(!CollectionUtils.isEmpty(lastDistribution)){
				lastArray = lastDistribution.get(i);
			}
			if(type.equals(ChartThreeTypeKey.UpDown)){
				value = resultArray[i] - lastResultArray[i];
			}else{
				value = resultArray[i];
			}
			//計算每球大小且merge 新舊資料
			array = SscStatisticsUtil.
					threeFaceCheck(compute, value, type, lastArray);
			distribution.add(array);			
		}
		
		return distribution;
		
		
	}
	
	/**
	 * 型態  順子 半順 雜六 豹子 對子
	 * @param compute
	 * @param value
	 * @param lastValue
	 * @return
	 */

	public static Integer[] numCombineCheck(ChartCompute<Integer[],Integer> compute,Integer[] value,Integer[] lastValue){
		Integer result = compute.compute(value);
		Integer[] array = null;
		if(result.equals(SscNumCombineType.Triple.getValue())){
			array =new Integer[]{1,-1,-1,-1,-1};			
		}else if(result.equals(SscNumCombineType.Straight.getValue())){
			array =new Integer[]{-1,1,-1,-1,-1};			
		}else if(result.equals(SscNumCombineType.Double.getValue())){
			array =new Integer[]{-1,-1,1,-1,-1};			
		}else if(result.equals(SscNumCombineType.HalfStraight.getValue())){
			array =new Integer[]{-1,-1,-1,1,-1};			
		}else{ 
			array =new Integer[]{-1,-1,-1,-1,1};	
		}
		if(lastValue!=null && lastValue.length>0){
			array = ChartValueUtils.integerArrayValueMerge(array,lastValue);			
		}
		return array;
	}
	
	
	public static Integer[] checkPairNum(ChartResult chartResult,String award,String lastAward){
			
		Integer[] resultArray =  ChartUtil.getSplitNumberIntegerArray(award);
		String key = SscChartType.PairNum.getKey();
		if(lastAward!=null && chartResult!=null && chartResult.containsKey(key)){
			//上次開獎結果
			Integer[] lastResultArray =  ChartUtil.getSplitNumberIntegerArray(lastAward);
			//上次對子號紀錄
			Integer[] lastPairNum = (Integer[])chartResult.get( key);
			for(int i=0 ;i<resultArray.length;i++){
				if(resultArray[i].equals(lastResultArray[i])){
					lastPairNum[i] = lastPairNum[i] + 1 ;
				}else{
					lastPairNum[i] = 1;
				}
			}
			return lastPairNum;
		}else{
			//初始化
			Integer[] result = new Integer[resultArray.length];
			for(int i=0 ;i<resultArray.length;i++){
				result[i] = 1;
			}
			return result;
		}
	}
	
	/**
	 * 歷史號碼統計
	 * @param chartResult
	 * @param awardResult
	 * @param key
	 * @param ballNumLength
	 * @return
	 */
	public static Integer [] historyNumStatistics(ChartResult chartResult,Integer[] resultArray  ,String key ,int ballNumLength){
		
		Integer [] historyNum =  null;
		if(chartResult!=null && chartResult.containsKey(key)){
			historyNum = (Integer[])chartResult.get( key); 
		}else{
			historyNum = ChartUtil.initInteger(ballNumLength);
		}
		for(int i=0;i<resultArray.length;i++){
			
			for(int j=0;j<historyNum.length;j++){
				if(resultArray[i]==j){
					historyNum[j] = historyNum[j]+1;
				}
			}
			
		}
		
		return historyNum;
	}
	
	public static Integer [] historyTwoFaceStatistics(ChartResult chartResult,Integer[] resultArray 
			,ChartCompute<Integer,Integer> compute,ChartTypeKey type,String key ,int arrayLength){
		
		Integer [] array =  null;
		if(chartResult!=null && chartResult.containsKey(key)){
			array = (Integer[])chartResult.get(key); 
		}else{
			array = ChartUtil.initInteger(arrayLength);
		}
	
		for(int i=0;i<resultArray.length;i++){
			Integer bigSmall = compute.compute(resultArray[i]);
			if(bigSmall.equals(type.getPvalue())){
				array[0]=array[0]+1;
			}else{
				array[1]=array[1]+1;
			}
		}
		return array;
	}
	public static Integer [] historyThreeFaceStatistics(ChartResult chartResult,Integer value 
			,ChartCompute<Integer,Integer> compute,ChartThreeTypeKey type,String key ,int arrayLength){
		
		Integer [] array =  null;
		if(chartResult!=null && chartResult.containsKey(key)){
			array = (Integer[])chartResult.get(key); 
		}else{
			array = ChartUtil.initInteger(arrayLength);
		}
	
		
		Integer bigSmall = compute.compute(value);
		if(bigSmall.equals(type.getPvalue())){
			array[0]=array[0]+1;
		}else if(bigSmall.equals(type.getNvalue())){
			array[1]=array[1]+1;
		}else{
			array[2]=array[2]+1;
		}
		
		return array;
	}

}
