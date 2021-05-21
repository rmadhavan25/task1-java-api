package mainServer.controller;

import java.io.*;
import java.util.*;


import mainServer.models.*;

public class GetFiles {

        ArrayList<HashMap<String,String>> files = new ArrayList<HashMap<String,String>>();
        ArrayList<String> columns = new ArrayList<String>();
    

        public GetFiles(){

        }
        

        public DirectoryModel getAllFiles(String directoryPath, String keyword,String phone){

            try{

                //---------getting all files----------------------------------------------------
                File path = new File(directoryPath);
                File[] filesList = path.listFiles();
                int flag = 0;//VARIABLE TO CHECK FOR ANY RESULTS AND TO TRIGGER saveHistory of HistoryController

                if(filesList!=null){//checking if fileList is empty

                    for(File f:filesList){
                        //--------------comparing with keyword and adding them into arraylist------------------
                        if(f.getName().toLowerCase().contains(keyword.toLowerCase())){
                            flag = 1;

                            //-------------------------get matched files and split them into 3 parts--------------------------------
                            // String alpha = f.getAbsolutePath().substring(0, f.getAbsolutePath().toLowerCase().indexOf(keyword.toLowerCase()));
                            // String key = f.getAbsolutePath().substring(f.getAbsolutePath().toLowerCase().indexOf(keyword.toLowerCase()),f.getAbsolutePath().toLowerCase().indexOf(keyword.toLowerCase())+keyword.length());
                            // String beta = f.getAbsolutePath().substring(f.getAbsolutePath().toLowerCase().indexOf(keyword.toLowerCase())+keyword.length(),f.getAbsolutePath().length());
                            
                            //-------------------adding the files to map-------------------------------------------------------
                            HashMap<String,String> fileInfo = new HashMap<String,String>();
                            fileInfo.put("name", f.getAbsolutePath());
                            //r.put("fileKey",key);
                            //r.put("fileBeta",beta);
                            
                            //------------------check if the result is directory or file----------------------------------
                            File ft = new File(f.getAbsolutePath());
                            if(ft.isDirectory()){
                                fileInfo.put("type", "Folder");
                                files.add(fileInfo);
                            }
                            else{
                                fileInfo.put("type","File");
                                files.add(fileInfo);
                            }

                            
                            System.out.println(f.getAbsolutePath());
                        }

                    }
                    //CHECK FOR ANY RESULTS AND TO TRIGGER saveHistory of HistoryController
                    if(flag == 1)
                    new HistoryController().saveHistory(directoryPath, keyword, phone);

                }

            }
            catch (Exception e){

                System.out.println(e);

            }
            columns.add("ALL FILES");
            columns.add("TYPE");
            return new DirectoryModel(directoryPath,keyword,files,columns);
        }

        
    }
