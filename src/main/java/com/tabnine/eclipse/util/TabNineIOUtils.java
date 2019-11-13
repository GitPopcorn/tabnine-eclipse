package com.tabnine.eclipse.util;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.tabnine.eclipse.exception.TabNineApplicationException;

/**
 * The IOUtils used in this project (The "TabNine" prefix is just for distinguishing)
 * @author ZhouYi
 * @version version
 * @date 2019-10-29 12:13:29
 * @description description
 */
public class TabNineIOUtils {

	// ===== ===== ===== ===== [Constants] ===== ===== ===== ===== //
	
	/** Default buffer size : int DEFUALT_BUFFER_SIZE */
	private static final int DEFUALT_BUFFER_SIZE = 4096;
	
	/** Charset Name - Default charset name : String DEFAULT_CHARSET_NAME */
	public static final String DEFAULT_CHARSET_NAME = "UTF-8";
	
	// ===== ===== ===== ===== [Static Variables] ===== ===== ===== ===== //
	
	
	
	// ===== ===== ===== ===== [Entry Method (For test only)] ===== ===== ===== ===== //
	
	public static void main(String[] args) {
		testEfficiencyOfUrlConnection();
		
	}
	
	// ===== ===== ===== ===== [Test Methods] ===== ===== ===== ===== //
	
