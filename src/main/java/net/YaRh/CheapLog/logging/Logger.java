package net.YaRh.CheapLog.logging;

import net.YaRh.ConvConf.Switch;
import net.YaRh.ConvConf.SwitchBox;

import java.util.function.Consumer;

/**
 * @since 2.2.0
 */
public class Logger {
	
	private final SwitchBox switches = new SwitchBox();
	
	public final Switch logging = switches.add(true);
	public final Switch information = switches.add(false);
	public final Switch errors = switches.add(true);
	public final Switch warning = switches.add(true);
	public final Switch debugging = switches.add(false);
	
	public final LoggPoint log;
	public final LoggPoint info;
	public final LoggPoint warn;
	public final LoggPoint debug;
	public final ErrorLogPoint error;
	
	public Logger(String id) {
		log = new LoggPoint(LogType.LOGGING, logging, id);
		info = new LoggPoint(LogType.INFO, information, id);
		warn = new LoggPoint(LogType.WARNING, warning, id);
		debug = new LoggPoint(LogType.DEBUG, debugging, id);
		error = new ErrorLogPoint(errors, id);
	}
	
	/**
	 * @since 3.0.0
	 */
	public void enable() {
		switches.enableAll();
	}
	
	/**
	 * @since 3.0.0
	 */
	public void disable() {
		switches.disableAll();
	}
	
	/**
	 * @since 3.2.0
	 */
	public void setFullLineOutputs(Consumer<String> FLO) {
		log.fullLineOutput.set(FLO);
		info.fullLineOutput.set(FLO);
		warn.fullLineOutput.set(FLO);
		debug.fullLineOutput.set(FLO);
		error.fullLineOutput.set(FLO);
	}
	
	/**
	 * @since 3.2.0
	 */
	public void setInLineOutputs(Consumer<String> ILO) {
		log.inLineOutput.set(ILO);
		info.inLineOutput.set(ILO);
		warn.inLineOutput.set(ILO);
		debug.inLineOutput.set(ILO);
		error.inLineOutput.set(ILO);
	}
}