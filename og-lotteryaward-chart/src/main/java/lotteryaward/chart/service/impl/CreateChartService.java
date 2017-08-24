package lotteryaward.chart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lotteryaward.chart.service.ICreateChartService;
import lotteryaward.common.cache.LotteryAwardCache;
import lotteryaward.common.domain.GameChartTask;
import lotteryaward.common.domain.GameResult;

@Service
public class CreateChartService implements ICreateChartService {

	@Autowired
	private LotteryAwardCache cache;
	
	@Override
	public void createChartStatistics(GameResult result) {
		GameChartTask gameChartTask = new GameChartTask();
		
		
		
		
		
	}

}