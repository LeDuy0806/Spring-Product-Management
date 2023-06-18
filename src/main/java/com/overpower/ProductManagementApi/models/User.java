package com.overpower.ProductManagementApi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
//    private String firstName;
//    private String lastName;
    private String avatar;
    private String userType;
    @Indexed(unique = true)
    private String userName;
    @Indexed(unique = true)
    private String mail;
//    private String password;
    private Boolean isVerified;
    private Integer point;

    public User(User user) {
        this.avatar = user.getAvatar() != null ? user.getAvatar() : "";
        this.mail= user.getMail() != null ? user.getMail() : "";
        this.userName =user.getUserName() != null ? user.getUserName() : "";
        this.userType =user.getUserType() != null ? user.getUserType() : "";
        this.isVerified = user.getIsVerified() != null ? user.getIsVerified() : false;
        this.point = user.getPoint() != null ? user.getPoint() : 0;
    }
}
