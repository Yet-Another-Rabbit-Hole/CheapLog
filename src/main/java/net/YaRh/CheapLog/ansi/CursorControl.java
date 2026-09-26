package net.YaRh.CheapLog.ansi;

public enum CursorControl implements AnsiCode {
	HOME("[H", false),
	
	UP("[%sA"),
	DOWN("[%sB"),
	RIGHT("[%sC"),
	LEFT("[%sD"),
	
	NEXT_LINE("[%sE"),
	PREV_LINE("[%sF"),
	
	COLUMN("[%sG"),
	
	SAVE("7", false),
	LOAD("8", false);
	
	private final String code;
	private final boolean needsValues;
	
	CursorControl(String code, boolean needsValues) {
		this.code = code;
		this.needsValues = needsValues;
	}
	
	CursorControl(String code) {
		this(code, true);
	}
	
	public String with(int values) {
		String formatted = needsValues ? code.formatted(values) : code;
		return "\u001B" + formatted;
	}
	
	@Override
	public String toString() {
		String formatted = needsValues ? code.formatted(1) : code;
		return "\u001B" + formatted;
	}
}