/*********************************************************************************
  * This method will download files with authentication based on
  * environment variables "user" and "password". 
  *********************************************************************************/
  private static final int BUFFER_SIZE = 65536;
  public static void download(File downloadDir, String fileName, URL url) throws IOException {
	String userName = System.getenv("user");
	String password = System.getenv("password");
	if(userName == null){
		System.out.println("Warning: onenetwork.repo.user is null!");
	}
	if(password == null){
		System.out.println("Warning: onenetwork.repo.password is null!");
	}
	
	String stringToEncode = userName + ":" + password;
	String encodedString = Base64.getEncoder().encodeToString(stringToEncode.getBytes());
	String authenticationString = "Basic " + encodedString; 
	  
	HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
	httpConn.setRequestProperty("Authorization", authenticationString);
	int responseCode = httpConn.getResponseCode();

	// always check HTTP response code first
	if (responseCode == HttpURLConnection.HTTP_OK) {
	  String disposition = httpConn.getHeaderField("Content-Disposition");
	  String contentType = httpConn.getContentType();
	  int contentLength = httpConn.getContentLength();

	  System.out.println("Content-Type = " + contentType);
	  System.out.println("Content-Disposition = " + disposition);
	  System.out.println("Content-Length = " + contentLength);
	  System.out.println("fileName = " + fileName);

	  // opens input stream from the HTTP connection
	  InputStream inputStream = httpConn.getInputStream();

	  String downloadDirAsString = downloadDir.getPath();
	  String filePath = downloadDirAsString + File.separator + fileName;

	  // opens an output stream to save into file
	  FileOutputStream outputStream = new FileOutputStream(filePath);

	  int bytesRead = -1;
	  byte[] buffer = new byte[BUFFER_SIZE];
	  while ((bytesRead = inputStream.read(buffer)) != -1) {
	    outputStream.write(buffer, 0, bytesRead);
	  }

	  outputStream.close();
	  inputStream.close();

	  System.out.println("File downloaded");
	} else {
	  System.out.println("No file to download. Server replied HTTP code: " + responseCode);
	}
	httpConn.disconnect();
  }
