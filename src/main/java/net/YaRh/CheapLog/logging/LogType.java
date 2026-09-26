package net.YaRh.CheapLog.logging;

import net.YaRh.CheapLog.ansi.AnsiColor;

/**
 * The type of log output, determines the color and info in {@code [..]} braces
 *
 * @since 1.0.0
 */
public enum LogType{
	/**
	 * Default white text
	 *
	 * @since 1.0.0
	 */
	LOGGING(AnsiColor.WHITE),
	/**
	 * Red text
	 *
	 * @since 1.0.0
	 */
	ERROR(AnsiColor.RED),
	/**
	 * Yellow text
	 *
	 * @since 1.0.0
	 */
	WARNING(AnsiColor.YELLOW),
	/**
	 * Blue text
	 *
	 * @since 1.0.0
	 */
	INFO(AnsiColor.BLUE),
	/**
	 * Cyan text
	 *
	 * @since 1.0.0
	 */
	DEBUG(AnsiColor.CYAN);
	
	private final AnsiColor color;
	
	LogType(AnsiColor color) {
		this.color = color;
	}
	
	/**
	 * Returns the associated color as {@link AnsiColor}
	 */
	public AnsiColor color() {
		return color;
	}
}