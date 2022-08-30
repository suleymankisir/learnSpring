package kodlamaio.northWind.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {

	public ErrorDataResult(T data, String message) {
		super(data,false,message);
		
	}
	
	
	public ErrorDataResult(T Data) {
		super(Data, false);
	}
	
	public ErrorDataResult(String message) {
		
		super(null,false,message);
		
	}
}
