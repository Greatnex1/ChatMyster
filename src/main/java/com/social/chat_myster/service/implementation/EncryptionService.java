package com.social.chat_myster.service.implementation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EncryptionService {
    @Value("${encryption.secret-key}")
    private String secretKey;

    public String encrypt(String content) {
        // Implement AES encryption
        return null;
    }

    public String decrypt(String encryptedContent) {
        // Implement AES decryption
        return null;
    }
}
