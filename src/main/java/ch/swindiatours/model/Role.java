package ch.swindiatours.model;

/**
 * Enumerator for Role which gives privileges to every user
 * Booking of privileges from least to most:
 * 1. Role.CUSTOMER = Normal user without any special rights
 * 3. Role.ADMIN = Administrator with all privileges
 * @author chant
 * @version 1.0
 */
public enum Role {
    CUSTOMER("C"), ADMIN("A");

    private final String name;

    Role(String name) {
        this.name = name;
    }

    public static Role getRole(String name){
        switch (name){
            default:
            case "C":
                return Role.CUSTOMER;
            case "A":
                return Role.ADMIN;
        }
    }

    public static String getRoleName(String role) {
        return role;
    }

    public static String getDescriptionRole(Role role) {
        String output;
        switch(role){
            default:
            case CUSTOMER:
                output= "customer";
                break;
            case ADMIN:
                output= "admin";
                break;
        }
        return output;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                '}';
    }
}
