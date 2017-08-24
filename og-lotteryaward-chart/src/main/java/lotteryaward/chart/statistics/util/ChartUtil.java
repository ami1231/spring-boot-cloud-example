package lotteryaward.chart.statistics.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.compute.ChartComputeParam;

public class ChartUtil {
	
	/**
	 * 獲取號碼總和
	 * @param result
	 * @return
	 */
	public static int getSumResultNumber(String result){
		return Arrays.stream(result.split(StatisticsComponent.COMMADN)).
				mapToInt(s-> {return Integer.valueOf(s);}).sum();
	}
	
	/**
	 * 取得號碼Stream
	 * @param result
	 * @return
	 */
	public static Stream<String> getSplitNumberStream(String result){
		return Arrays.stream(result.split(StatisticsComponent.COMMADN));
	}
	
	/**
	 * 取得號碼字串
	 * @param result
	 * @return
	 */
	public static String[] getSplitNumberArray(String result){
		return Arrays.stream(result.split(StatisticsComponent.COMMADN))
				.map(s->s.trim()).collect(Collectors.toList()).toArray(new String[0]);
	}
	
	/**
	 * 取得號碼數字陣列
	 * @param awardResult
	 * @param length
	 * @return
	 */
	public static Integer[] getSplitNumberIntegerArray(String awardResult){
		
		if(awardResult != null){
			return  getSplitNumberStream(awardResult).map(s->Integer.valueOf(s.trim())).
					collect(Collectors.toList()).toArray(new Integer[0]);
		}else{
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T,M,V> ChartCompute<T,M> initChartComputeParam(ChartCompute<T,M> compute,V param){
		if(compute instanceof ChartComputeParam){
			ChartComputeParam<V> chartComputeParam = (ChartComputeParam<V>)compute;
			chartComputeParam.setComputeParam(param);
			compute = (ChartCompute<T,M>)chartComputeParam;
			return compute;
		}else{
			return compute;
		}
		
	}
	
	/**
	 * 初始化List<int[]>
	 * @param listLength : List長度
	 * @Param length : int 長度
	 * */
	public static List<int[]> initListInt (Integer listLength,Integer length){
		List<int[]> list = new ArrayList<>();
		for(int i =0 ;i< listLength;i++){
			list.add(new int[length]);
		}
		return list;
	}
	
	/**
	 * 初始化 int[]
	 * @Param length : int 長度
	 * */
	public static int[] initInt (Integer length){
		return new int[length];
	}
	/**
	 * 初始化 Integer[]
	 * @Param length : int 長度
	 * */
	public static Integer[] initInteger (Integer length){
		Integer[] array = Arrays.stream( new int[length] ).boxed().toArray( Integer[]::new );
		return array;
	}
}