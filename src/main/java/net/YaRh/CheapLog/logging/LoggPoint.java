package net.YaRh.CheapLog.logging;

import net.YaRh.CheapLog.TerminalColors;
import net.YaRh.ConvConf.Attribute;
import net.YaRh.ConvConf.Switch;

import static net.YaRh.CheapLog.Config.*;
import static net.YaRh.CheapLog.Config.fullLineOutput;
import static net.YaRh.CheapLog.Config.inLineOutput;

/**
 * A simple point that handles logging outputs
 *
 * @since 1.0.0
 */
public class LoggPoint {
	
	/**
	 * {@linkplain TerminalColors color} that is restored after each log output
	 */
	private static final Attribute<TerminalColors> defaultColor = new Attribute<>(TerminalColors.RESET, false);
	
	/**
	 * @since 1.0.0
	 */
	private static String location() {
		if (!location.get()) return "";
		
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
	
	/**
	 * @since 1.0.0
	 */
	private static String thread() {
		if (!thread.get()) return "";
		
		Thread thread = Thread.currentThread();
		
		return "[%s:%d] ".formatted(
				thread.getName(),
				thread.getId()
		);
	}
	
	private final LogType type;
	private final Switch swtch;
	
	/**
	 * @since 1.0.0
	 */
	public LoggPoint(LogType pType, Switch pSwitch) {
		this.type = pType;
		this.swtch = pSwitch;
	}
	
	/**
	 * @since 1.0.0
	 */
	public void println(String msg) {
		if (swtch.get()) fullLineOutput.get().accept(decoration() + msg + defaultColor.get());
	}
	/**
	 * @since 1.0.0
	 */
	public void println(String msg, Object... args) {
		if (swtch.get()) fullLineOutput.get().accept(decoration() + msg.formatted(args) + defaultColor.get());
	}
	/**
	 * @since 2.1.0
	 */
	public void println(Object... args) {
		if (swtch.get()) fullLineOutput.get().accept(decoration() + "".formatted(args) + defaultColor.get());
	}
	
	/**
	 * @since 1.0.0
	 */
	public void print(String msg) {
		if (swtch.get()) inLineOutput.get().accept(decoration() + msg + defaultColor.get());
	}
	/**
	 * @since 1.0.0
	 */
	public void print(String msg, Object... args) {
		if (swtch.get()) inLineOutput.get().accept(decoration() + msg.formatted(args) + defaultColor.get());
	}
	/**
	 * @since 2.1.0
	 */
	public void print(Object... args) {
		if (swtch.get()) inLineOutput.get().accept(decoration() + "".formatted(args) + defaultColor.get());
	}
	
	/**
	 * @since 1.0.0
	 */
	private String decoration() {
		return TerminalColors.RESET + location() + type.color() + thread() + "[" + type.name() + "] ";
	}
}