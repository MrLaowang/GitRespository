package cn.itcast.usermanage.mapper;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{

	private Enhancer enhancer = new Enhancer();
	public Object getProxy(Class clazz){
		//设置需要创建子类的类
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);//主要是为了intercept可以被回调
		//通过字节码技术动态创建子类实例
		return enhancer.create();
	}
	
	 /** 
     * 拦截所有目标类方法的调用 
     * obj  目标类的实例(是已经被增强的子类，该子类中的对应的方法都被增强了，也就是说都调用了这个intercept方法，所以如果在这个方法(intercept)中使用method.invoke(obj,args)就会循环调用) 
     * m   目标方法的反射对象 
     * args  方法的参数 
     * proxy代理类的实例(生成的代理类对方法的代理引用) 
     */ 
	@Override
	public Object intercept(Object obj, Method method, Object[] args,MethodProxy proxy) throws Throwable {
		System.out.println("前置代理");
		Object object = proxy.invokeSuper(obj, args);
		
		System.out.println("后置代理");
		return object;
	}

}
