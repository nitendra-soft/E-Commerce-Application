package www.ecom.response;

public class ApiResponse<T> {
	
	private String message;
	private Integer status;
	private T data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApiResponse(String message, Integer status, T data) {
		super();
		this.message = message;
		this.status = status;
		this.data = data;
	}
	@Override
	public String toString() {
		return "ApiResponse [message=" + message + ", status=" + status + ", data=" + data + "]";
	}
	
	

}
