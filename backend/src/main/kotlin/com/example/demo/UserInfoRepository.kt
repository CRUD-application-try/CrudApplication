package com.example.demo

import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface  UserInfoRepository:JpaRepository<UserInfoEntity,UUID>
    @Entity
    @Table(name = "user")
    data class UserInfoEntity(
            @Id
            @GeneratedValue(strategy = GenerationType.UUID)
            val id:UUID,
            val name:String,
            val nickName:String,
            val fnd:Number,
            val onePhrase:String
    )
