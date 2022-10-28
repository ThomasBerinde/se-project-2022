package com.example.seproject2022.persistance.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "message_tbl")
@NoArgsConstructor
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private long id;

    @Column(name = "message")
    private String message;

    @Column(name = "person_id")
    private long personId;
}
