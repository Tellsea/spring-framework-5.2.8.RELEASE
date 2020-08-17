package cn.tellsea.designpatterns.adapter;

/**
 * 接口的适配器模式
 * 原理：借助抽象类来实现适配器功能
 *
 * @author Tellsea
 * @date 2020-8-16
 */
public interface Target {

	void typec();

	void typec2vga();

	void typec2hdmi();
}
