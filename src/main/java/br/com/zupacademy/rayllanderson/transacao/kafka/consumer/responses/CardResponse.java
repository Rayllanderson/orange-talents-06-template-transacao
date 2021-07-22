package br.com.zupacademy.rayllanderson.transacao.kafka.consumer.responses;

public class CardResponse {
    private String id;
    private String email;

    @Deprecated
    private CardResponse() {
    }

    public CardResponse(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
