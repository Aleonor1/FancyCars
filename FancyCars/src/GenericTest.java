
public class GenericTest {
	
	public <E> E SmartReturn(int n) {
		if (n==1) {
			return (E) "ok";
		}else {
			return (E) Integer.valueOf(1);
		}
	}
	
	public static <E> void main(String[] args) {
		GenericTest t1 = new GenericTest();
		E v1 = t1.SmartReturn(1);
		System.out.println(v1);
		E v2 = t1.SmartReturn(2);
		E v3 = (E) Integer.valueOf(2);
		System.out.println(v2);
	}
}
