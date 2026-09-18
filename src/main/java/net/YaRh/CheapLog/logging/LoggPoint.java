package net.YaRh.CheapLog.logging;

import net.YaRh.CheapLog.Config;
import net.YaRh.CheapLog.TerminalColors;
import net.YaRh.ConvConf.Attribute;
import net.YaRh.ConvConf.OverridableDefault;
import net.YaRh.ConvConf.Switch;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static net.YaRh.CheapLog.Config.*;

/**
 * A simple point that handles logging outputs
 *
 * @since 1.0.0
 */
public class LoggPoint {
	
	/**
	 * @since 3.2.0
	 */
	private static final List<LoggPoint> logPoints = new ArrayList<>();
	
	/**
	 * Exposed core, do not use.
	 *
	 * @since 3.2.0
	 */
	public static void changeDefaultFLO(Consumer<String> newDefault) {
		logPoints.forEach(l -> l.fullLineOutput.updater().accept(newDefault));
	}
	
	/**
	 * Exposed core, do not use.
	 *
	 * @since 3.2.0
	 */
	public static void changeDefaultILO(Consumer<String> newDefault) {
		logPoints.forEach(l -> l.inLineOutput.updater().accept(newDefault));
	}
	
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
	
	public final OverridableDefault<Consumer<String>> fullLineOutput = new OverridableDefault<>(Config.fullLineOutput.get());
	public final OverridableDefault<Consumer<String>> inLineOutput = new OverridableDefault<>(Config.inLineOutput.get());
	
	/**
	 * @since 2.2.0
	 */
	public final Attribute<String> id = new Attribute<>();
	
	/**
	 * @since 2.2.0
	 */
	public LoggPoint(LogType type, Switch pSwitch, String id) {
		this.type = type;
		this.swtch = pSwitch;
		this.id.set(id);
		this.id.immutable();
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
	 * A {@link LoggPoint} initialised like this will always logg
	 *
	 * @since 3.2.0
	 */
	public LoggPoint(LogType pType) {
		this.type = pType;
		this.swtch = new Switch(true);
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
		return TerminalColors.RESET + location() + color() + thread() + id() + "[" + type.name() + "] ";
	}
	
	/**
	 * @since 2.2.0
	 */
	private String id() {
		if (!ids.get() || id.get() == null) return "";
		return "[" + id.get() + "] ";
	}
	
	/**
	 * @since 3.2.0
	 */
	private String color() {
		if (!color.get()) return "";
		return type.color().toString();
	}
}