package lotteryaward.chart.service;

import lotteryaward.common.domain.GameResult;

public interface ICreateChartService {

	void createChartStatistics(GameResult result);
	
}
