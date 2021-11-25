package com.mytests.kt.spring.namedqueries

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
class SpringJpaKtNamedQueriesApplication

fun main(args: Array<String>) {
    val ctx: ConfigurableApplicationContext = runApplication<SpringJpaKtNamedQueriesApplication>(*args)
    val service: DisplayService = ctx.getBean("displayService") as DisplayService
    service.testContactQueries()
    service.testSampleQueries()


}
