package lotteryaward.chart.statistics.k3.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.common.ChartTypeKey;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.k3.util.K3StatisticsUtil;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

/**
 * 整合K3百位 十位 各位 大小 單雙 共用模板
 * @author Ami
 *
 */
public abstract class K3NumberSiteTemplateStatistics implements StatisticsComponent {

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		Map<String, Object> map = new HashMap<>();
		List<Integer[]> values = new ArrayList<>();
		List<Integer[]> lastValues = getMapValue(vo.getLastResult(), getKey(), List.class);
		ChartCompute<Integer, Integer> compute= getChartCompute();
		
		int index = 0;
		for (String s : vo.getAwardResult().split(COMMADN)) {
			Integer[] array = null;
			Integer[] lastArray = null;
			if (!CollectionUtils.isEmpty(lastValues)) {
				lastArray = lastValues.get(index);
			}
			array = K3StatisticsUtil.doSingelDoubleOrBigSmall(compute, Integer.valueOf(s),
					getChartTypeKey(), lastArray);
			values.add(array);
			index++;
		}
		map.put(getKey(), values);

		return map;
	}

	protected abstract ChartCompute<Integer, Integer> getChartCompute();

	protected abstract ChartTypeKey getChartTypeKey();

	protected abstract String getKey();

}
