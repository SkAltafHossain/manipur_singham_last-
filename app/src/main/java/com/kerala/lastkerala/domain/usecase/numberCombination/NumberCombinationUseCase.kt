package com.altaf.haryanalast.domain.usecase.numberCombination

interface NumberCombinationUseCase {

    /**
     * When query is null or blank, return all 4-digit combinations (0000-9999).
     * When query has exactly 4 digits, return only that exact 4-digit number if it exists.
     * Otherwise, return an empty list.
     */
    operator fun invoke(query: String? = null): List<String>
}