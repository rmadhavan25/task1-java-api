package mainServer.models;

import java.util.*;

public class DirectoryModel {

        private String directoryPath;
        private String keyword;
        private ArrayList<HashMap<String,String>> res;


        public DirectoryModel(String directoryPath,String keyword,ArrayList<HashMap<String,String>> res){
            this.directoryPath = directoryPath;
            this.keyword = keyword;
            this.res = res;
        }

        public ArrayList<HashMap<String, String>> getRes() {
            return res;
        }

        public void setRes(ArrayList<HashMap<String, String>> res) {
            this.res = res;
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

