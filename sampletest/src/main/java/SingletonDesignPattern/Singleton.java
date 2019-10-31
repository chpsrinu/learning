package SingletonDesignPattern;

public class Singleton {

	//eager initialization
	private static final Singleton singleton = new Singleton();
	
	private Singleton(){
		
	}
	
	public static Singleton getSingletonInstance() {
		return singleton;
	}
	
	//lazy initialization
	private static Singleton singleton1;
	
	public static Singleton getSingletonInstanceLazy() {
		if(singleton1 == null) {
			singleton1 = new Singleton();
		}
		return singleton1;
	}
	
	//lazy thread safe
	private static Singleton singletonThreadSafe;
	
	public static Singleton getSingletonInstanceThreadSafe() {
		if (singletonThreadSafe == null) {
			synchronized (Singleton.class) {
				if(singletonThreadSafe == null) {
					singletonThreadSafe = new Singleton();
				}
			}
		}
		return singletonThreadSafe;
	}
	
	public enum SingletonEnum {
		INSTANCE;
	}
}
