package net.YaRh.CheapLog;

import static net.YaRh.CheapLog.Config.*;

public final class Logging {
	
	/**
	 * The type of log output, determines the color and info in {@code [..]} braces
	 */
	public enum LogType{
		/**
		 * Default white text
		 */
		LOGGING(TerminalColors.WHITE),
		/**
		 * Red text
		 */
		ERROR(TerminalColors.RED),
		/**
		 * Yellow text
		 */
		WARNING(TerminalColors.YELLOW),
		/**
		 * Blue text
		 */
		INFO(TerminalColors.BLUE),
		/**
		 * Cyan text
		 */
		DEBUG(TerminalColors.CYAN);
		
		private final TerminalColors color;
		
		LogType(TerminalColors color) {
			this.color = color;
		}
		
		/**
		 * Returns the associated color as {@link TerminalColors}
		 */
		public TerminalColors color() {
			return color;
		}
	}
	
	/**
	 * A simple point that handles logging outputs and configuration
	 */
	public static class LoggPoint {
		
		private static TerminalColors defaultColor = TerminalColors.RESET;
		
		/**
		 * Sets the {@linkplain TerminalColors color} that is restored after each log output
		 */
		public static void setDefaultColor(TerminalColors pColor) {
			defaultColor = pColor;
		}
		
		private static String location() {
			if (!location.isActive()) return "";
			
			StackTraceElement caller = Thread.currentThread().getStackTrace()[4];
			
			String className = caller.getClassName();
			className = className.substring(className.lastIndexOf('.') + 1);
			
			return "%s.%s(%s:%d) ".formatted(
					className,
					caller.getMethodName(),
					caller.getFileName(),
					caller.getLineNumber()
			);
		}
		
		private static String thread() {
			if (!thread.isActive()) return "";
			
			Thread thread = Thread.currentThread();
			
			return "[%s:%d] ".formatted(
					thread.getName(),
					thread.getId()
			);
		}
		
		private final LogType type;
		private final Switch swtch;
		
		public LoggPoint(LogType pType, Switch pSwitch) {
			this.type = pType;
			this.swtch = pSwitch;
		}
		
		public void println(String msg) {
			if (swtch.isActive()) fullLineOutput.get().accept(decoration() + msg + defaultColor);
		}
		public void println(String msg, Object... args) {
			if (swtch.isActive()) fullLineOutput.get().accept(decoration() + msg.formatted(args) + defaultColor);
		}
		
		public void print(String msg) {
			if (swtch.isActive()) inLineOutput.get().accept(decoration() + msg + defaultColor);
		}
		public void print(String msg, Object... args) {
			if (swtch.isActive()) inLineOutput.get().accept(decoration() + msg.formatted(args) + defaultColor);
		}
		
		private String decoration() {
			return TerminalColors.RESET + location() + type.color() + thread() + "[" + type.name() + "] ";
		}
	}
	
	/**
	 * A logpoint specifically for errors
	 */
	public static final class ErrorLogPoint extends LoggPoint {
		public ErrorLogPoint(LogType pType, Switch pSwitch) {
			super(pType, pSwitch);
		}
		
		public void println(String msg, Throwable pError) {
			super.println(msg);
			String errMsg = pError.getMessage() + ", " + pError.getCause();
			super.println(errMsg);
			pError.printStackTrace();
		}
		
		public void println(String msg, Throwable pError, Object... args) {
			super.println(msg, args);
			String errMsg = pError.getMessage() + ", " + pError.getCause();
			super.println(errMsg);
			pError.printStackTrace();
		}
		
		public void print(String msg, Throwable pError) {
			super.print(msg);
			String errMsg = pError.getMessage() + ", " + pError.getCause();
			super.print(errMsg);
			pError.printStackTrace();
		}
		
		public void print(String msg, Throwable pError, Object... args) {
			super.print(msg, args);
			String errMsg = pError.getMessage() + ", " + pError.getCause();
			super.print(errMsg);
			pError.printStackTrace();
		}
	}
	
	public static final LoggPoint log = new LoggPoint(LogType.LOGGING, logging);
	public static final LoggPoint info = new LoggPoint(LogType.INFO, information);
	public static final LoggPoint warn = new LoggPoint(LogType.WARNING, warning);
	public static final LoggPoint debug = new LoggPoint(LogType.DEBUG, debugging);
	public static final ErrorLogPoint error = new ErrorLogPoint(LogType.ERROR, errors);
}