package net.YaRh.CheapLog.logging;

import net.YaRh.ConvConf.Switch;

public class Logger {
	
	public final Switch logging = new Switch(true);
	public final Switch information = new Switch(false);
	public final Switch errors = new Switch(true);
	public final Switch warning = new Switch(true);
	public final Switch debugging = new Switch(false);
	
	public final LoggPoint log = new LoggPoint(LogType.LOGGING, logging, "");
	public final LoggPoint info = new LoggPoint(LogType.INFO, information, "");
	public final LoggPoint warn = new LoggPoint(LogType.WARNING, warning, "");
	public final LoggPoint debug = new LoggPoint(LogType.DEBUG, debugging, "");
	public final ErrorLogPoint error = new ErrorLogPoint(errors, "");
	
	public Logger(String id) {
		log.id.set(id);
		info.id.set(id);
		warn.id.set(id);
		debug.id.set(id);
		error.id.set(id);
	}
}