package br.com.zupacademy.rayllanderson.transacao.consumer.listeners;

import br.com.zupacademy.rayllanderson.transacao.transaction.repositories.TransactionRepository;
import br.com.zupacademy.rayllanderson.transacao.consumer.responses.TransactionMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionListener {

    private final Logger logger = LoggerFactory.getLogger(TransactionListener.class);
    private final TransactionRepository repository;

    @Autowired
    public TransactionListener(TransactionRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listen(TransactionMessage transactionMessage) {
        try{
            logger.info("Ouvindo nova transação de id {}, e cartão de id {}", transactionMessage.getId(), transactionMessage.getCardId());
            repository.save(transactionMessage.toModel());
            logger.info("Transação de id {} foi salva com sucesso!", transactionMessage.getId());
        } catch (Exception e){
            logger.error("Não foi possível salvar transação de id {}. Motivo: {}", transactionMessage.getId(), e.getMessage());
        }
    }

}
