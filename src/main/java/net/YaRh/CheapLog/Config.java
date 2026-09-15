package net.YaRh.CheapLog;

import net.YaRh.ConvConf.Attribute;
import net.YaRh.ConvConf.Switch;

import java.util.function.Consumer;

/**
 * Config for which types of logs should actually be displayed
 * <p>
 * Every output is disabled by default
 */
public final class Config {
	
	public static Switch logging = new Switch(true);
	public static Switch information = new Switch(false);
	public static Switch errors = new Switch(true);
	public static Switch warning = new Switch(true);
	public static Switch debugging = new Switch(false);
	
	/**
	 * Determines if the log should include the location of the logging call
	 */
	public static Switch location = new Switch(false);
	
	/**
	 * Determines if the log should include the thread of the logging call
	 */
	public static Switch thread = new Switch(false);
	
	public static Attribute<Consumer<String>> fullLineOutput = new Attribute<>(System.out::println, false);
	public static Attribute<Consumer<String>> inLineOutput = new Attribute<>(System.out::print, false);
	
	public static void enableAll() {
		Switch.enableAll();
	}
	public static void disableAll() {
		Switch.disableAll();
	}
	public static void toggleAll() {
		Switch.toggleAll();
	}
	public static boolean allEnabled() {
		return Switch.areAllActive();
	}
}