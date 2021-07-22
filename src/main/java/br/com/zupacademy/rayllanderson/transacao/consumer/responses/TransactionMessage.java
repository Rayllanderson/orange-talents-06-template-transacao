package br.com.zupacademy.rayllanderson.transacao.consumer.responses;

import br.com.zupacademy.rayllanderson.transacao.transaction.models.Card;
import br.com.zupacademy.rayllanderson.transacao.transaction.models.Establishment;
import br.com.zupacademy.rayllanderson.transacao.transaction.models.Transaction;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionMessage {
    private String id;
    @JsonProperty("valor")
    private BigDecimal value;
    @JsonProperty("estabelecimento")
    private EstablishmentResponseMessage establishment;
    @JsonProperty("cartao")
    private CardResponseMessage card;
    @JsonProperty("efetivadaEm")
    private LocalDateTime effectedIn;

    @Deprecated
    private TransactionMessage() {
    }

    public TransactionMessage(String id, BigDecimal value, EstablishmentResponseMessage establishment, CardResponseMessage card, LocalDateTime effectedIn) {
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

    public Transaction toModel(){
        Establishment establishment = this.establishment.toModel();
        Card card = this.card.toModel();
        return new Transaction(this.id, this.value, establishment, card, this.effectedIn);
    }
}
