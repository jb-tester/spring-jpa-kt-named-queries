package com.mytests.kt.spring.namedqueries

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * *
 *
 * Created by irina on 11/25/2021.
 *
 * Project: spring-jpa-kt-named-queries
 * *
 */
@Service
class DisplayService {
    @Autowired
    private val sampleRepository: SampleRepository? = null

    @Autowired
    private val contactRepository: ContactRepository? = null
    fun testContactQueries() {
        println("contact.query1: ")
        for (contact in contactRepository!!.query1("petrovskaya")) {
            println(contact)
        }
        println("contact.query2: ")
        for (contact in contactRepository.query2("irina")) {
            println(contact)
        }
        println("contact.nativequery1: ")
        for (contact in contactRepository.nativeQuery1("+79219986400")) {
            println(contact)
        }
        println("contact.nativequery2: ")
        for (contact in contactRepository.nativeQuery2("ai@jetbrains.com")) {
            println(contact)
        }
    }

    fun testSampleQueries() {
        println("sample.query1")
        for (sample in sampleRepository!!.query1(3)) {
            println(sample)
        }
        println("sample.query2")
        for (sample in sampleRepository.query2("red", "sample9")) {
            println(sample)
        }
        println("sample.nativequery1")
        for (sample in sampleRepository.nativeQuery1("blue")) {
            println(sample)
        }
        println("sample.nativequery2")
        for (sample in sampleRepository.nativeQuery2("sample12")) {
            println(sample)
        }
    }
}