///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package apitest;
//
///**
// *
// * @author korabel245
// */
//public class backup {
//    
//    public static void getTickets(){
//       HttpURLConnection req = null;
//        try {
//            req = (HttpURLConnection) new URL(url+getTickets).openConnection();
//            req.setRequestMethod("GET");
//            req.setUseCaches(false);
//            req.setReadTimeout(250);
//            req.setConnectTimeout(250);
//            req.setRequestProperty("Session-Token", session_token);
//            req.connect();
//
//            StringBuilder sb = new StringBuilder();
//            if(HttpURLConnection.HTTP_PARTIAL == req.getResponseCode()||HttpURLConnection.HTTP_OK == req.getResponseCode()){
//                BufferedReader in = new BufferedReader(new InputStreamReader(req.getInputStream()));
//                String line;
//                while((line = in.readLine()) != null){
//                    sb.append(line.replaceAll(",", "\n"));
//                    
//                }
//                String [] lines = sb.toString().split("\n");
//                int counter = 0;
//                for (String line1 : lines) {
//                    if (line1.contains("\"id")) {
//                        System.out.println("#" + counter++ + " " + line1);
//                    }
//                    if (line1.contains("name")) {
//                        System.out.println(line1);
//                    }
//                }
//                //System.out.println(sb);
//                
//                System.out.println(req.getResponseCode());
//            }else{
//                System.out.println(req.getResponseCode());
//            }
//        } catch (IOException ex) {
//        }finally{
//            if(connection != null)
//                connection.disconnect();
//        }
//    }
//    
//        public static void getComputers(){
//       HttpURLConnection req = null;
//        try {
//            req = (HttpURLConnection) new URL(url+getComputers).openConnection();
//            req.setRequestMethod("GET");
//            req.setUseCaches(false);
//            req.setReadTimeout(250);
//            req.setConnectTimeout(250);
//            req.setRequestProperty("Session-Token", session_token);
//            req.connect();
//
//            StringBuilder sb = new StringBuilder();
//            if(HttpURLConnection.HTTP_PARTIAL == req.getResponseCode()||HttpURLConnection.HTTP_OK == req.getResponseCode()){
//                BufferedReader in = new BufferedReader(new InputStreamReader(req.getInputStream()));
//                String line;
//                while((line = in.readLine()) != null){
//                    sb.append(line.replaceAll(",", "\n"));
//                    
//                }
//                String [] lines = sb.toString().split("\n");
//                int counter = 0;
////                for (String line1 : lines) {
////                    if (line1.contains("\"id")) {
////                        System.out.println("#" + counter++ + " " + line1);
////                    }
////                    if (line1.contains("name")) {
////                        System.out.println(line1);
////                    }
////                }
//                System.out.println(sb);
//                
//                System.out.println(req.getResponseCode());
//            }else{
//                System.out.println(req.getResponseCode());
//            }
//        } catch (IOException ex) {
//        }finally{
//            if(connection != null)
//                connection.disconnect();
//        }
//    }
//        
//    public static void getComputerLog(){
//       HttpURLConnection req = null;
//        try {
//            req = (HttpURLConnection) new URL(url+getComputerLog).openConnection();
//            req.setRequestMethod("GET");
//            req.setUseCaches(false);
//            req.setReadTimeout(250);
//            req.setConnectTimeout(250);
//            req.setRequestProperty("Session-Token", session_token);
//            req.connect();
//
//            StringBuilder sb = new StringBuilder();
//            if(HttpURLConnection.HTTP_PARTIAL == req.getResponseCode()||HttpURLConnection.HTTP_OK == req.getResponseCode()){
//                BufferedReader in = new BufferedReader(new InputStreamReader(req.getInputStream()));
//                String line;
//                while((line = in.readLine()) != null){
//                    sb.append(line.replaceAll(",", "\n"));
//                    
//                }
//                String [] lines = sb.toString().split("\n");
//                int counter = 0;
//                System.out.println(sb);
//                
//                System.out.println(req.getResponseCode());
//            }else{
//                System.out.println(req.getResponseCode());
//            }
//        } catch (IOException ex) {
//        }finally{
//            if(connection != null)
//                connection.disconnect();
//        }
//    }
//
//}
