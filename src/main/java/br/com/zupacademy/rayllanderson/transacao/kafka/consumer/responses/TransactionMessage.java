package br.com.zupacademy.rayllanderson.transacao.kafka.consumer.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionMessage {
    private String id;
    @JsonProperty("valor")
    private BigDecimal value;
    @JsonProperty("estabelecimento")
    private EstablishmentResponse establishment;
    @JsonProperty("cartao")
    private CardResponse card;
    @JsonProperty("efetivadaEm")
    private LocalDateTime effectedIn;

    @Deprecated
    private TransactionMessage() {
    }

    public TransactionMessage(String id, BigDecimal value, EstablishmentResponse establishment, CardResponse card, LocalDateTime effectedIn) {
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

    public String getEstablishmentName(){
        return this.establishment.getName();
    }

    public String getEstablishmentCity(){
        return this.establishment.getCity();
    }

    public String getEstablishmentAddress(){
        return this.establishment.getAddress();
    }

    public String getCardId(){
        return this.card.getId();
    }

    public String getCardEmail(){
        return this.card.getEmail();
    }
}
