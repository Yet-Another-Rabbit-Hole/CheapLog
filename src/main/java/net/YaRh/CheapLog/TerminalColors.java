package net.YaRh.CheapLog;

/**
 * Scancodes that are interpreted by shells
 */
public enum TerminalColors {
	/**
	 * Color code 31
	 */
	RED("\u001B[31m"),
	/**
	 * Color code 32
	 */
	GREEN("\u001B[32m"),
	/**
	 * Color code 33
	 */
	YELLOW("\u001B[33m"),
	/**
	 * Color code 34
	 */
	BLUE("\u001B[34m"),
	/**
	 * Color code 35
	 */
	MAGENTA("\u001B[35m"),
	/**
	 * Color code 36
	 */
	CYAN("\u001B[36m"),
	/**
	 * Color code 37
	 */
	WHITE("\u001B[37m"),
	/**
	 * Color code 0
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