package sk.posta.ws.test;

public class Test {

	public static void main(String[] args) throws Exception_Exception{
		
		HelloWorldImplService hws = new HelloWorldImplService();
		HelloWorld hw = hws.getHelloWorldImplPort();
		String s = hw.getHelloWorldAsString("Filip"); 
		System.out.println("s = " + s);

	}
}
