package cn.tellsea.designpatterns.adapter;

/**
 *
 * @author Tellsea
 * @date 2020-8-16
 */
public class VgaAdapter extends Adapter{

    @Override
	public void typec() {
        System.out.println("信息从Typec口的手机输出。");
    }

    @Override
	public void typec2vga() {
        System.out.println("接收到Type-c口信息，信息转换成VGA接口中...");
        System.out.println("信息已转换成VGA接口，显示屏可以对接。");
    }
}
