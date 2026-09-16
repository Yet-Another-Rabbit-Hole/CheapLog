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
	
	public static final Switch logging = new Switch(true);
	public static final Switch information = new Switch(false);
	public static final Switch errors = new Switch(true);
	public static final Switch warning = new Switch(true);
	public static final Switch debugging = new Switch(false);
	
	/**
	 * Determines if the log should include the location of the logging call
	 */
	public static final Switch location = new Switch(false);
	
	/**
	 * Determines if the log should include the thread of the logging call
	 */
	public static final Switch thread = new Switch(false);
	
	/**
	 * Determines if the log should include the id of the Logger
	 */
	public static final Switch ids = new Switch(false);
	
	public static final Attribute<Consumer<String>> fullLineOutput = new Attribute<>(System.out::println);
	public static final Attribute<Consumer<String>> inLineOutput = new Attribute<>(System.out::print);
	/**
	 * {@linkplain TerminalColors Color} that is restored after each log output
	 *
	 * @since 2.2.0
	 */
	public static final Attribute<TerminalColors> defaultColor = new Attribute<>(TerminalColors.RESET);
	
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
		return Switch.allSet();
	}
}