package mainServer.models;

import java.util.*;

public class DirectoryModel {

        private String directoryPath;
        private String keyword;
        private ArrayList<HashMap<String,String>> files;


        public DirectoryModel(String directoryPath,String keyword,ArrayList<HashMap<String,String>> files){
            this.directoryPath = directoryPath;
            this.keyword = keyword;
            this.files = files;
        }

        public ArrayList<HashMap<String, String>> getFiles() {
            return files;
        }

        public void setFiles(ArrayList<HashMap<String, String>> files) {
            this.files = files;
        }

        public String getDirectoryPath() {
            return directoryPath;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setDirectoryPath(String directoryPath) {
            this.directoryPath = directoryPath;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }


    }

