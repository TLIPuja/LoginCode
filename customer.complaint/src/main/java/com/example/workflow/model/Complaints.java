package com.example.workflow.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "complaints")
public class Complaints  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer complaint_id;
    private String customer_name;
    private String customer_email;
    private  String complaint_description;
    private String complaint_type;
    private String status;
    private String priority;
    private String assignee;

    public void setStatus(String status) {
        this.status = status;
  }

    public String getStatus() {
      return status;
    }

    public int getComplaint_id() {
        return complaint_id;
    }

   public String getComplaint_description() {
       return complaint_description;
    }



 public String getComplaint_type() {
       return complaint_type;
   }

   public String getCustomer_email() {
        return customer_email;
    }

    public void setComplaint_id(int complaint_id) {
        this.complaint_id = complaint_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setComplaint_description(String complaint_description) {
       this.complaint_description = complaint_description;
    }

   public void setComplaint_type(String complaint_type) {
        this.complaint_type = complaint_type;
    }

    public String getPriority() {
        return priority;
    }

    public void setCustomer_email(String customer_email) {
       this.customer_email = customer_email;
    }



    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setPriority(String priority) {
        this.priority = priority;
   }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public void setComplaint_id(Integer complaint_id) {
        this.complaint_id = complaint_id;
    }
}
