package net.YaRh.CheapLog.ansi;

/**
 * Ansi codes that erase lines or the entire screen
 *
 * @since 3.4.0
 */
public enum EraseCode implements AnsiCode {
	/**
	 * Erases from cursor to end of screen
	 */
	SCREEN_END("0J"),
	/**
	 * Erases from cursor to beginning of screen
	 */
	SCREEN_START("1J"),
	/**
	 * Erases the entire screen
	 */
	ENTIRE_SCREEN("2J"),
	
	/**
	 * Erases from cursor to end of line
	 */
	LINE_END("0K"),
	/**
	 * Erases from cursor to start of line
	 */
	LINE_START("1K"),
	/**
	 * Erases the entire line
	 */
	ENTIRE_LINE("2K\r");
	
	private final String code;
	
	EraseCode(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return "\u001B[" + code;
	}
}