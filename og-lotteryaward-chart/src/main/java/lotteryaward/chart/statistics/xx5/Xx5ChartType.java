package lotteryaward.chart.statistics.xx5;

public enum Xx5ChartType {
	Distribution("distribution"),  							//基本走勢
	DragonTigerDistribution("dragonTigerDistribution"),		//龍虎走勢
	BigSmallDistribution("bigSmallDistribution"),			//大小走勢
	SingleDoubleDistribution("singleDoubleDistribution"),	//單雙走勢
	SumBigSmall("sumBigSmall"),								//總和分佈大小和
	SumSingleDouble("sumSingleDouble"),						//總和分佈單雙和
	TailBigSmall("tailBigSmall"),							//總和分佈 尾大尾小走勢
	SumDistribution("sumDistribution"),						//總和走勢
	NumberDistribution("numberDistribution"), 				//號碼分佈
	BigSmall("bigSmall"),									//即時頁面大小
	SingleDouble("singleDouble"),							//即時頁面單雙
	DragonTiger("dragonTiger"),								//即時頁面龍虎
	Sum("sum"),												//即時頁面總和
	PairNum("pairNum"),										//即時頁面對子號
	NumberCombination("numberCombination"),					//即時頁面組合
	HotColdStatistic("hotColdeStatistic"),					//冷熱分析
	HistoryBallBigSmall("historyBallBigSmall"),				//大小歷史
	HistoryBallSingleDouble("historyBallSingleDouble"),		//單雙歷史
	HistorySumBigSmall("historySumBigSmall"),				//總和大小歷史
	HistorySumSingleDouble("historySumSingleDouble"),		//總和單雙歷史
	TodayNumberStatistics("todayNumberStatistics"),			//今日號碼統計
	RoadBeadsBigSmall("roadBeadsBigSmall"),					//路珠大小
	RoadBeadsSingleDouble("roadBeadsSingleDouble"),			//路珠單雙
	RoadBeadsSumBigSmall("roadBeadsSumBigSmall"),			//路珠總和大小
	RoadBeadsSumSingleDouble("roadBeadsSumSingleDouble"),	//路珠總和單雙
	RoadBeadsTailBigSmall("roadBeadsTailBigSmall"),			//路珠尾大尾小
	RoadBeadsTailSingleDouble("roadBeadsTailBigSmall"),		//路珠尾單尾雙
	RoadBeadsDragonTiger("roadBeadsDragon"),				//路珠龍虎
	;
	
	private String key;
	
	private Xx5ChartType(String key){
		this.key = key;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

}