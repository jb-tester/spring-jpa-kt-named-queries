package com.mytests.kt.spring.namedqueries

import com.mytests.kt.spring.namedqueries.ContactEntity
import java.util.*
import javax.persistence.*

/**
 * *
 *
 * Created by irina on 11/25/2021.
 *
 * Project: spring-jpa-kt-named-queries
 * *
 */
@Entity
@Table(name = "contact", schema = "jbtests")
@NamedQueries(
    value = [NamedQuery(name = "ContactEntity.query1",
                        query = "select c from ContactEntity c where c.lastname = ?1"),
             NamedQuery(name = "ContactEntity.query2",
                        query = "select c from ContactEntity c where c.firstname = ?1"
    )]
)
@NamedNativeQueries(
    NamedNativeQuery(name = "ContactEntity.nativeQuery1",
                     query = "select firstname from contact where telephone = :telephone"),
    NamedNativeQuery(name = "ContactEntity.nativeQuery2",
                     query = "select firstname from contact where email = :email")
)
class ContactEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    var id = 0

    @Basic
    @Column(name = "firstname")
    var firstname: String? = null

    @Basic
    @Column(name = "lastname")
    var lastname: String? = null

    @Basic
    @Column(name = "telephone")
    var telephone: String? = null

    @Basic
    @Column(name = "email")
    var email: String? = null


    override fun toString(): String {
        return "ContactEntity(id=$id, firstname=$firstname, lastname=$lastname, telephone=$telephone, email=$email)"
    }

}