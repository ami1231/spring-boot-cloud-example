package lotteryaward.chart.statistics.compute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;


/**
 * 判斷 豹子、對子、順子、半順、雜六
 * 0:雜六 1:半順  2:順子 3:對子 4:豹子
 * @return
 * */
@Component
public class NumberCombinationCompute implements ChartCompute<Integer[],Integer> {
	
	@Override
	public Integer compute(Integer[] value) {
		//判斷是否為豹子或對子 
		Set<Integer> set = Arrays.stream(value).collect(Collectors.toSet());
		if(set.size()==1){ //豹子
			return 4;
		}else if(set.size()==2){ //對子
			return 3;
		}else{
			List<Integer> array = new ArrayList<>();
			array.addAll(set);
			int k = 0, hasZero = 0;
			//[0,1,9]
			for(int i=1;i<array.size();i++){
				if(array.get(0)==0) hasZero=1; 
				//正常情況
				if(array.get(i)-1==array.get(i-1)) k++;
				//特殊情況 SSC用
				else if(hasZero==1 && array.get(i)==8 && array.get(i-1)==0) k++;
				else if(hasZero==1 && array.get(i)==9 && (array.get(i-1)==1 || array.get(i-2)==0)) k++;
			}
			return k;
		}	
	}
}
