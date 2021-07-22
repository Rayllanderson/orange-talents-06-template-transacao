package br.com.zupacademy.rayllanderson.transacao.transaction.response;

import br.com.zupacademy.rayllanderson.transacao.transaction.models.Establishment;

public class EstablishmentResponse {

    private final String name;
    private final String city;
    private final String address;

    public EstablishmentResponse(Establishment establishment) {
        this.name = establishment.getName();
        this.city = establishment.getCity();
        this.address = establishment.getAddress();
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
