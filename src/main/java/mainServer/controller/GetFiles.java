package mainServer.controller;

import java.io.*;
import java.util.*;
import mainServer.models.*;

public class GetFiles {

        ArrayList<String> allFiles = new ArrayList<String>();


        public DirectoryModel getAllFiles(String directoryPath, String keyword){

            try{

                //getting all files
                File path = new File(directoryPath);
                File[] filesList = path.listFiles();

                if(filesList!=null){//checking if fileList is empty

                    for(File f:filesList){
                        //comparing with keyword and adding them into arraylist
                        if(f.getName().toLowerCase().contains(keyword)){
                            allFiles.add(f.getAbsolutePath());
                            System.out.println(f.getAbsolutePath());
                        }

                    }

                }

            }
            catch (Exception e){

                System.out.println(e);

            }
            return new DirectoryModel(directoryPath, keyword, allFiles);
        }
    }
