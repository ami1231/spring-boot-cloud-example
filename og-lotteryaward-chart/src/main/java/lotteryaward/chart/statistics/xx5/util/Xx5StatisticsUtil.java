package lotteryaward.chart.statistics.xx5.util;

import java.util.List;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.common.ChartThreeTypeKey;
import lotteryaward.chart.statistics.common.ChartTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.ssc.SscChartType;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.util.ChartValueUtils;
import lotteryaward.chart.statistics.vo.ChartResult;

public class Xx5StatisticsUtil {

	/**
	 * Xx5處理龍虎統一格式
	 * 
	 * @param compute
	 * @param value
	 * @param type
	 * @param lastValue
	 * @return
	 */
	public static Integer[] doDragonTiger(ChartCompute<Integer, Integer> compute, Integer value,
			ChartThreeTypeKey type) {
		Integer result = compute.compute(value);
		Integer[] array = null;
		if (result.equals(type.getPvalue())) {
			// 龍
			array = new Integer[] { 1, -1 };
		} else {
			// 虎
			array = new Integer[] { -1, 1 };
		}
		return array;
	}

	/**
	 * Xx5處理大小和、單雙和統一格式
	 * 
	 * @param compute
	 * @param value
	 * @param type
	 * @param lastValue
	 * @return
	 */
	public static Integer[] doSingelDoublePassOrBigSmallPass(ChartCompute<Integer, Integer> compute, Integer value,
			ChartTypeKey type, Integer[] lastValue) {
		Integer result = compute.compute(value);
		Integer[] array = null;
		if (result.equals(type.getPvalue())) {
			// 大、單
			array = new Integer[] { 1, -1 };
		} else {
			// 小、雙
			array = new Integer[] { -1, 1 };
		}
		if (lastValue != null && lastValue.length > 0) {
			array = ChartValueUtils.integerArrayValueMerge(array, lastValue);
		}
		return array;
	}

	/**
	 * 計算20期每個號碼出現次數
	 * 
	 * @param maxBallCount :總球數
	 * @param minBall : 最小球號
	 * @param twentyResult : 20期開獎號碼
	 * @return
	 */

	public static List<int[]> doHotCold(List<String> twentyResult, int minBallNum,int maxBallCount) {
		// 初始化
		List<int[]> ball = ChartUtil.initListInt( twentyResult.get(0).split(StatisticsComponent.COMMADN).length, maxBallCount);	
		// 取出每期號碼
		for (String s : twentyResult) {
			Integer[] awardResult = ChartUtil.getSplitNumberIntegerArray(s); // [1,2,3,4,5]
			// 取得目前算到第幾顆球
			for (int i = 0; i < ball.size(); i++) {
				// 比對當前號碼
				for (int j = 0; j < ball.get(i).length; j++) {
					if (j + minBallNum == awardResult[i]) {
						ball.get(i)[j]++;
					}
				}
			}
		}
		return ball;
	}
	
	/**
	 * 對子號
	 * @param 
	 * @return
	 */
	public static Integer[] checkPairNum(ChartResult chartResult,Integer[]  resultArray,String lastAward){
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
}
