package net.YaRh.CheapLog.logging;

import net.YaRh.CheapLog.TerminalColors;
import net.YaRh.ConvConf.Attribute;
import net.YaRh.ConvConf.Switch;

import static net.YaRh.CheapLog.Config.*;

/**
 * A simple point that handles logging outputs
 *
 * @since 1.0.0
 */
public class LoggPoint {
	
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
	
	/**
	 * Puts together a string of {@code %s} separated by commas
	 */
	private static String emptyString(int size) {
		String str = "%s, ".repeat(Math.max(0, size));
		return str.substring(0, str.length() - 2);
	}
	
	private final LogType type;
	private final Switch swtch;
	
	/**
	 * @since 2.2.0
	 */
	public final Attribute<String> id = new Attribute<>("Master");
	
	/**
	 * @since 2.2.0
	 */
	public LoggPoint(LogType type, Switch swtch, String id) {
		this.type = type;
		this.swtch = swtch;
		this.id.set(id);
	}
	/**
	 * @since 1.0.0
	 */
	public LoggPoint(LogType pType, Switch pSwitch) {
		this.type = pType;
		this.swtch = pSwitch;
		this.id.immutable();
	}
	
	/**
	 * @since 1.0.0
	 */
	public void println(String msg) {
		if (!swtch.get()) return;
		fullLineOutput.get().accept(decoration() + msg + defaultColor.get());
	}
	/**
	 * @since 1.0.0
	 */
	public void println(String msg, Object... args) {
		if (!swtch.get()) return;
		fullLineOutput.get().accept(decoration() + msg.formatted(args) + defaultColor.get());
	}
	/**
	 * @since 2.1.0
	 */
	public void println(Object... args) {
		if (!swtch.get()) return;
		fullLineOutput.get().accept(decoration() + emptyString(args.length).formatted(args) + defaultColor.get());
	}
	
	/**
	 * @since 1.0.0
	 */
	public void print(String msg) {
		if (!swtch.get()) return;
		inLineOutput.get().accept(decoration() + msg + defaultColor.get());
	}
	/**
	 * @since 1.0.0
	 */
	public void print(String msg, Object... args) {
		if (!swtch.get()) return;
		inLineOutput.get().accept(decoration() + msg.formatted(args) + defaultColor.get());
	}
	/**
	 * @since 2.1.0
	 */
	public void print(Object... args) {
		if (!swtch.get()) return;
		inLineOutput.get().accept(decoration() + emptyString(args.length).formatted(args) + defaultColor.get());
	}
	
	/**
	 * @since 1.0.0
	 */
	private String decoration() {
		return TerminalColors.RESET + location() + type.color() + thread() + name() + "[" + type.name() + "] ";
	}
	
	/**
	 * @since 2.2.0
	 */
	private String name() {
		if (!ids.get()) return "";
		if (id.get().isBlank()) return "";
		return "[" + id.get() + "] ";
	}
}