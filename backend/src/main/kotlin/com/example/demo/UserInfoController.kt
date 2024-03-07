package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api")
class UserInfoController(val service:UserInfoService) {
    @GetMapping("/userinfo")
    fun getUserInfo() : List<UserInfo>{
       return service.getUserInfoService()
    }
}

data class UserInfo(
        val id:UUID,
        val name:String,
        val nickName:String,
        val fnd:Number,
        val onePhrase:String
)