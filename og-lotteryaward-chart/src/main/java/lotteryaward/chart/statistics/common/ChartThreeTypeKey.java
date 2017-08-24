package lotteryaward.chart.statistics.common;

public enum ChartThreeTypeKey {

	BigSmall("bigSmall","大小和",1,-1,0),
	SingleDouble("singleDouble","单双和",1,-1,0),
	DragonTiger("dragonTiger","龍虎和",1,-1,0),
	ZeroOneTwo("zeroOneTwo","012",0,1,2),
	UpDown("upDown","升平降",1,-1,0),
	GroupSelectType("groupSelectType","組三組六豹子",1,-1,0),
	HotCold("hotCold","熱冷溫",1,-1,0),	
	;
	
	private String key;
	
	private String name;
	
	//正向
	private Integer pvalue;
	//反向
	private Integer nvalue;
	//中立
	private Integer ivalue;
	
	
	private ChartThreeTypeKey(String key, String name,Integer pvalue,Integer nvalue,Integer ivalue){
		this.key = key;
		this.name = name;
		this.pvalue = pvalue;
		this.nvalue = nvalue;
		this.ivalue = ivalue;
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
	
	public Integer getIvalue() {
		return ivalue;
	}

	public void setIvalue(Integer ivalue) {
		this.ivalue = ivalue;
	}

}
