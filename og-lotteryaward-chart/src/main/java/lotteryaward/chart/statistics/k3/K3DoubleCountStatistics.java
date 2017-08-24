package lotteryaward.chart.statistics.k3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.k3.common.K3CountTemplateStatistics;

/**
 * 
 * @author Ami
 *
 */
@Component
public class K3DoubleCountStatistics extends K3CountTemplateStatistics {

	@Autowired
	@Qualifier("singleDoubleCompute")
	private ChartCompute<Integer, Integer> singleDoubleCompute;
	
	@Override
	protected ChartCompute<Integer, Integer> getChartCompute() {
		return singleDoubleCompute;
	}

	@Override
	protected Integer getCheckValue() {
		return ChartTypeKey.SingleDouble.getPvalue();
	}

	@Override
	protected String getKey() {
		return K3ChartType.DoubleCount.getKey();
	}

}
