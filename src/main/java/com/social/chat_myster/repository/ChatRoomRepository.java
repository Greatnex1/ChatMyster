package com.social.chat_myster.repository;

import com.social.chat_myster.data.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {
    Collection<ChatRoom> findByParticipantIdsContains(String id);

}
