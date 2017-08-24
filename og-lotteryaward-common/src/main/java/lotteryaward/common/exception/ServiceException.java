package lotteryaward.common.exception;

/**
 * 
 * @author Ami
 *
 */
@SuppressWarnings("serial")
public class ServiceException extends RuntimeException{
	
	public ServiceException() {
	}

	public ServiceException(String paramString) {
		super(paramString);
	}

	public ServiceException(Throwable paramThrowable) {
		super(paramThrowable);
	}

	public ServiceException(String paramString, Throwable paramThrowable) {
		super(paramString, paramThrowable);
	}
	
}
