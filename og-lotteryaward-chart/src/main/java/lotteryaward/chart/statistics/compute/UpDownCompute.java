package lotteryaward.chart.statistics.compute;

import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartThreeTypeKey;

/**
 * 升平降
 * @author aronlin
 *
 */


@Component
public class UpDownCompute implements ChartCompute<Integer,Integer> {

	@Override
	public Integer compute(Integer value) {
		if(value > 0){
			return ChartThreeTypeKey.UpDown.getPvalue();
		}else if(value < 0){
			return ChartThreeTypeKey.UpDown.getIvalue();
		}else{
			return ChartThreeTypeKey.UpDown.getNvalue();
		}
	}
}
