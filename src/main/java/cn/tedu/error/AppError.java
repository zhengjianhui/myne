package cn.tedu.error;

@SuppressWarnings("serial")
public class AppError extends RuntimeException{

	public AppError() {
		super();
	}
	
	public AppError(String message) {
		super(message);
	}
}
