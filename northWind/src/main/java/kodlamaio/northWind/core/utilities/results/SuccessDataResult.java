package kodlamaio.northWind.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {

	public SuccessDataResult(T data, String message) {
		super(data,true,message);
		
	}
	
	
	public SuccessDataResult(T Data) {
		super(Data, true);
	}
	
	public SuccessDataResult(String message) {
		
		super(null,true,message);
		
	}
	

}
