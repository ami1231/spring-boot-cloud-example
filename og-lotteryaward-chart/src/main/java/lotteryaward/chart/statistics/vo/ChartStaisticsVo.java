package lotteryaward.chart.statistics.vo;

import java.io.Serializable;
import java.util.List;

import lotteryaward.common.domain.GameChartRecord;
import lotteryaward.common.domain.GameChartTask;

/**
 * 
 * @author Ami
 *
 */
@SuppressWarnings("serial")
public class ChartStaisticsVo implements Serializable{

	private GameChartTask gameChartTask ; 
	
	private GameChartRecord gameChartRecord ;
	
	private String awardResult;
	
	private ChartResult lastResult;
	
	private ChartResult lastHistoryResult;
	
	private String lastAwardResult;
	
	private List<String> twentyResult;
	
	public GameChartTask getGameChartTask() {
		return gameChartTask;
	}

	public void setGameChartTask(GameChartTask gameChartTask) {
		this.gameChartTask = gameChartTask;
	}

	public GameChartRecord getGameChartRecord() {
		return gameChartRecord;
	}

	public void setGameChartRecord(GameChartRecord gameChartRecord) {
		this.gameChartRecord = gameChartRecord;
	}

	public String getAwardResult() {
		return awardResult;
	}

	public void setAwardResult(String awardResult) {
		this.awardResult = awardResult;
	}

	public ChartResult getLastResult() {
		return lastResult;
	}

	public void setLastResult(ChartResult lastResult) {
		this.lastResult = lastResult;
	}

	public String getLastAwardResult() {
		return lastAwardResult;
	}

	public void setLastAwardResult(String lastAwardResult) {
		this.lastAwardResult = lastAwardResult;
	}

	public List<String> getTwentyResult() {
		return twentyResult;
	}

	public void setTwentyResult(List<String> twentyResult) {
		this.twentyResult = twentyResult;
	}

	public ChartResult getLastHistoryResult() {
		return lastHistoryResult;
	}

	public void setLastHistoryResult(ChartResult lastHistoryResult) {
		this.lastHistoryResult = lastHistoryResult;
	}

}
