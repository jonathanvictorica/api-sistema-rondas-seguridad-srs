package com.utn.frba.srs.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoundExecute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Round round;
    private LocalDateTime dateTimeStart;

    @OneToMany
    @JoinColumn
    private List<RoundExecuteEvent> events;
    private String executeDetails = null;


    @ManyToOne
    @JoinColumn
    private User userRevisor;
    private String detailsRevisor;
    private LocalDateTime dateTimeRevisor;


    private String state;


}
