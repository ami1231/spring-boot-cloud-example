package lotteryaward.chart.statistics.compute;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartThreeTypeKey;

/**
 * 012判斷 zero 0,3,6,9 one 1,4,7 two 2,5,8
 * @author aronlin
 *
 */

@Component
public class ZeroOneTwoCompute implements ChartCompute<Integer,Integer>{
	
	@Override
	public Integer compute(Integer value) {
		
		
		Integer [] zero = {0,3,6,9};
		Integer [] one = {1,4,7};
		
		if(Arrays.asList(zero).contains(value)){
			return ChartThreeTypeKey.ZeroOneTwo.getPvalue();
		}else if(Arrays.asList(one).contains(value)){
			return ChartThreeTypeKey.ZeroOneTwo.getNvalue();
		}else{
			return ChartThreeTypeKey.ZeroOneTwo.getIvalue();
		}
	}
		

}
