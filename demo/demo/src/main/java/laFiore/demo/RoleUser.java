package laFiore.demo;

public enum RoleUser {

    ADMIN("admin");

    private String role;

    RoleUser(String role) {
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
