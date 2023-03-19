package space_station.model;

import jakarta.persistence.*;

@Entity
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String name;
    private String craft;

    public Human(String name, String craft) {
        this.name = name;
        this.craft = craft;
    }

    public Human() {
    }

    public int getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCraft() {
        return craft;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }

    @Override
    public String toString() {
        return "Human{" +
                " name='" + name + '\'' +
                ", craft='" + craft + '\'' +
                '}';
    }
}
