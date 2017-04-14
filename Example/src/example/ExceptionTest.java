package example;

public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long beginDate=System.nanoTime();
		int a=4;
		int b=0;
		try{
			a=4/3;
		}
		catch(ArithmeticException e){
			e.printStackTrace();
//			System.exit(0);
		}
		finally{ 
			System.out.println("这是finally的输出");
		}
		long endDate=System.nanoTime();
		long time=beginDate-endDate;
		System.out.println(time);
	}
}
