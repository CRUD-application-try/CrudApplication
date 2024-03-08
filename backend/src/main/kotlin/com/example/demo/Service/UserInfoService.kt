package com.example.demo.Service

import com.example.demo.Controller.UserInfo
import com.example.demo.Repository.UserInfoRepository
import org.springframework.stereotype.Service

interface UserInfoService{
    fun getUserInfoService():List<UserInfo>
}

@Service
class UserInfoServiceImpl(val repository: UserInfoRepository): UserInfoService {
    override fun getUserInfoService(): List<UserInfo> {
        val entityList = repository.findAll()
        return entityList.map{
            UserInfo(
                    it.id,
                    it.name,
                    it.nickName,
                    it.fnd,
                    it.onePhrase
            )
        }



    }

}