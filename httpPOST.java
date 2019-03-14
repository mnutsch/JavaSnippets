//set up the URL and parameters
String url = "http://localhost:3000";
String charset = "UTF-8";
String param1 = "Basic myauthorization";
String param2 = "AcmeIndustries";
String query = String.format("authorization=%s&sender=%s",
URLEncoder.encode(param1, charset), 
  URLEncoder.encode(param2, charset));
  
//set up the Message Body
String messageBody = "{ \"test\": \"message\" }";
URLConnection con = new URL(url + "?" + query).openConnection();
HttpURLConnection http = (HttpURLConnection)con;
http.setRequestMethod("POST"); 
http.setDoOutput(true);

//Send the message.
byte[] outputMessage = messageBody.getBytes(StandardCharsets.UTF_8);
int length = outputMessage.length;
http.setFixedLengthStreamingMode(length);
http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
http.connect(); //connect to the API server
try(OutputStream os = http.getOutputStream()) {
    os.write(outputMessage); //write the message to the API.
}
