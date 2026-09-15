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