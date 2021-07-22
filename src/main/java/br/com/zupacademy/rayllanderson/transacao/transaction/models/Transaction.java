package br.com.zupacademy.rayllanderson.transacao.transaction.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    private String id;

    @NotNull
    private BigDecimal value;

    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Establishment establishment;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Card card;

    @NotNull
    private LocalDateTime effectedIn;

    @Deprecated
    private Transaction() {
    }

    public Transaction(String id, BigDecimal value, Establishment establishment, Card card, LocalDateTime effectedIn) {
        this.id = id;
        this.value = value;
        this.establishment = establishment;
        this.card = card;
        this.effectedIn = effectedIn;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public LocalDateTime getEffectedIn() {
        return effectedIn;
    }

    public String getCardId(){
        return this.card.getId();
    }

    public String getCardEmail(){
        return this.card.getEmail();
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public Card getCard() {
        return card;
    }
}
