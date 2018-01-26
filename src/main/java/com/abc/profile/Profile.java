package com.abc.profile;

/**
 * Created by cadet on 1/23/2018 AD.
 */

import com.abc.RestResponse;
import org.springframework.data.mongodb.core.mapping.Document;

    @Document(collection = "user_profile")
    public class Profile extends RestResponse{

        private String userId;

        private String firstName;
        private String lastName;
        private String email;
        private String accountNo;

        @Override
        public String toString() {
            return "Profile{" +
                    "user_id=" + getUserId() +
                    ",first_name='" + getFirstName() +
                    ",last_name=" + getLastName() +
                    ",email="+ getEmail() +
                    ",account_no =" + getAccountNo() +
                    "}";
        }


        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }


        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getAccountNo() {
            return accountNo;
        }

        public void setAccountNo(String accountNo) {
            this.accountNo = accountNo;
        }
    }

