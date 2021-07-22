package br.com.zupacademy.rayllanderson.transacao.kafka.consumer.listeners;

import br.com.zupacademy.rayllanderson.transacao.kafka.consumer.responses.TransactionMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionListener {

    private final Logger logger = LoggerFactory.getLogger(TransactionListener.class);

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransactionMessage transactionMessage) {
        logger.info("----- Nova transação! -----");
        logger.info("Id {}", transactionMessage.getId());
        logger.info("Valor {}", transactionMessage.getValue());
        logger.info("Efetuado em  {}", transactionMessage.getEffectedIn());
        logger.info("Nome do estabelecimento {}", transactionMessage.getEstablishmentName());
        logger.info("Cidade do estabelecimento {}", transactionMessage.getEstablishmentCity());
        logger.info("Endereço do estabelecimento {}", transactionMessage.getEstablishmentAddress());
    }

}
