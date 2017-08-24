package lotteryaward.common.page;

public interface PageNumber {

	int getOffset(Page<?> page);
	
	int getLimit(Page<?> page);
}
