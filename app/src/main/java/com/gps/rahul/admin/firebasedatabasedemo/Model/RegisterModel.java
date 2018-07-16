package com.gps.rahul.admin.firebasedatabasedemo.Model;

public class RegisterModel {

    /**
     * status : 1
     * userDetail : {"user_id":1,"name":"Rahul","email":"rahul123@gmail.com"}
     * message : You are Successfully Registered
     */

    private int status;
    private UserDetailBean userDetail;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserDetailBean getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetailBean userDetail) {
        this.userDetail = userDetail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class UserDetailBean {
        /**
         * user_id : 1
         * name : Rahul
         * email : rahul123@gmail.com
         */

        private String user_id;
        private String name;
        private String email;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
