package com.altaf.manipursingham.domain.mapper

interface Mapper<in T, out R> {
    fun map(from: T): R
}
