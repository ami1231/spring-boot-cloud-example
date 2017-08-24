package lotteryaward.chart.statistics.k3.util;

import java.util.ArrayList;
import java.util.List;

import lotteryaward.chart.statistics.common.ChartTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.util.ChartValueUtils;

public class K3StatisticsUtil {

	/**
	 * K3處理大小、單雙統一格式
	 * @param compute
	 * @param value
	 * @param type
	 * @param lastValue
	 * @return
	 */
	public static Integer[] doSingelDoubleOrBigSmall(ChartCompute<Integer,Integer> compute,Integer value,ChartTypeKey type,Integer[] lastValue){
		Integer result = compute.compute(value);
		Integer[] array = null;
		if(result.equals(type.getPvalue())){
			//大,單
			array =new Integer[]{1,-1};			
		}else{
			//小,雙
			array =new Integer[]{-1,1};			
		}
		if(lastValue!=null && lastValue.length>0){
			array = ChartValueUtils.integerArrayValueMerge(array,lastValue);			
		}
		return array;
	}
	
	

	/**
	 * K3處理大小、單雙比例共用
	 * @param compute
	 * @param value
	 * @param type
	 * @param lastValue
	 * @return
	 */
	public static Integer[] doSingelDoubleOrBigSmallRatio(ChartCompute<Integer,Integer> compute,String awardResult,ChartTypeKey type,Integer[] lastValue){
		List<Integer> list = new ArrayList<>();		
		Integer[] values = null;
		ChartUtil.getSplitNumberStream(awardResult).forEach(s->{
			Integer result = compute.compute(Integer.valueOf(s));
			if(result.equals(type.getPvalue())){
				list.add(1);
			}
		});
		//大:小 單:雙 0:3
		if(list.isEmpty()){
			values = new Integer[]{-1,-1,-1,1};
		//1:2	
		}else if(list.size()==1){
			values = new Integer[]{-1,-1,1,-1};			
		//2:1				
		}else if(list.size()==2){
			values = new Integer[]{-1,1,-1,-1};						
		//3:0
		}else{
			values = new Integer[]{1,-1,-1,-1};									
		}
		
		if(lastValue!=null && lastValue.length>0){
			values = ChartValueUtils.integerArrayValueMerge(values,lastValue);			
		}

		return values;
	}
	
	
	/**
	 * 計算大小單雙的個數
	 * @param compute
	 * @param awardResult
	 * @param checkValue
	 * @param lastValue
	 * @return
	 */
	public static Integer[] doSingelDoubleOrBigSmallCount(ChartCompute<Integer,Integer> compute,String awardResult,Integer checkValue,Integer[] lastValue){
		List<Integer> list = new ArrayList<>();		
		Integer[] values = null;
		ChartUtil.getSplitNumberStream(awardResult).forEach(s->{
			Integer result = compute.compute(Integer.valueOf(s));
			if(result.equals(checkValue)){
				list.add(1);
			}
		});
		if(list.isEmpty()){
			values = new Integer[]{-1,-1,-1,1};
		}else if(list.size()==1){
			values = new Integer[]{-1,-1,1,-1};			
		}else if(list.size()==2){
			values = new Integer[]{-1,1,-1,-1};						
		}else{
			values = new Integer[]{1,-1,-1,-1};									
		}
		
		if(lastValue!=null && lastValue.length>0){
			values = ChartValueUtils.integerArrayValueMerge(values,lastValue);			
		}

		return values;
	}
	
	
	
}
