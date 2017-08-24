package lotteryaward.chart.statistics.xx5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import lotteryaward.chart.statistics.StatisticsComponent;
import lotteryaward.chart.statistics.util.ChartUtil;
import lotteryaward.chart.statistics.vo.ChartStaisticsVo;

@Component
public class Xx5TodayNumberStatistics implements StatisticsComponent {

	/**
	 * Xx5今日號碼統計
	 * 
	 */
	private String key = Xx5ChartType.TodayNumberStatistics.getKey();

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> chartRecord(ChartStaisticsVo vo) {
		// 初始化
		List<List<int[]>> lastHistortyResult = new ArrayList<>();
		for (int i = 0; i < 11; i++) {
			lastHistortyResult.add(ChartUtil.initListInt(5, 2));
		}
		// 取得號碼
		Integer[] award = ChartUtil.getSplitNumberIntegerArray(vo.getAwardResult());
		if (vo.getLastHistoryResult() != null && vo.getLastHistoryResult().containsKey(key)) {
			lastHistortyResult = getMapValue(vo.getLastHistoryResult(), key, List.class);
		}
		//取得目前在第幾個號碼
		for (int i = 0; i < lastHistortyResult.size(); i++) {
			//此號碼是否有在這球數出現
			for (int j = 0; j < lastHistortyResult.get(i).size(); j++) {
				if (i == award[j]-1) {
					lastHistortyResult.get(i).get(j)[0]++;
				} else {
					lastHistortyResult.get(i).get(j)[1]++;
				}
			}
		}
		Map<String, Object> map = new HashMap<>();
		map.put(key, lastHistortyResult);
		return map;
	}

}
