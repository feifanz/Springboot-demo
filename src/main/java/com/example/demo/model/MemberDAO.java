package com.example.demo.model;

public class MemberDAO {

    private String id;
    private String name;
    private String startDate;
    private String endDate;
    private String description;
    private String level;
    private String status;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id == null){
            this.id = null;
        }else {
            this.id = String.valueOf(id);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MemberDAO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", description='" + description + '\'' +
                ", level='" + level + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}
