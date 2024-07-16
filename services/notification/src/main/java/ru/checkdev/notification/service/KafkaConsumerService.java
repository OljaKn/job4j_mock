package ru.checkdev.notification.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.checkdev.notification.domain.SubscribeCategory;
import ru.checkdev.notification.domain.SubscribeTopic;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {
    private final SubscribeCategoryService subscribeCategoryService;
    private final SubscribeTopicService subscribeTopicService;

    @KafkaListener(topics = "subscribeCategory", groupId = "group-id")
    public void handleSubscribeCategory(SubscribeCategory subscribeCategory) {
        subscribeCategoryService.save(subscribeCategory);
    }

    @KafkaListener(topics = "unsubscribeCategory", groupId = "group-id")
    public void handleUnsubscribeCategory(SubscribeCategory subscribeCategory) {
        subscribeCategoryService.delete(subscribeCategory);
    }

    @KafkaListener(topics = "subscribeTopic", groupId = "group-id")
    public void handleSubscribeTopic(SubscribeTopic subscribeTopic) {
        subscribeTopicService.save(subscribeTopic);
    }

    @KafkaListener(topics = "unsubscribeTopic", groupId = "group-id")
    public void handleUnsubscribeTopic(SubscribeTopic subscribeTopic) {
        subscribeTopicService.delete(subscribeTopic);
    }
}