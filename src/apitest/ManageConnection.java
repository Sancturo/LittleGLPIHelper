package apitest;

import GUI.MainWindowController;
import POJOs.compBase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class ManageConnection {
    
        public static String url = "http://help.korabel.loc/apirest.php/";
        public static String initSession = "initSession/";
        public static String API_Token = "BxOrOHZ4DwKMQsjWMdCealPpqpfoz2vy5Cy4FRDY";
        public static String session_token;
        public static HttpURLConnection connection = null;
        
    
public static String getSessionToken(String login, String password){
    
    try {
            connection = (HttpURLConnection) new URL(url+initSession).openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setReadTimeout(250);
            connection.setConnectTimeout(250);
            connection.setRequestProperty("Content-Type" ,"application/json");
            String authString = "Basic " + Base64.getEncoder().encodeToString(String.format("%s:%s", login,password).getBytes());          
            connection.setRequestProperty("Authorization", authString);
            System.out.println(authString);
            connection.setRequestProperty("App-Token", API_Token);
            connection.setRequestProperty("Connection", "keep-alive");
            connection.connect();
            StringBuilder sb = new StringBuilder();
            if(HttpURLConnection.HTTP_OK == connection.getResponseCode()){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while((line = in.readLine()) != null){
                    sb.append(line);
                    sb.append("\n");
                    if(line.contains("session_token")){
                        session_token = line.replaceAll("session_token", "").replaceAll(":", "").replaceAll("\\p{P}","");
                        System.out.println(session_token);
                    }
                }
                System.out.println(sb);
                System.out.println(connection.getResponseCode());
            }else{
                System.out.println(connection.getResponseCode());
            }
        } catch (IOException ex) {
        }finally{
            if(connection != null)
                System.out.println("no disconnect");    
            connection.disconnect();
            }
        return session_token;
}
    
        
    
    
       public static void getResponseOn(String apiCommand){
       HttpURLConnection req = null;
        try {
            req = (HttpURLConnection) new URL(url+apiCommand).openConnection();
            req.setRequestMethod("GET");
            req.setUseCaches(false);
            req.setReadTimeout(250);
            req.setConnectTimeout(250);
            req.setRequestProperty("Session-Token", session_token);
            req.connect();

            StringBuilder sb = new StringBuilder();
            if(HttpURLConnection.HTTP_PARTIAL == req.getResponseCode()||HttpURLConnection.HTTP_OK == req.getResponseCode()){
                BufferedReader in = new BufferedReader(new InputStreamReader(req.getInputStream()));
                String line;
                while((line = in.readLine()) != null){
                    sb.append(line.replaceAll(",", ",\n"));
//                    sb.append(line.replaceAll("\"", ""));
                }
                String [] lines = sb.toString().split("\n");
                String IPAddress = null;
                int iter = 1;
                for (String line1 : lines) {
                    if (line1.contains("\"1\"")) {
                        IPAddress = line1.replaceAll("\\{\"1\":", ""); 
                        System.out.println(iter + " of " + lines.length + " Comp Name is: " + IPAddress);
                        iter++;
                    }
                    if (line1.contains("126")) {
                       System.out.println("IPAddress is: " + line1);
                    }
                    compBase comp = new compBase(iter, IPAddress, IPAddress, line1, IPAddress, true);
                    MainWindowController.compList.add(comp);
                }
                //System.out.println(sb);
                System.out.println(req.getResponseCode());
            }else{
                System.out.println(req.getResponseCode());
            }
        } catch (IOException ex) {
        }finally{
            System.out.println(req);
            if(req != null){
                req.disconnect();
                System.out.println("Disconnected");
            }
        }
    }
       
       public static void getCleanResponseOn(String apiCommand){
       HttpURLConnection req = null;
        try {
            req = (HttpURLConnection) new URL(url+apiCommand).openConnection();
            req.setRequestMethod("GET");
            req.setUseCaches(false);
            req.setReadTimeout(250);
            req.setConnectTimeout(250);
            req.setRequestProperty("Session-Token", session_token);
            req.connect();

            StringBuilder sb = new StringBuilder();
            if(HttpURLConnection.HTTP_PARTIAL == req.getResponseCode()||HttpURLConnection.HTTP_OK == req.getResponseCode()){
                BufferedReader in = new BufferedReader(new InputStreamReader(req.getInputStream()));
                String line;
                while((line = in.readLine()) != null){
                    sb.append(line.replaceAll(",", ",\n"));
//                    sb.append(line.replaceAll("\"", ""));
                }
                String [] lines = sb.toString().split("\n");
                String IPAddress = null;
                int iter = 1;
                for (String line1 : lines) {
                    if (line1.contains("\"1\"")) {
                        IPAddress = line1.replaceAll("\\{\"1\":", ""); 
                        System.out.println(iter + " of " + lines.length + " Comp Name is: " + IPAddress);
                        iter++;
                    }
                }
                //System.out.println(sb);
                System.out.println(req.getResponseCode());
            }else{
                System.out.println(req.getResponseCode());
            }
        } catch (IOException ex) {
        }finally{
            System.out.println(req);
            if(req != null){
                req.disconnect();
                System.out.println("Disconnected");
            }
        }
    }
       
    
}
