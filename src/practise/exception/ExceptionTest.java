package practise.exception;

public class ExceptionTest {
	public static void main(String[] args) {
		System.out.println(testException());
	}
	public static int testException(){
		int i = 0;
		try{
			i=666;
			return i;
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			return  777;
		}
	}
}
class Teacher{
	private String name;
	private NoteBook noteBook;
	public Teacher(String name) {
		super();
		this.name = name;
		noteBook = new NoteBook();
	}


}
class NoteBook{
	private int state = 1;
	public void run() {
		if(state==1) {
			System.out.println();
		}else if(state==2) {
			
		}
	}
	public void reset() {
		System.out.println("???????????");
	}
}
class BlueScreenException extends Exception{
	public BlueScreenException() {
		super();
	}
	public BlueScreenException(String s) {
		super(s);
	}
}
class MaoYanException extends Exception{
	public MaoYanException() {
		super();
	}
	public MaoYanException(String s) {
		super(s);
	}
}
class StopException extends Exception{
	public StopException() {
		super();
	}
	public StopException(String s) {
		super(s);
	}
}
