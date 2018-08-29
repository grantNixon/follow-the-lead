package com.example.grant.followthelead;

public class Event {
    private String eventName;
    private String eventSponsor;
    private String eventLocation;
    private String eventDate;
    private String eventID;

    public Event(String eventName, String eventSponsor, String eventLocation) {
        this.eventName = eventName;
        this.eventSponsor = eventSponsor;
        this.eventLocation = eventLocation;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getEventDate() {

        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventSponsor() {
        return eventSponsor;
    }

    public void setEventSponsor(String eventSponsor) {
        this.eventSponsor = eventSponsor;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }
}
