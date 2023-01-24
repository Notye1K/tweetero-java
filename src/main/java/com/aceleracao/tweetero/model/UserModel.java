package com.aceleracao.tweetero.model;

import com.aceleracao.tweetero.DTO.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class UserModel {

    public UserModel(UserDTO data) {
        this.username = data.username();
        this.avatar = data.avatar();
    }

    @Id
    @Column(length = 255, nullable = false)
    private String username;

    @Column(nullable = false)
    private String avatar;
}
