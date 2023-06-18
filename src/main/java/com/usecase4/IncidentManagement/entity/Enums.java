package com.usecase4.IncidentManagement.entity;

public class Enums {
    public enum Priority {
        Critical,
        High,
        Medium,
        Low
    }

    public enum Department {
        Marketing,
        IT,
        HR,
        Finance
    }

    public enum Category {
        Software_Issues,
        Hardware_Issues,
        Accessory_Issues,
    }

    public enum Status {
        New,
        In_Progress,
        Resolved,
        Rejected
    }
}
