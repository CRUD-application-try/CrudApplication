package com.example.demo.Service

import com.example.demo.Controller.UserInfo
import com.example.demo.Repository.UserInfoEntity
import com.example.demo.Repository.UserInfoRepository
import com.example.demo.Service.UserInfoServiceImpl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.query.FluentQuery
import java.util.*
import java.util.function.Function

class UserInfoServiceTest {

    @Nested
    inner class GetUserInfo {
        @Test
        fun UserInfoRepositoryのfindALLを呼んでいるか() {
            val spyRepository = SpyRepository()
            val userInfoService = UserInfoServiceImpl(spyRepository)
            userInfoService.getUserInfoService()
            assertEquals(true, spyRepository.getUser_isCalled)

        }

        @Test
        fun UserInfoRepositoryのfindAllを正しい値で呼んでいるか() {
            val stubRepository = StubRepository()
            val userInfoService = UserInfoServiceImpl(stubRepository)

            val result: List<UserInfo> = userInfoService.getUserInfoService()

            assertEquals(listOf(UserInfo(UUID.fromString("05294e0e-5146-4066-86da-0481d8dbd9c5"), "jiro", "jirochan", 13, "SpringBoot")), result)
        }
    }
}

class StubRepository : UserInfoRepository {
    override fun <S : UserInfoEntity?> save(entity: S & Any): S & Any {
        TODO("Not yet implemented")
    }

    override fun <S : UserInfoEntity?> saveAll(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun findById(id: UUID): Optional<UserInfoEntity> {
        TODO("Not yet implemented")
    }

    override fun existsById(id: UUID): Boolean {
        TODO("Not yet implemented")
    }

    override fun <S : UserInfoEntity?> findAll(example: Example<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun <S : UserInfoEntity?> findAll(example: Example<S>, sort: Sort): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableList<UserInfoEntity> {
        val uuid: UUID = UUID.fromString("05294e0e-5146-4066-86da-0481d8dbd9c5")
        return mutableListOf(UserInfoEntity(id = uuid, name = "jiro", nickName = "jirochan", fnd = 13, onePhrase = "SpringBoot"))
    }

    override fun findAll(sort: Sort): MutableList<UserInfoEntity> {
        TODO("Not yet implemented")
    }

    override fun findAll(pageable: Pageable): Page<UserInfoEntity> {
        TODO("Not yet implemented")
    }

    override fun <S : UserInfoEntity?> findAll(example: Example<S>, pageable: Pageable): Page<S> {
        TODO("Not yet implemented")
    }

    override fun findAllById(ids: MutableIterable<UUID>): MutableList<UserInfoEntity> {
        TODO("Not yet implemented")
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }

    override fun <S : UserInfoEntity?> count(example: Example<S>): Long {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: UUID) {
        TODO("Not yet implemented")
    }

    override fun delete(entity: UserInfoEntity) {
        TODO("Not yet implemented")
    }

    override fun deleteAllById(ids: MutableIterable<UUID>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<UserInfoEntity>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun <S : UserInfoEntity?> findOne(example: Example<S>): Optional<S> {
        TODO("Not yet implemented")
    }

    override fun <S : UserInfoEntity?> exists(example: Example<S>): Boolean {
        TODO("Not yet implemented")
    }

    override fun <S : UserInfoEntity?, R : Any?> findBy(example: Example<S>, queryFunction: Function<FluentQuery.FetchableFluentQuery<S>, R>): R & Any {
        TODO("Not yet implemented")
    }

    override fun flush() {
        TODO("Not yet implemented")
    }

    override fun <S : UserInfoEntity?> saveAndFlush(entity: S & Any): S & Any {
        TODO("Not yet implemented")
    }

    override fun <S : UserInfoEntity?> saveAllAndFlush(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun deleteAllInBatch(entities: MutableIterable<UserInfoEntity>) {
        TODO("Not yet implemented")
    }

    override fun deleteAllInBatch() {
        TODO("Not yet implemented")
    }

    override fun deleteAllByIdInBatch(ids: MutableIterable<UUID>) {
        TODO("Not yet implemented")
    }

    override fun getOne(id: UUID): UserInfoEntity {
        TODO("Not yet implemented")
    }

    override fun getById(id: UUID): UserInfoEntity {
        TODO("Not yet implemented")
    }

    override fun getReferenceById(id: UUID): UserInfoEntity {
        TODO("Not yet implemented")
    }

}

class SpyRepository : UserInfoRepository {
    var getUser_isCalled = false
    override fun <S : UserInfoEntity?> save(entity: S & Any): S & Any {
        TODO("Not yet implemented")
    }

    override fun <S : UserInfoEntity?> saveAll(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun findById(id: UUID): Optional<UserInfoEntity> {
        TODO("Not yet implemented")
    }

    override fun existsById(id: UUID): Boolean {
        TODO("Not yet implemented")
    }

    override fun <S : UserInfoEntity?> findAll(example: Example<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun <S : UserInfoEntity?> findAll(example: Example<S>, sort: Sort): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableList<UserInfoEntity> {
        getUser_isCalled = true
        return mutableListOf()

    }

    override fun findAll(sort: Sort): MutableList<UserInfoEntity> {
        TODO("Not yet implemented")
    }

    override fun findAll(pageable: Pageable): Page<UserInfoEntity> {
        TODO("Not yet implemented")
    }

    override fun <S : UserInfoEntity?> findAll(example: Example<S>, pageable: Pageable): Page<S> {
        TODO("Not yet implemented")
    }

    override fun findAllById(ids: MutableIterable<UUID>): MutableList<UserInfoEntity> {
        TODO("Not yet implemented")
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }

    override fun <S : UserInfoEntity?> count(example: Example<S>): Long {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: UUID) {
        TODO("Not yet implemented")
    }

    override fun delete(entity: UserInfoEntity) {
        TODO("Not yet implemented")
    }

    override fun deleteAllById(ids: MutableIterable<UUID>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<UserInfoEntity>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun <S : UserInfoEntity?> findOne(example: Example<S>): Optional<S> {
        TODO("Not yet implemented")
    }

    override fun <S : UserInfoEntity?> exists(example: Example<S>): Boolean {
        TODO("Not yet implemented")
    }

    override fun <S : UserInfoEntity?, R : Any?> findBy(example: Example<S>, queryFunction: Function<FluentQuery.FetchableFluentQuery<S>, R>): R & Any {
        TODO("Not yet implemented")
    }

    override fun flush() {
        TODO("Not yet implemented")
    }

    override fun <S : UserInfoEntity?> saveAndFlush(entity: S & Any): S & Any {
        TODO("Not yet implemented")
    }

    override fun <S : UserInfoEntity?> saveAllAndFlush(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun deleteAllInBatch(entities: MutableIterable<UserInfoEntity>) {
        TODO("Not yet implemented")
    }

    override fun deleteAllInBatch() {
        TODO("Not yet implemented")
    }

    override fun deleteAllByIdInBatch(ids: MutableIterable<UUID>) {
        TODO("Not yet implemented")
    }

    override fun getOne(id: UUID): UserInfoEntity {
        TODO("Not yet implemented")
    }

    override fun getById(id: UUID): UserInfoEntity {
        TODO("Not yet implemented")
    }

    override fun getReferenceById(id: UUID): UserInfoEntity {
        TODO("Not yet implemented")
    }

}