package com.example.demo.Controller

import com.example.demo.Service.UserInfoService
import com.example.demo.Controller.UserInfo
import com.example.demo.Controller.UserInfoController
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.util.*
import kotlin.math.exp


class UserInfoControllerTest {

    @Nested
    inner class GetUserInfo {
        // mockkによるモック
        private val mockedUserInfoService = mockk<UserInfoService>()

        @Test
        fun `getUserInfoを呼び出したとき、200OKが返ってくる`() {
            every { mockedUserInfoService.getUserInfoService() } returns emptyList()

            val mockMvc = MockMvcBuilders.standaloneSetup(UserInfoController(mockedUserInfoService)).build()
            mockMvc.get("/api/userinfo").andExpect { status { isOk() } }
        }

        @Test
        fun serviceのgetUserInfoServiceを呼び出していること() {
            val mockMvc = MockMvcBuilders.standaloneSetup(UserInfoController(mockedUserInfoService)).build()

            mockMvc.get("/api/userinfo")

            verify(exactly = 1) {
                mockedUserInfoService.getUserInfoService()
            }
        }
            @Test
            fun 呼び出されたserviceのgetUserInfoの返り値が正しいこと() {
                val dummyUserInfo = listOf(
                    UserInfo(
                        UUID.fromString("05294e0e-5146-4066-86da-0481d8dbd9c5"),
                        "taro",
                        "tarochan",
                        13,
                        "Kotlin"
                    )
                )

                every { mockedUserInfoService.getUserInfoService() } returns dummyUserInfo
                val mockMvc = MockMvcBuilders.standaloneSetup(UserInfoController(mockedUserInfoService)).build()

                mockMvc.get("/api/userinfo")

                    .andExpect {
                        jsonPath("$[0].id") {
                            value(("05294e0e-5146-4066-86da-0481d8dbd9c5").toString())
                        }
                    }
                    .andExpect {
                        jsonPath("$[0].name") {
                            value("taro")
                        }
                    }
                    .andExpect {
                        jsonPath("$[0].nickName") {
                            value("tarochan")
                        }
                    }
                    .andExpect {
                        jsonPath("$[0].fnd") {
                            value(13)
                        }
                    }
                    .andExpect {
                        jsonPath("$[0].onePhrase") {
                            value("Kotlin")
                        }
                    }
            }

        }
    }


