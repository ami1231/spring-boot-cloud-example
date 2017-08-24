package lotteryaward.chart.statistics.xx5.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.compute.ChartCompute;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

public abstract class Xx5RoadBeadsTwoFaceTemplate implements StatisticsComponent {

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		Integer tail = ChartUtil.getSumResultNumber(vo.getAwardResult())%10;
		List<Integer> roadBeads = new ArrayList<>();
		if(vo.getLastResult()!=null && vo.getLastResult().containsKey(getKey())){
			roadBeads = new ArrayList<>(getMapValue(vo.getLastResult(), getKey(), List.class));
		}
		roadBeads.add(getChartCompute().compute(tail));
		Map<String,Object> map = new HashMap<String, Object>();
		map.put(getKey(), roadBeads);
		return map;
	}

	protected abstract ChartCompute<Integer, Integer> getChartCompute();

	protected abstract String getKey();
}
