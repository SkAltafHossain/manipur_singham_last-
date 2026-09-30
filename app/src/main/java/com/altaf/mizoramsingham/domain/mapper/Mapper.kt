package com.altaf.manipursinghamlast.domain.mapper

interface Mapper<in T, out R> {
    fun map(from: T): R
}
