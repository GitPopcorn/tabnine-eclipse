package com.tabnine.eclipse.util;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;

import com.tabnine.eclipse.Activator;

public class TabNineLoggingUtils {
	
	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Variables] ===== ===== ===== ===== //
	
	/** The logger of current plug-in : ILog log */
	private static ILog log = null;
	
	static {
		// STEP Number Try to initialize the logger of current plugin
		try {
			// SUBSTEP Number Get logger from activator
			log = Activator.getDefault().getLog();
			
		} catch (Exception e) {
			// SUBSTEP Number If failed, mount a empty logger
			log = new ILog() {
				
				@Override
				public void removeLogListener(ILogListener arg0) {
					// Do nothing
					
				}
				
				@Override
				public void log(IStatus arg0) {
					System.out.println(arg0.getMessage());
					
				}
				
				@Override
				public Bundle getBundle() {
					// Do nothing
					return null;
					
				}
				
				@Override
				public void addLogListener(ILogListener arg0) {
					// Do nothing
					
				}
			};
			
		}
		
	}
	
	// ===== ===== ===== ===== [Entry Method (For test only)] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Test Methods] ===== ===== ===== ===== //

	
	// ===== ===== ===== ===== [Instance Variables] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Instance Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Basic API Methods - DEBUG] ===== ===== ===== ===== //
	
	/**
	 * Print logs with DEBUG level
	 * @param message The log message
	 * @author ZhouYi
	 * @date 2020-01-06 17:26:21
	 * @description description
	 * @note note
	 */
	public static void debug(String message) {
		System.out.println(message);
		
	}
	
	/**
	 * Print logs with DEBUG level
	 * @param message The log message
	 * @param code The custom status code
	 * @author ZhouYi
	 * @date 2020-01-06 17:26:21
	 * @description description
	 * @note note
	 */
	public static void debug(String message, int code) {
		System.out.println("[" + code + "]" + message);
		
	}
	
	/**
	 * Print logs with DEBUG level
	 * @param message The log message
	 * @param code The custom status code
	 * @param exception A exception to record in log, or null if not applicable
	 * @author ZhouYi
	 * @date 2020-01-06 17:26:21
	 * @description description
	 * @note note
	 */
	public static void debug(String message, int code, Throwable exception) {
		System.out.println("[" + code + "]" + message);
		exception.printStackTrace();
		
	}
	
	// ===== ===== ===== ===== [Basic API Methods - INFO] ===== ===== ===== ===== //
	
	/**
	 * Print logs with INFO level
	 * @param message The log message
	 * @author ZhouYi
	 * @date 2020-01-06 17:26:21
	 * @description description
	 * @note note
	 */
	public static void info(String message) {
		log.log(new Status(Status.INFO, Activator.PLUGIN_ID, 0, message, null));
		
	}
	
	/**
	 * Print logs with INFO level
	 * @param message The log message
	 * @param code The custom status code
	 * @author ZhouYi
	 * @date 2020-01-06 17:26:21
	 * @description description
	 * @note note
	 */
	public static void info(String message, int code) {
		log.log(new Status(Status.INFO, Activator.PLUGIN_ID, code, message, null));
		
	}
	
	/**
	 * Print logs with INFO level
	 * @param message The log message
	 * @param code The custom status code
	 * @param exception A exception to record in log, or null if not applicable
	 * @author ZhouYi
	 * @date 2020-01-06 17:26:21
	 * @description description
	 * @note note
	 */
	public static void info(String message, int code, Throwable exception) {
		log.log(new Status(Status.INFO, Activator.PLUGIN_ID, code, message, exception));
		
	}
	
	// ===== ===== ===== ===== [Basic API Methods - WARNING] ===== ===== ===== ===== //
	
	/**
	 * Print logs with WARNING level
	 * @param message The log message
	 * @author ZhouYi
	 * @date 2020-01-06 17:26:21
	 * @description description
	 * @note note
	 */
	public static void warning(String message) {
		log.log(new Status(Status.WARNING, Activator.PLUGIN_ID, 0, message, null));
		
	}
	
	/**
	 * Print logs with WARNING level
	 * @param message The log message
	 * @param code The custom status code
	 * @author ZhouYi
	 * @date 2020-01-06 17:26:21
	 * @description description
	 * @note note
	 */
	public static void warning(String message, int code) {
		log.log(new Status(Status.WARNING, Activator.PLUGIN_ID, code, message, null));
		
	}
	
	/**
	 * Print logs with WARNING level
	 * @param message The log message
	 * @param code The custom status code
	 * @param exception A exception to record in log, or null if not applicable
	 * @author ZhouYi
	 * @date 2020-01-06 17:26:21
	 * @description description
	 * @note note
	 */
	public static void warning(String message, int code, Throwable exception) {
		log.log(new Status(Status.WARNING, Activator.PLUGIN_ID, code, message, exception));
		
	}
	
	// ===== ===== ===== ===== [Basic API Methods - ERROR] ===== ===== ===== ===== //
	
	/**
	 * Print logs with ERROR level
	 * @param message The log message
	 * @author ZhouYi
	 * @date 2020-01-06 17:26:21
	 * @description description
	 * @note note
	 */
	public static void error(String message) {
		log.log(new Status(Status.ERROR, Activator.PLUGIN_ID, 0, message, null));
		
	}
	
	/**
	 * Print logs with ERROR level
	 * @param message The log message
	 * @param exception A exception to record in log, or null if not applicable
	 * @author ZhouYi
	 * @date 2020-01-06 17:26:21
	 * @description description
	 * @note note
	 */
	public static void error(String message, Throwable exception) {
		log.log(new Status(Status.ERROR, Activator.PLUGIN_ID, 0, message, exception));
		
	}
	
	/**
	 * Print logs with ERROR level
	 * @param message The log message
	 * @param code The custom status code
	 * @author ZhouYi
	 * @date 2020-01-06 17:26:21
	 * @description description
	 * @note note
	 */
	public static void error(String message, int code) {
		log.log(new Status(Status.ERROR, Activator.PLUGIN_ID, code, message, null));
		
	}
	
	/**
	 * Print logs with ERROR level
	 * @param message The log message
	 * @param code The custom status code
	 * @param exception A exception to record in log, or null if not applicable
	 * @author ZhouYi
	 * @date 2020-01-06 17:26:21
	 * @description description
	 * @note note
	 */
	public static void error(String message, int code, Throwable exception) {
		log.log(new Status(Status.ERROR, Activator.PLUGIN_ID, code, message, exception));
		
	}
	
	// ===== ===== ===== ===== [Basic API Methods - OK] ===== ===== ===== ===== //
	
	/**
	 * Print logs with OK level
	 * @param message The log message
	 * @author ZhouYi
	 * @date 2020-01-06 17:26:21
	 * @description description
	 * @note note
	 */
	public static void ok(String message) {
		log.log(new Status(Status.OK, Activator.PLUGIN_ID, 0, message, null));
		
	}
	
	/**
	 * Print logs with OK level
	 * @param message The log message
	 * @param code The custom status code
	 * @author ZhouYi
	 * @date 2020-01-06 17:26:21
	 * @description description
	 * @note note
	 */
	public static void ok(String message, int code) {
		log.log(new Status(Status.OK, Activator.PLUGIN_ID, code, message, null));
		
	}
	
	/**
	 * Print logs with OK level
	 * @param message The log message
	 * @param code The custom status code
	 * @param exception A exception to record in log, or null if not applicable
	 * @author ZhouYi
	 * @date 2020-01-06 17:26:21
	 * @description description
	 * @note note
	 */
	public static void ok(String message, int code, Throwable exception) {
		log.log(new Status(Status.OK, Activator.PLUGIN_ID, code, message, exception));
		
	}
	
	// ===== ===== ===== ===== [Basic API Methods - CANCEL] ===== ===== ===== ===== //
	
	/**
	 * Print logs with CANCEL level
	 * @param message The log message
	 * @author ZhouYi
	 * @date 2020-01-06 17:26:21
	 * @description description
	 * @note note
	 */
	public static void cancel(String message) {
		log.log(new Status(Status.CANCEL, Activator.PLUGIN_ID, 0, message, null));
		
	}
	
	/**
	 * Print logs with CANCEL level
	 * @param message The log message
	 * @param code The custom status code
	 * @author ZhouYi
	 * @date 2020-01-06 17:26:21
	 * @description description
	 * @note note
	 */
	public static void cancel(String message, int code) {
		log.log(new Status(Status.CANCEL, Activator.PLUGIN_ID, code, message, null));
		
	}
	
	/**
	 * Print logs with CANCEL level
	 * @param message The log message
	 * @param code The custom status code
	 * @param exception A exception to record in log, or null if not applicable
	 * @author ZhouYi
	 * @date 2020-01-06 17:26:21
	 * @description description
	 * @note note
	 */
	public static void cancel(String message, int code, Throwable exception) {
		log.log(new Status(Status.CANCEL, Activator.PLUGIN_ID, code, message, exception));
		
	}
	
	// ===== ===== ===== ===== [Instance Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Utility Methods - Utility] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Constructors] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Static Factory Methods] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [Getters & Setters] ===== ===== ===== ===== //
	
	
	// ===== ===== ===== ===== [SplitLineTitle] ===== ===== ===== ===== //
	
}
