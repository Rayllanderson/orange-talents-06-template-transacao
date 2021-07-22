package br.com.zupacademy.rayllanderson.transacao.transaction.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Card {

    @Id
    private String id;

    @NotBlank
    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "card")
    private final Set<Transaction> transactions = new HashSet<>();

    @Deprecated
    private Card() {
    }

    public Card(String id, String email) {
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
