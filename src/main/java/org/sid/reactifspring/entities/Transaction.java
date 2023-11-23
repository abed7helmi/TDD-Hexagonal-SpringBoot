package org.sid.reactifspring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Transaction {
    @Id
    private String id;
    private Instant instant;
    private double price;
    @DBRef // je fait une reference vers une societe qui sera stocke dans une autre collection
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Societe societe;
}