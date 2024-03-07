package com.example.demo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.util.*



class UserInfoControllerTest {

    @Nested
    inner class GetUserInfo{
        lateinit var spyUserInfoService:SpyUserInfoService

        @BeforeEach
        fun setup(){
            spyUserInfoService=SpyUserInfoService()
        }
    @Test
    fun getUserInfoを呼び出していること(){
        val mockMvc=MockMvcBuilders.standaloneSetup(UserInfoController(spyUserInfoService)).build()
        mockMvc.get("/api/userinfo").andExpect { status { isOk() } }
    }

    @Test
    fun serviceのgetUserInfoServiceを呼び出していること(){
        val mockMvc = MockMvcBuilders.standaloneSetup(UserInfoController(spyUserInfoService)).build()
        mockMvc.get("/api/userinfo")
        assertEquals(true, spyUserInfoService.getUserInfoService_isCalled)
    }

    @Test
    fun 呼び出されたserviceのgetUserInfoの返り値が正しいこと(){
        val stubUserInfoService=StubUserInfoService()
        val mockMvc=MockMvcBuilders.standaloneSetup(UserInfoController(stubUserInfoService)).build()

        mockMvc.get("/api/userinfo")
                .andExpect { jsonPath("$[0].id"){
                    value(("05294e0e-5146-4066-86da-0481d8dbd9c5").toString())
                }
            }
                .andExpect { jsonPath("$[0].name"){
                    value("taro")
                }
            }
                .andExpect { jsonPath("$[0].nickName"){
                    value("tarochan")
                }
            }
                .andExpect { jsonPath("$[0].fnd"){
                    value(13)
                }
            }
                .andExpect { jsonPath("$[0].onePhrase"){
                    value("Kotlin")
                }
            }
    }

    }
}

class SpyUserInfoService: UserInfoService{
    var getUserInfoService_isCalled = false
    override fun getUserInfoService():List<UserInfo>{
        getUserInfoService_isCalled = true
        return emptyList()
    }
}

class StubUserInfoService:UserInfoService{
    override fun getUserInfoService():List<UserInfo>{
        return listOf(UserInfo(UUID.fromString("05294e0e-5146-4066-86da-0481d8dbd9c5"),"taro","tarochan",13,"Kotlin"))
    }
}