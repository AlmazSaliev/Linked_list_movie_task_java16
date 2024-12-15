package models;

public class Producer {
    private String firstName;
    private String lastName;
    private Long id;
    private static Long startId = 1L;

    public Producer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = startId++;
    }

    public Producer() {
        this.id = startId++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Producer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }
}
