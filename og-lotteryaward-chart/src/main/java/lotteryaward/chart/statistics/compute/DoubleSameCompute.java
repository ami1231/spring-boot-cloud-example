package lotteryaward.chart.statistics.compute;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.common.ChartTypeKey;

/**
 * 对子计算模式
 * @author Ami
 *
 */
@Component
public class DoubleSameCompute implements ChartCompute<String,Integer> {

	@Override
	public Integer compute(String value) {
		Set<String> set = Arrays.stream(value.split(StatisticsComponent.COMMADN)).collect(Collectors.toSet());
		if(set.size()==2){
			return ChartTypeKey.DoubleSame.getPvalue();
		}else{
			return ChartTypeKey.DoubleSame.getNvalue();
		}
	}

}
