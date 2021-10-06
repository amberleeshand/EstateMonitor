package org.djna.asynch.estate.data;

import java.util.Locale;

public class User {

    public enum Roles {
        TENANT("tenant"),
        MANAGER("manager"),
        HANDYMAN("handyman");
        private String roleName;

        private Roles(String initName) {
            roleName = initName;
        }
        public String getHomePage (){
            return this.toString().toLowerCase(Locale.ROOT);
        }
    }

    private String user;
    private String password;
    private String role;

    public User (String initUser, String initPassword, String initRole){
        user = initUser;
        password = initPassword;
        role = initRole;

    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
