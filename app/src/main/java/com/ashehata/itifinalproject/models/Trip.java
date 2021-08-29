package com.ashehata.itifinalproject.models;

import java.util.List;

enum TripState {
    UPCOMING,
    DONE,
    CANCELLED
}

enum TripType {
    ONE_WAY,
    ROUND
}
enum TripRepeat {
    NO,
    DAILY,
    WEEKLY,
    MONTHLY
}
public class Trip {
    private int id;
    private String name;
    private long date;
    private long time;
    private TripState tripState;
    private TripType tripType;
    private TripRepeat tripRepeat;
    private String from;
    private String to;
    private List<String> notes;

    public Trip(int id, String name, long date, long time, TripState tripState, TripType tripType, TripRepeat tripRepeat, String from, String to, List<String> notes) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.tripState = tripState;
        this.tripType = tripType;
        this.tripRepeat = tripRepeat;
        this.from = from;
        this.to = to;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public TripState getTripState() {
        return tripState;
    }

    public void setTripState(TripState tripState) {
        this.tripState = tripState;
    }

    public TripType getTripType() {
        return tripType;
    }

    public void setTripType(TripType tripType) {
        this.tripType = tripType;
    }

    public TripRepeat getTripRepeat() {
        return tripRepeat;
    }

    public void setTripRepeat(TripRepeat tripRepeat) {
        this.tripRepeat = tripRepeat;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }
}
