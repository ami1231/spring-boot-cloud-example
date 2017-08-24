package lotteryaward.common.exception;

/**
 * 
 * @author Ami
 *
 */
@SuppressWarnings("serial")
public class RedisExcuteException  extends RuntimeException{

	public RedisExcuteException() {
	}

	public RedisExcuteException(String paramString) {
		super(paramString);
	}

	RedisExcuteException(Throwable paramThrowable) {
		super(paramThrowable);
	}

	public RedisExcuteException(String paramString, Throwable paramThrowable) {
		super(paramString, paramThrowable);
	}
}
