package br.com.zupacademy.rayllanderson.transacao.consumer.responses;

import br.com.zupacademy.rayllanderson.transacao.transaction.models.Establishment;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EstablishmentResponseMessage {

    @JsonProperty("nome")
    private String name;
    @JsonProperty("cidade")
    private String city;
    @JsonProperty("endereco")
    private String address;

    @Deprecated
    private EstablishmentResponseMessage() {
    }

    public EstablishmentResponseMessage(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public Establishment toModel(){
        return new Establishment(this.name, this.city, this.address);
    }
}
