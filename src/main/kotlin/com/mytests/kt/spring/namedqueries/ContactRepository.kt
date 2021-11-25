package com.mytests.kt.spring.namedqueries

import org.springframework.data.repository.RepositoryDefinition
import org.springframework.data.repository.query.Param

/**
 * *
 *
 * Created by irina on 11/25/2021.
 *
 * Project: spring-jpa-kt-named-queries
 * *
 */
@RepositoryDefinition(domainClass = ContactEntity::class, idClass = Int::class)
interface ContactRepository
{
    fun query1(lastname: String): List<ContactEntity>
    fun query2(firstname: String): List<ContactEntity>
    fun nativeQuery1(@Param("telephone") telephone: String): List<String>
    fun nativeQuery2(@Param("email") email: String): List<String>
}