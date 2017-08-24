package lotteryaward.chart.statistics.common;

public enum ChartTypeKey {

	BigSmall("bigSmall","大小",1,-1),
	SingleDouble("singleDouble","单双",1,-1),
	DoubleSame("double","对子",1,-1),	
	TripleSame("triple","豹子",1,-1),
	NumberSumValue("numberSumValue","和值走势",1,-1),
	FixNumberValue("fixNumberValue","定位走势号码统计",1,-1),
	DragonTiger("dragonTiger","龍虎走勢",1,-1),
	HeZhi("heZhi","合質",1,-1),	
	;
	private String key;
	
	private String name;
	
	//正向
	private Integer pvalue;
	//反向
	private Integer nvalue;
	
	private ChartTypeKey(String key, String name,Integer pvalue,Integer nvalue){
		this.key = key;
		this.name = name;
		this.pvalue = pvalue;
		this.nvalue = nvalue;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPvalue() {
		return pvalue;
	}

	public void setPvalue(Integer pvalue) {
		this.pvalue = pvalue;
	}

	public Integer getNvalue() {
		return nvalue;
	}

	public void setNvalue(Integer nvalue) {
		this.nvalue = nvalue;
	}


}
