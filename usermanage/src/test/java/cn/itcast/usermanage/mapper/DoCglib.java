package cn.itcast.usermanage.mapper;

public class DoCglib {

	public static void main(String[] args) {
		CglibProxy proxy = new CglibProxy();
		SayHello impl = (SayHello) proxy.getProxy(SayHello.class);
		impl.say();
	}
}
