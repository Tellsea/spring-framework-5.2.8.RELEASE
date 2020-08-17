package cn.tellsea.designpatterns.adapter;

/**
 * @author Tellsea
 * @date 2020-8-16
 */
public abstract class Adapter implements Target{

    @Override
	public void typec() { }

    @Override
	public void typec2vga() { }

    @Override
	public void typec2hdmi() { }
}
