package lotteryaward.chart.statistics.util;

import java.util.List;

public class ChartValueUtils {

	public static Integer singleValueMerge(Integer nowValue,Integer lastValue){
		if(nowValue<0){
			lastValue = lastValue > 0?lastValue=0:lastValue;
			nowValue+=lastValue;
		}
		return nowValue;
	}
	
	public static int[] intArrayValueMerge(int[] nowValues,int[] lastValues){
		for(int i= 0 ;i<nowValues.length;i++){
			if(nowValues[i]<0){
				//若之前有號碼,先重置為0
				if(lastValues[i]>0){
					lastValues[i]=0;
				}
				nowValues[i]+= lastValues[i];
			}
		}
		return nowValues;
	}
	
	public static Integer[] integerArrayValueMerge(Integer[] nowValues,Integer[] lastValues){
		for(int i= 0 ;i<nowValues.length;i++){
			if(nowValues[i]<0){
				//若之前有號碼,先重置為0
				if(lastValues[i]>0){
					lastValues[i]=0;
				}
				nowValues[i]+= lastValues[i];
			}
		}
		return nowValues;
	}
	public static List<Integer[]> listIntegerArrayValueMerge(List<Integer[]>nowValues,List<Integer[]>lastValues){
		for(int k=0;k<nowValues.size();k++){
			for(int i= 0 ;i<nowValues.get(k).length;i++){
				if(nowValues.get(k)[i]<0){
					//若之前有號碼,先重置為0
					if(lastValues.get(k)[i]>0){
						lastValues.get(k)[i]=0;
					}
					nowValues.get(k)[i]+= lastValues.get(k)[i];
				}
			}
		}
		return nowValues;
	}
	public static List<int[]> listIntArrayValueMerge(List<int[]> nowValues,List<int[]> lastValues){
		for(int k=0;k<nowValues.size();k++){
			for(int i= 0 ;i<nowValues.get(k).length;i++){
				if(nowValues.get(k)[i]<0){
					//若之前有號碼,先重置為0
					if(lastValues.get(k)[i]>0){
						lastValues.get(k)[i]=0;
					}
					nowValues.get(k)[i]+= lastValues.get(k)[i];
				}
			}
		}
		return nowValues;
	}
	
}
