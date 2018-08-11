package practise.designpattern;

public class SingletonDemo {
	public static void main(String[] args) {
		HungerSingleton hungerSingleton = HungerSingleton.getInstance();
		LazySingleton lazySingleton = LazySingleton.getInstance();
	}
}
//饿汉式单例模式
class HungerSingleton{
	private static HungerSingleton singleton = new HungerSingleton();
	private HungerSingleton(){
	}
	public static HungerSingleton getInstance() {
		return singleton;
	}
}
//线程安全的懒汉式单例模式
class LazySingleton{
	private static LazySingleton lazySingleton = null;
	private LazySingleton() {
	}
	public static LazySingleton getInstance() {
		if (lazySingleton == null) {
			synchronized (LazySingleton.class) {
				if (lazySingleton == null) {
					lazySingleton = new LazySingleton();
				}
			}
		}
		return lazySingleton;
	}
}
