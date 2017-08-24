package lotteryaward.common.constant;

/**
 * @author Ami
 */
public enum YesOrNo {
	No(0),
	Yes(1);
	
	private int value;
	
	private YesOrNo(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
