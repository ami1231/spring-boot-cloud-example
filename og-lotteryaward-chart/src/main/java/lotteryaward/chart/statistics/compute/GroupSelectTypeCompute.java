package lotteryaward.chart.statistics.compute;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartThreeTypeKey;

/**
 * 
 * @author aron
 * 0组三 1组六 2豹子
 *
 */
@Component
public class GroupSelectTypeCompute implements ChartCompute<Integer[],Integer> {
	

	@Override
	public Integer compute(Integer[] value) {
		Set<Integer> set = Arrays.stream(value).collect(Collectors.toSet());
		if(set.size() == 1){ //豹子
			return ChartThreeTypeKey.GroupSelectType.getIvalue();
		}else if(set.size() == 2){ //組三
			return ChartThreeTypeKey.GroupSelectType.getPvalue();
		}else{
			return ChartThreeTypeKey.GroupSelectType.getNvalue();
		}	
	}

}
