package www.ecom.Exception;

public class CartServiceException extends RuntimeException{
	
	private String ErrCode;

	public CartServiceException(String message,String errCode) {
		super(message);
		ErrCode = errCode;
	}

	public String getErrCode() {
		return ErrCode;
	}

	public void setErrCode(String errCode) {
		ErrCode = errCode;
	}
	
	

}
