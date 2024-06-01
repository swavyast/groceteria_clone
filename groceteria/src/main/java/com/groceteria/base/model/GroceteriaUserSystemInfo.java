package com.groceteria.base.model;

import java.time.LocalDateTime;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class GroceteriaUserSystemInfo {

    @Id
    @SequenceGenerator(name = "system_info_sequence", sequenceName = "system_info_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "system_info_sequence")
    private Long id;
    @ElementCollection
    @CollectionTable
    private Map<String, String> envVariales;
    private LocalDateTime createdAt;
    @OneToOne
    GroceteriaUser user;
}