package org.djna.asynch.estate.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Users {

    public List<User> getListOfUsers() {

        List<User> listOfUsers = new ArrayList<>();

        listOfUsers.add( new User("tenant1", "pinkbun123_1", User.Roles.TENANT.name()));
        listOfUsers.add( new User("tenant2", "pinkbun123_2", User.Roles.TENANT.name()));
        listOfUsers.add( new User("tenant3", "pinkbun123_3", User.Roles.TENANT.name()));
        listOfUsers.add( new User("tenant4", "pinkbun123_4", User.Roles.TENANT.name()));
        listOfUsers.add( new User("tenant5", "pinkbun123_5", User.Roles.TENANT.name()));
        listOfUsers.add( new User("tenant6", "pinkbun123_6", User.Roles.TENANT.name()));
        listOfUsers.add( new User("tenant7", "pinkbun123_7", User.Roles.TENANT.name()));
        listOfUsers.add( new User("tenant8", "pinkbun123_8", User.Roles.TENANT.name()));
        listOfUsers.add( new User("estateOwner", "redflag62",User.Roles.MANAGER.name()));
        listOfUsers.add( new User("handyMan", "greencup34", User.Roles.HANDYMAN.name()));

        return listOfUsers;
    }




}
