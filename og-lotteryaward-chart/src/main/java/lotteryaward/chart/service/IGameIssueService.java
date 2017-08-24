package lotteryaward.chart.service;

import lotteryaward.common.domain.GameIssue;

public interface IGameIssueService {

    GameIssue selectByPrimaryKey(String id);
	
}
