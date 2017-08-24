package lotteryaward.chart.statistics.ssc;

public enum SscChartType {
	
	Distribution("distribution"),
	BigSmallDisbution("bigSmallDisbution"),
	SingleDoubleDisbution("singleDoubleDisbution"),
	HeZhiDisbution("heZhiDisbution"),
	ZeroOneTwoDisbution("zeroOneTwoDisbution"),
	UpDownDisbution("upDownDisbution"),
	DragonTigerDisbution("dragonTigerDisbution"),
	SumBigSmallSingleDouble("sumBigSmallSingleDouble"),
	DragonTiger("dragonTiger"),
	OneToFiveBigSmall("oneToFiveBigSmall"),
	OneToFiveSingleDouble("oneToFiveSingleDouble"),
	FrontMiddleBehindThree("frontMiddleBehindThree"),
	GroupSelectType("groupSelectType"),
	PairNum("pairNum"),
	HistoryNum("historyNum"),
	HistoryNumBigSmall("historyNumBigSmall"),
	HistoryNumSingleDouble("historyNumSingleDouble"),
	HistoryNumDragonTiger("historyNumDragonTiger"),
	HistroyBallBigSmall("historyBallBigSmall"),	
	HistoryBallSingleDouble("historyBallSingleDouble"),
	HistorySumBigSmall("historySumBigSmall"),
	HistorySumSingleDouble("historySumSingleDouble"),
	HotColdStatistic("hotColdeStatistic"),		;
	
	private SscChartType(String key){
		this.key = key;
		
	}
	
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	



}