	public static void testEfficiencyOfUrlConnection() {
		// STEP Number Declare test variables
		int loopCount = 10;
		long start = 0L;
		long end = 0L;
		String urlPath = "https://update.tabnine.com/version";
		
		// STEP Number Test {@link #doGet(String, String)}
		for (int i = 0; i < loopCount; i++) {
			start = System.currentTimeMillis();
			
			System.out.println(doGet(urlPath, null));
			
			end = System.currentTimeMillis();
			System.out.println(end - start);
			
		}
		
		// STEP Number Pring separated empty line
		System.out.println();
		System.out.println();
		
		// STEP Number Test Original {@link URLConnection}
		try {
			for (int i = 0; i < loopCount; i++) {
				start = System.currentTimeMillis();
				
				URLConnection connection = new URL(urlPath).openConnection();
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String line = null;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
					
				}
				
				end = System.currentTimeMillis();
				System.out.println(end - start);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	// ===== ===== ===== ===== [Static Utility Methods - Stream Application] ===== ===== ===== ===== //
	
	/**
	 * Close the {@link Closeable} resource if it is not null
	 * @param resource The resource to be close
	 * @author ZhouYi
	 * @date 2019-10-29 下午 18:41:38
	 * @description description
	 * @note note
	 */
	public static void safelyClose(Closeable resource) {
		if (resource != null) {
			try {
				resource.close();
				
			} catch (IOException e) {
				System.err.println("Fail to close IO resource");
				
			}
			
		}
		
	}
	
	/**
	 * Copy bytes form input to output
	 * @see org.apache.commons.io.IOUtils
	 * @param input The {@link InputStream} to read from
	 * @param output The {@link OutputStream} to write to
	 * @param buffer The byte array as a buffer
	 * @return
	 * @throws IOException
	 * @author ZhouYi
	 * @since version
	 * @date 2019-10-29 12:23:49
	 * @description description
	 */
	public static long copy(final InputStream input, final OutputStream output, final byte[] buffer) throws IOException {
		// STEP Number Declare variables
		long count = 0; // The total count of copied bytes and method returns 
		int n; // Temporary count number of each cycle
		
		// STEP Number Copy bytes circularly
		while (-1 != (n = input.read(buffer))) {
		    output.write(buffer, 0, n);
		    count += n;
		}
		
		// STEP Number Return the count
		return count;
		
    }
	
	/**
	 * Copy text form input to output
	 * @see org.apache.commons.io.IOUtils
	 * @param input The {@link InputStream} to read from
	 * @param output The {@link OutputStream} to write to
	 * @param buffer The byte array as a buffer
	 * @return
	 * @throws IOException
	 * @author ZhouYi
	 * @since version
	 * @date 2019-10-29 12:23:49
	 * @description description
	 */
	public static long copy(final Reader reader, final Writer writer, final char[] buffer) throws IOException {
		// STEP Number Declare variables
		long count = 0; // The total count of copied bytes and method returns 
		int n; // Temporary count number of each cycle
		
		// STEP Number Copy bytes circularly
		while (-1 != (n = reader.read(buffer))) {
			writer.write(buffer, 0, n);
			count += n;
		}
		
		// STEP Number Return the count
		return count;
		
	}
	
	// ===== ===== ===== ===== [Static Utility Methods - HTTP Application] ===== ===== ===== ===== //
	
    /**
     * Execute a HTTP-GET request to target remote URL
     * @param url The remote URL to send request to
     * @param charsetName The character set name to set in request header and readers
     * @return result The result got from response
     * @author ZhouYi
     * @throws IOException 
     * @since version
     * @date 2019-10-29 14:14:21
     * @description description
     */
    public static String doGet(String urlPath, String charsetName) throws TabNineApplicationException {
		// STEP Number Declare the log variables
		String logTitle = "Try to execute a HTTP-GET request to target remote URL"; // Log message title
		String logMessage = null; // Log message text
    	
    	// STEP Number Validate incoming parameters
    	if (TabNineLangUtils.isBlank(urlPath)) {
			logMessage = logTitle + " - Failed: The URL path is blank";
			System.err.println(logMessage);
			throw new TabNineApplicationException(logMessage);
    		
		}
    	if (TabNineLangUtils.isBlank(charsetName)) {
    		charsetName = DEFAULT_CHARSET_NAME;
    		
		}
		
    	// STEP Number Print logs
    	System.out.println(logTitle + " [" + urlPath + "]");
    	
    	// STEP Number Declare relative variables
    	StringBuffer resultBuffer = new StringBuffer(); // The returned result
		BufferedReader bufferedReader = null; // BufferedReader
    	
    	// STEP Number Send request and parse response
		try {
			// SUBSTEP Number Open connection
			URLConnection connection = new URL(urlPath).openConnection();
			HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
			
			// SUBSTEP Number Complete HTTP connection settings
			// NOTE Number To avoid the crawler prevention, a fake User-Agent was created here
			httpURLConnection.setRequestProperty("Accept-Charset", charsetName);
			httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			httpURLConnection.setRequestProperty("User-Agent", "User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
			
			
			// SUBSTEP Number Check the response code
			int responseCode = httpURLConnection.getResponseCode();
			if (responseCode >= 300) {
			    throw new IOException("HTTP Request is not success, Response code is " + responseCode);
			    
			} else {
				System.out.println(logTitle + " - Response code was [" + responseCode + "]");
				
			}
			
			// SUBSTEP Number If the response is available, initial IO source variables
			InputStream inputStream = httpURLConnection.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charsetName);
			bufferedReader = new BufferedReader(inputStreamReader);
			String line = null;
			
			// SUBSTEP Number Read the response data
			while ((line = bufferedReader.readLine()) != null) {
			    resultBuffer.append(line);
			    
			}
			
		} catch (MalformedURLException e) {
			logMessage = logTitle + " - Failed: The URL path [" + urlPath + "] is malformed.";
			
		} catch (UnsupportedEncodingException e) {
			logMessage = logTitle + " - Failed: The encoding/charset type [" + charsetName + "] is not supported.";
			
		} catch (IOException e) {
			logMessage = logTitle + " - Failed: Unkown IO exception hanppend.";
			
		} catch (Exception e) {
			if (logMessage == null) {
				logMessage = logTitle + " - Failed: Unkown exception hanppend.";
			}
			System.err.println(logMessage);
			e.printStackTrace();
			throw new TabNineApplicationException(logMessage, e);
			
		} finally {
			safelyClose(bufferedReader);
			
		}
		
		// STEP Number Return the result text
		return resultBuffer.toString();
		
    }
	
    /**
     * Download file from remote URL and save it to specified destination
     * @param urlPath
     * @param filePath
     * @return destFile The file saved
     * @author ZhouYi
     * @date 2019-10-29 下午 17:54:57
     * @description description
     * @note note
     */
    public static File downLoadFile(String urlPath, String filePath) {
		// STEP Number Declare the log variables
		String logTitle = "Try to download file from remote URL"; // Log message title
		String logMessage = null; // Log message text
    	
    	// STEP Number Validate incoming parameters
    	if (TabNineLangUtils.isBlank(urlPath)) {
			logMessage = logTitle + " - Failed: The URL path is blank.";
			System.err.println(logMessage);
			throw new TabNineApplicationException(logMessage);
    		
		}
    	if (TabNineLangUtils.isBlank(filePath)) {
			logMessage = logTitle + " - Failed: The file path is blank.";
			System.err.println(logMessage);
			throw new TabNineApplicationException(logMessage);
    		
		}
		
    	// STEP Number Check and set destination file
    	File destFile = new File(filePath);
    	File parentFolder = destFile.getParentFile();
    	if (destFile.exists()) {
			System.out.println(logTitle + " - Aborted: The file [" + filePath + "] is already existed.");
			return destFile;
    		
		}
    	
    	// STEP Number Check and set parent folder
    	parentFolder.mkdirs();
    	if (!parentFolder.isDirectory()) {
			logMessage = logTitle + " - Failed: The parent folder of [" + filePath + "] is not a direcotry and can not be created.";
			System.err.println(logMessage);
			throw new TabNineApplicationException(logMessage);
    		
		}
    	
    	// STEP Number Print logs
    	System.out.println(logTitle + " [" + urlPath + "] to target file [" + filePath + "].");
    	
		// STEP Number Declare IO source
		InputStream inputStream = null;
		FileOutputStream fileOutputStream = null;
    	
    	// STEP Number Send request and parse response
		try {
	    	// SUBSTEP Number Open connection
			HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(urlPath).openConnection();

			// SUBSTEP Number Complete HTTP connection settings
			// NOTE Number To avoid the crawler prevention, a fake User-Agent was created here
			httpURLConnection.setRequestProperty("User-Agent", "User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
			
			// SUBSTEP Number Check the response code
			int responseCode = httpURLConnection.getResponseCode();
			if (responseCode >= 300) {
			    throw new IOException("HTTP Request is not success, Response code is " + responseCode);
			    
			} else {
				System.out.println(logTitle + " - Response code was [" + responseCode + "]");
				
			}
			
			// SUBSTEP Number If the response is available, initial IO source variables
			inputStream = httpURLConnection.getInputStream();
			fileOutputStream = new FileOutputStream(destFile);
			byte[] buffer = new byte[DEFUALT_BUFFER_SIZE];
			int n = -1;
			
			// SUBSTEP Number Transfer data
			while ((n = inputStream.read(buffer)) != -1) {
				fileOutputStream.write(buffer, 0, n);
				
			}
			
		} catch (FileNotFoundException e) {
			logMessage = logTitle + " - Failed: The target file [" + filePath + "] can not be found.";
			
		} catch (IOException e) {
			logMessage = logTitle + " - Failed: Unkown IO exception hanppend.";
			
		} catch (Exception e) {
			if (logMessage == null) {
				logMessage = logTitle + " - Failed: Unkown exception hanppend.";
			}
			System.err.println(logMessage);
			e.printStackTrace();
			throw new TabNineApplicationException(logMessage, e);
			
		} finally {
			safelyClose(fileOutputStream);
			safelyClose(inputStream);
			
		}
		
		// SUBSTEP Number Return the file
		return destFile;
		
    }
	
	// ===== ===== ===== ===== [SplitLineTitle] ===== ===== ===== ===== //
	
}
