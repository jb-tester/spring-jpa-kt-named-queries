package com.mytests.kt.spring.namedqueries

import org.springframework.data.repository.CrudRepository
import com.mytests.kt.spring.namedqueries.SampleEntity
import org.springframework.stereotype.Repository

/**
 * *
 *
 * Created by irina on 11/25/2021.
 *
 * Project: spring-jpa-kt-named-queries
 * *
 */
@Repository
interface SampleRepository : CrudRepository<SampleEntity?, Int?>{

    fun query1(version: Int): List<SampleEntity>
    fun query2(color: String, sample: String): List<SampleEntity>
    fun nativeQuery1(color: String): List<Int>
    fun nativeQuery2(sample: String): List<Int>

    fun findByColor(color: String): List<SampleEntity>

}