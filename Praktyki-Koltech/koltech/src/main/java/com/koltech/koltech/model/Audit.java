package com.koltech.koltech.model;

import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Embeddable
public class Audit {

    private LocalDateTime createdOn;
    private LocalDateTime updateOn;

    @PrePersist
    void prePersist(){
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    void PreUpdate(){
        updateOn = LocalDateTime.now();
    }
}
