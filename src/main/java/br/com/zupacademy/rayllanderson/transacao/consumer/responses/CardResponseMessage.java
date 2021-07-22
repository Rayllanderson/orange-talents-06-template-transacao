package br.com.zupacademy.rayllanderson.transacao.consumer.responses;


import br.com.zupacademy.rayllanderson.transacao.transaction.models.Card;

public class CardResponseMessage {
    private String id;
    private String email;

    @Deprecated
    private CardResponseMessage() {
    }

    public CardResponseMessage(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Card toModel() {
        return new Card(this.id, this.email);
    }
}
