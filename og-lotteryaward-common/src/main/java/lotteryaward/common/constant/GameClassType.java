package lotteryaward.common.constant;

/**
 * 
 * @author Ami
 *
 */
public enum GameClassType {

	SSC("SSC","时时彩"),
	K3("K3","快3"),
	PK10("PK10","赛车彩"),
	KL8("KL8","快乐彩"),
	LHC("LHC","六合彩"),
	XX5("XX5","11选五");
	
	private String value;
	
	private String name;
	
	private GameClassType(String value,String name){
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
