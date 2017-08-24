package lotteryaward.common.constant;

/**
 * 
 * @author Ami
 *
 */
public enum GameType {

	GPCP("GPCP","高频彩"),
	FOCP("FOCP","境外彩"),
	COGP("GOCP","全国彩"),;
	
	private String value;
	
	private String name;
	
	private GameType(String value , String name){
		this.value = value;
		this.name = name;
	}


	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
}
