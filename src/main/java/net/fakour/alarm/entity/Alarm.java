package net.fakour.alarm.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
public class Alarm {
    @Id
    private Integer alarmId;
    @Column
    private String errormessage;
    @Column
    private String time;
    @Column
    private String errorType;
    @Column
    private String location;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Ticket ticket;



    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }




    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public Integer getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(Integer alarmId) {
        this.alarmId = alarmId;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }
}
