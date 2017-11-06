//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.banner.bannerApplication.entities;
import javax.persistence.*;
import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.time.LocalDateTime;

@Entity
public class Section{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long sectionNumber;

    private String startDate, endDate, startTime, endTime, classDate;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Rooms room;

    @ManyToOne
    private Professor professor;

    @ManyToOne
    private User user;


    public Section() {}
    public Section(Course course, Long sectionNumber){
        this.sectionNumber = sectionNumber;
        this.course = course;
    }
    public Long getId () {
        return id;
    }
    public void setProfessor(Professor professor){
        this.professor = professor;
    }
    public Professor getProfessor(){
        return professor;
    }
    public User getUser() { return user;}
    public void setUser (User user) {this.user = user;}
    public Long getSectionNumber (Long sectionNumber) {
        return sectionNumber;
    }
    public void setSectionNumber (Long sectionNumber) {
        this.sectionNumber = sectionNumber;
    }
    public Course getCourse(){
        return course;
    }
    public void setCourse(Course course){
        this.course = course;
    }
    public Rooms getRoom(){
        return room;
    }
    public void setRoom(Rooms room){ this.room = room; }

    public void setStartDate (String startDate) throws ParseException {

        DateFormat outputFormat = new SimpleDateFormat("mm-dd-yyyy");
        DateFormat inputFormat = new SimpleDateFormat("mm-dd-yyyy");
        Date date = inputFormat.parse(startDate);
        String outputText = outputFormat.format(date);
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }
    public void setEndDate (String endDate) throws ParseException {
        DateFormat outputFormat = new SimpleDateFormat("mm-dd-yyyy");
        DateFormat inputFormat = new SimpleDateFormat("mm-dd-yyyy");
        Date date = inputFormat.parse(endDate);
        String outputText = outputFormat.format(date);
        this.endDate = endDate;
    }
    public String getEndDate() { return endDate; }
    public String getStartTime() { return startTime; }
    public void setStartTime (String startTime) { this.startTime = startTime;}
    public String getEndTime() { return endTime; }
    public void setEndTIme (String endDate) { this.endTime = endTime;}
    public String getClassDate() { return classDate; }
    public void setClassDate (String classDate) { this.classDate = classDate;}
}
