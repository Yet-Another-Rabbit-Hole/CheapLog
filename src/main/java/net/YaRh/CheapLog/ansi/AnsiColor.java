package net.YaRh.CheapLog.ansi;

/**
 * Scancodes that are interpreted by shells
 *
 * @since 1.0.0
 */
public enum AnsiColor implements AnsiCode {
	/**
	 * Color code 31
	 *
	 * @since 1.0.0
	 */
	RED(31),
	/**
	 * Color code 32
	 *
	 * @since 1.0.0
	 */
	GREEN(32),
	/**
	 * Color code 33
	 *
	 * @since 1.0.0
	 */
	YELLOW(33),
	/**
	 * Color code 34
	 *
	 * @since 1.0.0
	 */
	BLUE(34),
	/**
	 * Color code 35
	 *
	 * @since 1.0.0
	 */
	MAGENTA(35),
	/**
	 * Color code 36
	 *
	 * @since 1.0.0
	 */
	CYAN(36),
	/**
	 * Color code 37
	 *
	 * @since 1.0.0
	 */
	WHITE(37),
	/**
	 * Color code 0
	 *
	 * @since 1.0.0
	 */
	RESET(0);
	
	private final int code;
	
	AnsiColor(int code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return "\u001B[%dm".formatted(code);
	}
}