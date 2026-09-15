package net.YaRh.CheapLog;

/**
 * Scancodes that are interpreted by shells
 *
 * @since 1.0.0
 */
public enum TerminalColors {
	/**
	 * Color code 31
	 *
	 * @since 1.0.0
	 */
	RED("\u001B[31m"),
	/**
	 * Color code 32
	 *
	 * @since 1.0.0
	 */
	GREEN("\u001B[32m"),
	/**
	 * Color code 33
	 *
	 * @since 1.0.0
	 */
	YELLOW("\u001B[33m"),
	/**
	 * Color code 34
	 *
	 * @since 1.0.0
	 */
	BLUE("\u001B[34m"),
	/**
	 * Color code 35
	 *
	 * @since 1.0.0
	 */
	MAGENTA("\u001B[35m"),
	/**
	 * Color code 36
	 *
	 * @since 1.0.0
	 */
	CYAN("\u001B[36m"),
	/**
	 * Color code 37
	 *
	 * @since 1.0.0
	 */
	WHITE("\u001B[37m"),
	/**
	 * Color code 0
	 *
	 * @since 1.0.0
	 */
	RESET("\u001B[0m");
	
	private final String code;
	
	TerminalColors(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return code;
	}
}