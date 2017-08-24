package lotteryaward.chart.statistics.ssc;

public enum SscNumCombineType {
	//形态  0:雜六 1:半順  2:順子 3:對子 4:豹子
	Triple("triple",4),
	Double("double",3),
	Straight("straight ",2),
	HalfStraight ("halfStraight",1),
	None("none",0),
	;
	
	private String code;
	
	private Integer value;
	
	private  SscNumCombineType (String code , Integer value){
		this.code = code;
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	public Integer getValue() {
		return value;
	}


	public void setValue(Integer value) {
		this.value = value;
	}


	
}
