package br.com.zupacademy.rayllanderson.transacao.transaction.response;

import br.com.zupacademy.rayllanderson.transacao.transaction.models.Card;

public class CardResponse {

    private final String id;
    private final String email;

    public CardResponse(Card card) {
        this.id = card.getId();
        this.email = card.getEmail();
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
