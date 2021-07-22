package br.com.zupacademy.rayllanderson.transacao.transaction.controller;

import br.com.zupacademy.rayllanderson.transacao.transaction.models.Transaction;
import br.com.zupacademy.rayllanderson.transacao.transaction.repositories.TransactionRepository;
import br.com.zupacademy.rayllanderson.transacao.transaction.response.TransactionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/cards")
public class FindTransactionsController {

    private final TransactionRepository transactionRepository;
    private final Logger logger = LoggerFactory.getLogger(FindTransactionsController.class);

    @Autowired
    public FindTransactionsController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/{cardId}/transactions")
    public ResponseEntity<?> find(@PathVariable String cardId,
                                  @PageableDefault(sort = "effectedIn", direction = Sort.Direction.DESC) Pageable pageable){
        logger.info("Cartão de id {} foi consultado", cardId);

        boolean cardNotExists = !transactionRepository.existsByCard_Id(cardId);
        if (cardNotExists){
            logger.warn("Falha ao consultar cartão. Motivo: Cartão não encontrado");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Page<Transaction> transactions = transactionRepository.findAllByCard_Id(cardId, pageable);

        return ResponseEntity.ok(TransactionResponse.fromModelPage(transactions));
    }
}
