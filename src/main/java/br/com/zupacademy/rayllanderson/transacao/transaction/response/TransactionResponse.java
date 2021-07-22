package br.com.zupacademy.rayllanderson.transacao.transaction.response;

import br.com.zupacademy.rayllanderson.transacao.transaction.models.Transaction;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponse {

    private final String id;
    private final BigDecimal value;
    private final EstablishmentResponse establishment;
    private final CardResponse card;
    private final LocalDateTime effectedIn;

    public TransactionResponse(String id, BigDecimal value, EstablishmentResponse establishment, CardResponse card, LocalDateTime effectedIn) {
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

    public EstablishmentResponse getEstablishment() {
        return establishment;
    }

    public CardResponse getCard() {
        return card;
    }

    public LocalDateTime getEffectedIn() {
        return effectedIn;
    }

    private static TransactionResponse fromModel(Transaction transaction){
        var card = new CardResponse(transaction.getCard());
        var establishment = new EstablishmentResponse(transaction.getEstablishment());
        return new TransactionResponse(transaction.getId(), transaction.getValue(),
                establishment, card, transaction.getEffectedIn());
    }

    public static Page<TransactionResponse> fromModelPage(Page<Transaction> pageOfTransactions){
        return pageOfTransactions.map(TransactionResponse::fromModel);
    }
}
