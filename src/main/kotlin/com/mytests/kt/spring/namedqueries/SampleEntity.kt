package com.mytests.kt.spring.namedqueries

import jakarta.persistence.*

@Entity
@Table(name = "sample", schema = "jbtests")
@NamedQueries(
    value = [NamedQuery(name = "SampleEntity.query1",
        query = "select s from SampleEntity s where s.version > ?1"),
        NamedQuery(name = "SampleEntity.query2",
            query = "select s from SampleEntity s where s.color = ?1 and s.sample = ?2"
        )]
)
@NamedNativeQueries(
    NamedNativeQuery(name = "SampleEntity.nativeQuery1", query = "select id from sample where color = :color"),
    NamedNativeQuery(name = "SampleEntity.nativeQuery2", query = "select id from sample where sample = :sample")
)
open class SampleEntity {
    @get:Id
    @get:Column(name = "id", nullable = false)
    var id: Int? = null

    @get:Basic
    @get:Column(name = "version", nullable = true)
    var version: Int? = null

    @get:Basic
    @get:Column(name = "sample", nullable = true)
    var sample: String? = null

    @get:Basic
    @get:Column(name = "color", nullable = true)
    var color: String? = null


    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
                "id = $id " +
                "version = $version " +
                "sample = $sample " +
                "color = $color " +
                ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as SampleEntity

        if (id != other.id) return false
        if (version != other.version) return false
        if (sample != other.sample) return false
        if (color != other.color) return false

        return true
    }

}

