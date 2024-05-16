package com.example.betr_backend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "budget")
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Budget_ID")
    private long budgetId;

    @Column(name="Month")
    private int month;

    @Column(name="Year")
    private int year;

    @Column(name="Date_Of_Creation")
    private Date createdAt;

    @Column(name="Date_Of_Updation")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

    @ManyToOne
    @JoinColumn(name = "User_ID")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "budget")
    private List<BudgetCategory> BudgetCategories;


}