
package apitest;

import GUI.scenes;
import java.net.HttpURLConnection;


public class APITest {
        
        public static String url = "http://help.korabel.loc/apirest.php/";
        public static String initSession = "initSession/";
        public static String API_Token = "BxOrOHZ4DwKMQsjWMdCealPpqpfoz2vy5Cy4FRDY";
        public static String USER_LOGIN = "korabel245";
        public static String USER_PASS = "1111";
        public static String personal_token = "nvhujXFzEHVM3rzpSvAqZsSaHtX9FSdrRJZbRHTp";
        public static String user_token = "user_token nvhujXFzEHVM3rzpSvAqZsSaHtX9FSdrRJZbRHTp";
        public static String session_token;

        public static HttpURLConnection connection = null;
  
    public static void main(String[] args) {
             
        
        //makeRequest();
    }
    
    
    public static void makeRequest(){
        //session_token = ManageConnection.getSessionToken(connection, url, initSession);
        String getTickets = "Ticket/?range=0-1000";
        String getComputers = "Computer/10?forcedisplay[0]=126&range=0-1000";
        String getComputerLog = "/Computer/10?with_networkports=true";
        String searchOpts = "/listSearchOptions/Computer/";
//                String test = "/Computer/10/?with_networkports=true";
        String test = "/search/Computer?forcedisplay[0]=126&range=0-1000";
        ManageConnection.getCleanResponseOn(test);
    }
    
    
}
    
    

