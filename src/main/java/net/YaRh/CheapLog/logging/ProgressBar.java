package net.YaRh.CheapLog.logging;

import net.YaRh.CheapLog.ansi.CursorControl;
import net.YaRh.CheapLog.ansi.EraseCode;

import java.text.NumberFormat;
import java.util.function.Consumer;

public class ProgressBar {
	
	private static final String FORM = " %s [%s] %s (%s/%s) ";
	
	private final BarType type;
	private final String name;
	
	private final int length;
	
	private int steps;
	private int progress = 0;
	
	public ProgressBar(String name, int length, int steps, BarType type) {
		this.name = name;
		this.length = length;
		this.steps = steps;
		this.type = type;
		
		update();
	}
	/**
	 * Defaults type to {@link BarType#DASH_HASH}
	 */
	public ProgressBar(String name, int length, int steps) {
		this(name, length, steps, BarType.DASH_HASH);
	}
	
	public void updateExpectancy(int amount) {
		this.steps += amount;
		update();
	}
	
	public void step() {
		progress++;
		clamp();
		update();
	}
	public void step(int amount) {
		progress += amount;
		clamp();
		update();
	}
	
	private void clamp() {
		if (progress > steps) this.progress = steps;
	}
	
	/**
	 * Resets all progress
	 */
	public void reset() {
		this.progress = 0;
		update();
	}
	
	private void update() {
		Consumer<String> out = System.out::print;
		
		out.accept(CursorControl.DOWN.with(1));
		out.accept(EraseCode.ENTIRE_LINE.toString());
		
		out.accept(build());
		
		out.accept(CursorControl.UP.with(1));
	}
	
	private String build() {
		int perStep = length / steps;
		int progressLength = progress * perStep;
		int restLength = (steps - progress) * perStep;
		
		String progPrecent = NumberFormat.getPercentInstance()
				.format(((double) progress) / steps);
		String progBar = type.full().repeat(progressLength) + type.empty().repeat(restLength);
		
		return FORM.formatted(name, progBar, progPrecent, progress, steps);
	}
	
	@Override
	public String toString() {
		return "ProgressBar(%d, %d)[%d]".formatted(length, steps, progress);
	}
	
	public enum BarType {
		/**
		 * Uses {@code -} for empty steps and {@code #} for full steps
		 */
		DASH_HASH("-", "#"),
		/**
		 * Uses {@code ~} for empty steps and {@code *} for full steps
		 */
		TILDE_STAR("~", "*"),
		/**
		 * Uses {@code o} for empty steps and {@code @} for full steps
		 */
		O("o", "@"),
		/**
		 * Uses {@code " "} for empty steps and {@code =} for full steps
		 */
		EMPTY_EQUAL(" ", "="),
		/**
		 * Uses {@code ,} for empty steps and {@code '} for full steps
		 */
		COMMA_QUOTE(",", "'"),
		;
		
		private final String empty;
		private final String full;
		
		BarType(String empty, String full) {
			this.empty = empty;
			this.full = full;
		}
		
		@Override
		public String toString() {
			return name() + "[%s/%s]".formatted(empty, full);
		}
		
		public String empty() {
			return empty;
		}
		public String full() {
			return full;
		}
	}
}