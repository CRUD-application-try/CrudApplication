package com.example.demo

interface UserInfoService{
    fun getUserInfoService():List<UserInfo>

}

class UserInfoServiceImpl(val repository: UserInfoRepository):UserInfoService{
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