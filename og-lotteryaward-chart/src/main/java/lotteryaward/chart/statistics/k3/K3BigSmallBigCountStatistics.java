package lotteryaward.chart.statistics.k3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.common.ChartTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.k3.common.K3CountTemplateStatistics;
import lotteryaward.chart.statistics.util.ChartUtil;

@Component
public class K3BigSmallBigCountStatistics extends K3CountTemplateStatistics {

	@Autowired
	@Qualifier("bigSmallCompute")
	private ChartCompute<Integer, Integer> bigSmallCompute;
	
	@Override
	protected ChartCompute<Integer, Integer> getChartCompute() {
		bigSmallCompute = ChartUtil.initChartComputeParam(bigSmallCompute, 4);
		return bigSmallCompute;
	}

	@Override
	protected Integer getCheckValue() {
		return ChartTypeKey.BigSmall.getNvalue();
	}

	@Override
	protected String getKey() {
		return K3ChartType.BigCount.getKey();
	}

}
