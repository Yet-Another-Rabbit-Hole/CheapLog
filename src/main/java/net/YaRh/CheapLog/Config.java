package net.YaRh.CheapLog;

import net.YaRh.CheapLog.ansi.AnsiColor;
import net.YaRh.CheapLog.logging.LoggPoint;
import net.YaRh.ConvConf.Attribute;
import net.YaRh.ConvConf.Switch;
import net.YaRh.ConvConf.SwitchBox;

import java.util.function.Consumer;

/**
 * Config for which types of logs should actually be displayed
 * <p>
 * Every output is disabled by default
 */
public final class Config {
	
	private static final SwitchBox switches = new SwitchBox();
	
	public static final Switch logging = switches.add(true);
	public static final Switch information = switches.add(false);
	public static final Switch errors = switches.add(true);
	public static final Switch warning = switches.add(true);
	public static final Switch debugging = switches.add(false);
	
	/**
	 * Determines if the log should include the location of the logging call
	 */
	public static final Switch location = switches.add(false);
	
	/**
	 * Determines if the log should include the thread of the logging call
	 */
	public static final Switch thread = switches.add(false);
	
	/**
	 * Determines if the log should include the id of the Logger
	 */
	public static final Switch ids = switches.add(false);
	
	/**
	 * Determines if the log should be colored.
	 * <p>
	 * Disable if your terminal does not support color.
	 *
	 * @since 3.2.0
	 */
	public static final Switch color = new Switch(true);
	
	public static final Attribute<Consumer<String>> fullLineOutput =
			new Attribute<>(System.out::println, LoggPoint::changeDefaultFLO);
	public static final Attribute<Consumer<String>> inLineOutput =
			new Attribute<>(System.out::print, LoggPoint::changeDefaultILO);
	/**
	 * {@linkplain AnsiColor Color} that is restored after each log output
	 *
	 * @since 2.2.0
	 */
	public static final Attribute<AnsiColor> defaultColor = new Attribute<>(AnsiColor.RESET);
	
	public static void enableAll() {
		switches.enableAll();
	}
	public static void disableAll() {
		switches.disableAll();
	}
	public static boolean allSet() {
		return switches.allSet();
	}
	public static void setAll(boolean pValue) {
		switches.setAll(pValue);
	}
	public static void toggleAll() {
		switches.toggleAll();
	}
}