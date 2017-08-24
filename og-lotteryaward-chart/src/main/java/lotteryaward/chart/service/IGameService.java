package lotteryaward.chart.service;

import lotteryaward.common.domain.Game;

public interface IGameService {

    Game selectByPrimaryKey(String id);
	
}
