package lotteryaward.chart.statistics.k3;

public enum K3ChartType {

	Distribution("distribution"),
	DistributionCount("distributionCount"),
	NumberSum("numberSum"),
	ThreeDifferent("threeDifferent"),
	FixDistribution("fixDistribution"),
	NumberSiteBigSmall("numberSiteBigSmall"),
	NumberSiteSingleDouble("numberSiteSingleDouble"),
	SumSingleDouble("sumSingleDouble"),
	SumBigSmall("sumBigSmall"),
	BigSmallRatio("bigSmallRatio"),
	SingleDoubleRatio("singleDoubleRatio"),	
	BigCount("bigCount"),	
	SmallCount("smallCount"),		
	SingleCount("singleCount"),	
	DoubleCount("doubleCount"),	
	NumberRoadBeads("numberRoadBeads"),
	SumBigSmallRoadBeads("sumBigSmallRoadBeads"),	
	SumSingleDoubleRoadBeads("sumSingleDoubleRoadBeads"),		
	AwardSum("awardSum"),			
	;
	
	private String key;

	private K3ChartType(String key){
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}