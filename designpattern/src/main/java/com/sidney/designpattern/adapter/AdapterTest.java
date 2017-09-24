package com.sidney.designpattern.adapter;

/**
 * 方法的适配器
 * @author Sidney
 *
 */
public class AdapterTest {

	public static void main(String[] args) {
		
		
		System.err.println("********方法层面的适配器*******");
		/**1.类的适配器模式*/
		Targetable target = new Adapter();
		
		target.method1();
		target.method2();
		
		
		
		System.err.println("********对象层面的适配器*******");
		/**2.对象层面的适配器模式*/
		Source source = new Source();
		
		Targetable t1 = new Warrper(source);
		t1.method1();
		t1.method2();
		
		/**3.接口的适配器模式*/
		System.err.println("********接口的适配器**********");
		Sourceable source1 = new SourceSub1();
		Sourceable source2 = new SourceSub2();
		
		source1.method1();
		source1.method2();
		source2.method1();
		source2.method2();
		
		
		
		
	}

}
