package mainServer.models;

import java.util.*;

public class DirectoryModel {

        private String directoryPath;
        private String keyword;
        private ArrayList<String> allFiles;

        public DirectoryModel(String directoryPath,String keyword,ArrayList<String> allFiles){
            this.directoryPath = directoryPath;
            this.keyword = keyword;
            this.allFiles = allFiles;
        }

        public String getDirectoryPath() {
            return directoryPath;
        }

        public String getKeyword() {
            return keyword;
        }

        public ArrayList<String> getAllFiles() {
            return allFiles;
        }

        public void setDirectoryPath(String directoryPath) {
            this.directoryPath = directoryPath;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public void setAllFiles(ArrayList<String> allFiles) {
            this.allFiles = allFiles;
        }



    }

