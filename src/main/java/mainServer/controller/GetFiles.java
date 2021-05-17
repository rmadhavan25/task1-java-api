package mainServer.controller;

import java.io.*;
import java.util.*;
import mainServer.models.*;

public class GetFiles {

        ArrayList<HashMap<String,String>> res = new ArrayList<HashMap<String,String>>();
        

        public DirectoryModel getAllFiles(String directoryPath, String keyword){

            try{

                //---------getting all files----------------------------------------------------
                File path = new File(directoryPath);
                File[] filesList = path.listFiles();

                if(filesList!=null){//checking if fileList is empty

                    for(File f:filesList){
                        //--------------comparing with keyword and adding them into arraylist------------------
                        if(f.getName().toLowerCase().contains(keyword.toLowerCase())){

                            //-------------------------get matched files and split them into 3 parts--------------------------------
                            String alpha = f.getAbsolutePath().substring(0, f.getAbsolutePath().toLowerCase().indexOf(keyword.toLowerCase()));
                            String key = f.getAbsolutePath().substring(f.getAbsolutePath().toLowerCase().indexOf(keyword.toLowerCase()),f.getAbsolutePath().toLowerCase().indexOf(keyword.toLowerCase())+keyword.length());
                            String beta = f.getAbsolutePath().substring(f.getAbsolutePath().toLowerCase().indexOf(keyword.toLowerCase())+keyword.length(),f.getAbsolutePath().length());
                            
                            //-------------------adding the files to map-------------------------------------------------------
                            HashMap<String,String> r = new HashMap<String,String>();
                            r.put("fileAlpha", alpha);
                            r.put("fileKey",key);
                            r.put("fileBeta",beta);
                            
                            //------------------check if the result is directory or file----------------------------------
                            File ft = new File(f.getAbsolutePath());
                            if(ft.isDirectory()){
                                r.put("type", "Folder");
                                res.add(r);
                            }
                            else{
                                r.put("type", "File");
                                res.add(r);
                            }

                            
                            System.out.println(f.getAbsolutePath());
                        }

                    }

                }

            }
            catch (Exception e){

                System.out.println(e);

            }
            return new DirectoryModel(directoryPath,keyword,res);
        }
    }
