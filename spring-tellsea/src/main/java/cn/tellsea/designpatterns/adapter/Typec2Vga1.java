package cn.tellsea.designpatterns.adapter;

/**
 * 类的适配器模式
 * 原理：通过继承特性来实现适配器功能
 *
 * @author Tellsea
 * @date 2020-8-16
 */
public class Typec2Vga1 extends Phone implements Vga {

	@Override
	public void vgaInterface() {
		typecPhone();
		System.out.println("接收到Type-c口信息，信息转换成VGA接口中...");
		System.out.println("信息已转换成VGA接口，显示屏可以对接。");
	}
}
