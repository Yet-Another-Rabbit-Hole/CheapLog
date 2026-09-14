package net.YaRh.CheapLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Config for which types of logs should actually be displayed
 * <p>
 * Every output is disabled by default
 */
public final class Config {
	
	/**
	 * A helper class for config switches for easier access
	 */
	public static final class Switch {
		
		private static final List<Switch> switches = new ArrayList<>();
		
		private static void add(Switch pSwitch) {
			switches.add(pSwitch);
		}
		
		public static void enableAll() {
			switches.forEach(Switch::enable);
		}
		public static void disableAll() {
			switches.forEach(Switch::disable);
		}
		
		public static void setAll(boolean pValue) {
			switches.forEach(swtch -> swtch.set(pValue));
		}
		
		public static void toggleAll() {
			switches.forEach(Switch::toggle);
		}
		
		public static boolean areAllActive() {
			return switches.stream().allMatch(Switch::isActive);
		}
		
		private boolean value = false;
		
		/**
		 * The default is always set to {@code false}
		 */
		public Switch() {
			Switch.add(this);
		}
		public Switch(boolean pDefault) {
			this.value = pDefault;
			Switch.add(this);
		}
		
		public void enable() {
			this.value = true;
		}
		public void disable() {
			this.value = false;
		}
		
		public void set(boolean pValue) {
			this.value = pValue;
		}
		
		public boolean toggle() {
			this.value = !value;
			return value;
		}
		
		public boolean isActive() {
			return value;
		}
	}
	
	public static Switch logging = new Switch(true);
	public static Switch information = new Switch(false);
	public static Switch errors = new Switch(true);
	public static Switch warning = new Switch(true);
	public static Switch debugging = new Switch(false);
	
	/**
	 * Determines if the log should include the location of the logging call
	 */
	public static Switch location = new Switch(false);
	
	/**
	 * Determines if the log should include the thread of the logging call
	 */
	public static Switch thread = new Switch(false);
	
	public static void enableAll() {
		Switch.enableAll();
	}
	public static void disableAll() {
		Switch.disableAll();
	}
	public static void toggleAll() {
		Switch.toggleAll();
	}
	public static boolean allEnabled() {
		return Switch.areAllActive();
	}
}