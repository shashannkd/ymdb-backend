package com.ymdb.app.user.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "tbl_users_info")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Nonnull
    public String firstName;
    public String lastName;
    public Date dateofBirth;
    @Nonnull
    public String emailId;
    @Nonnull
    public String password;
    @Nonnull
    public String userId;
    public Date createdAt;
    public Date updatedAt;

}
