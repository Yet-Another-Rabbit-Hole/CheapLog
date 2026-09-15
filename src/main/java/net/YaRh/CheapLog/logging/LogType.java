package net.YaRh.CheapLog.logging;

import net.YaRh.CheapLog.TerminalColors;

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
	LOGGING(TerminalColors.WHITE),
	/**
	 * Red text
	 *
	 * @since 1.0.0
	 */
	ERROR(TerminalColors.RED),
	/**
	 * Yellow text
	 *
	 * @since 1.0.0
	 */
	WARNING(TerminalColors.YELLOW),
	/**
	 * Blue text
	 *
	 * @since 1.0.0
	 */
	INFO(TerminalColors.BLUE),
	/**
	 * Cyan text
	 *
	 * @since 1.0.0
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