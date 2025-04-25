package com.social.chat_myster.service.interfaces;

import com.social.chat_myster.data.entity.ChatRoom;
import com.social.chat_myster.data.entity.ChatRoomMessage;
import com.social.chat_myster.data.entity.MysterUser;
import com.social.chat_myster.dto.response.ChatRoomResponse;
import com.social.chat_myster.exception.MysterUserException;

import java.util.List;
import java.util.Set;

public interface ChatUseCase {
    ChatRoom createGroupChat(MysterUser creator, String chatName, Set<String> participantIds) throws MysterUserException;
    void addParticipants(String chatRoomId, Set<String> participantIds) throws MysterUserException;
    void removeParticipant(String chatRoomId, String participantId);
    ChatRoom getChatRoom(String roomId);
    List<ChatRoomResponse> getUserChatRooms(MysterUser user);
    void addMessage(String chatRoomId, ChatRoomMessage message);
}
