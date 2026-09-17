package net.YaRh.CheapLog;

import net.YaRh.CheapLog.logging.ErrorLogPoint;
import net.YaRh.CheapLog.logging.LogType;
import net.YaRh.CheapLog.logging.LoggPoint;

import static net.YaRh.CheapLog.Config.*;

public final class Logging {
	
	public static final LoggPoint log = new LoggPoint(LogType.LOGGING, logging);
	public static final LoggPoint info = new LoggPoint(LogType.INFO, information);
	public static final LoggPoint warn = new LoggPoint(LogType.WARNING, warning);
	public static final LoggPoint debug = new LoggPoint(LogType.DEBUG, debugging);
	public static final ErrorLogPoint error = new ErrorLogPoint(errors);
	
}