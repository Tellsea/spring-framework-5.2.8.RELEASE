package cn.tellsea.designpatterns.adapter;

/**
 * 对象的适配器模式
 * 原理：通过组合方式来实现适配器功能
 *
 * @author Tellsea
 * @date 2020-8-16
 */
public class Typec2Vga2 implements Vga {

	private Phone phone;

	public Typec2Vga2(Phone phone) {
		// TODO Auto-generated constructor stub
		this.phone = phone;
	}

	@Override
	public void vgaInterface() {
		// TODO Auto-generated method stub
		if (phone != null) {
			phone.typecPhone();
			System.out.println("接收到Type-c口信息，信息转换成VGA接口中...");
			System.out.println("信息已转换成VGA接口，显示屏可以对接。");
		}
	}
}
