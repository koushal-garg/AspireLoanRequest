package User;

import Constants.Enums.UserRole;

public class UserController {
    /**
     * This function take required input and returns user object.
     * */
    public User createUser(String id, String name, UserRole role) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setRole(role);
        return user;
    }
}
