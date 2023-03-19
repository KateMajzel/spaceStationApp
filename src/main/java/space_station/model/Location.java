package space_station.model;

import jakarta.persistence.*;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "time")
    private double localTime;
    private double latitude;
    private double longitude;
    private int passes;


    public Location(double localTime, double latitude, double longitude) {
        this.localTime = localTime;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location() {

    }

    public Integer getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getLocalTime() {
        return localTime;
    }

    public void setLocalTime(long localTime) {
        this.localTime = localTime;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getPasses() {
        return passes;
    }

    public void setPasses(int passes) {
        this.passes = passes;
    }

    @Override
    public String toString() {
        return "Location{" +
                "Id=" + Id +
                ", localTime=" + localTime +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", passes=" + passes +
                '}';
    }
}


