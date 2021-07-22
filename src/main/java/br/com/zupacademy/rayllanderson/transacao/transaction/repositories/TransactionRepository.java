package br.com.zupacademy.rayllanderson.transacao.transaction.repositories;

import br.com.zupacademy.rayllanderson.transacao.transaction.models.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, String> {
    Page<Transaction> findAllByCard_Id(String cardId, Pageable pageable);
    boolean existsByCard_Id(String cardId);
}
