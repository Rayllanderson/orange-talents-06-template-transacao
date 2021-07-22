package br.com.zupacademy.rayllanderson.transacao.kafka.consumer.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstablishmentResponse {

    @JsonProperty("nome")
    private String name;
    @JsonProperty("cidade")
    private String city;
    @JsonProperty("endereco")
    private String address;

    @Deprecated
    private EstablishmentResponse() {
    }

    public EstablishmentResponse(String name, String city, String address) {
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
}
