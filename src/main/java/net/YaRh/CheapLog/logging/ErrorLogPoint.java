package net.YaRh.CheapLog.logging;

import net.YaRh.ConvConf.Switch;

/**
 * A logpoint specifically for errors
 *
 * @since 1.0.0
 */
public final class ErrorLogPoint extends LoggPoint {
	/**
	 * @since 1.0.0
	 */
	public ErrorLogPoint(LogType pType, Switch pSwitch) {
		super(pType, pSwitch);
	}
	
	/**
	 * @since 2.1.0
	 */
	public ErrorLogPoint(Switch pSwitch) {
		super(LogType.ERROR, pSwitch);
	}
	
	/**
	 * @since 1.0.0
	 */
	public void println(String msg, Throwable pError) {
		super.println(msg);
		String errMsg = pError.getMessage() + ", " + pError.getCause();
		super.println(errMsg);
		pError.printStackTrace();
	}
	/**
	 * @since 2.1.0
	 */
	public void println(Throwable pError) {
		String errMsg = pError.getMessage() + ", " + pError.getCause();
		super.println(errMsg);
		pError.printStackTrace();
	}
	public void println(Throwable pError, Object... args) {
		super.println(args);
		String errMsg = pError.getMessage() + ", " + pError.getCause();
		super.println(errMsg);
		pError.printStackTrace();
	}
	/**
	 * @since 2.1.0
	 */
	public void println(String msg, Throwable pError, Object... args) {
		super.println(msg, args);
		String errMsg = pError.getMessage() + ", " + pError.getCause();
		super.println(errMsg);
		pError.printStackTrace();
	}
	
	public void print(String msg, Throwable pError) {
		super.print(msg);
		String errMsg = pError.getMessage() + ", " + pError.getCause();
		super.print(errMsg);
		pError.printStackTrace();
	}
	/**
	 * @since 2.1.0
	 */
	public void print(Throwable pError) {
		String errMsg = pError.getMessage() + ", " + pError.getCause();
		super.print(errMsg);
		pError.printStackTrace();
	}
	public void print(String msg, Throwable pError, Object... args) {
		super.print(msg, args);
		String errMsg = pError.getMessage() + ", " + pError.getCause();
		super.print(errMsg);
		pError.printStackTrace();
	}
	/**
	 * @since 2.1.0
	 */
	public void print(Throwable pError, Object... args) {
		super.print(args);
		String errMsg = pError.getMessage() + ", " + pError.getCause();
		super.print(errMsg);
		pError.printStackTrace();
	}
}