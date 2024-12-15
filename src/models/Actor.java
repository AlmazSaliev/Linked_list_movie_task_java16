package models;

public class Actor {
    private String actorFullName;
    private String role;
    private Long id;
    private static Long startId = 1L;

    public Actor() {
        this.id = startId++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Actor(String actorFullName, String role) {
        this.actorFullName = actorFullName;
        this.role = role;
        this.id = startId++;
    }

    public String getActorFullName() {
        return actorFullName;
    }

    public void setActorFullName(String actorFullName) {
        this.actorFullName = actorFullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id='" + id + '\'' +
                "actorFullName='" + actorFullName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
