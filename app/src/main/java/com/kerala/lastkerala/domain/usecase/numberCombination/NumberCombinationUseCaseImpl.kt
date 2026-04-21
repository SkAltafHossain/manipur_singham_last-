package com.altaf.haryanalast.domain.usecase.numberCombination

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NumberCombinationUseCaseImpl @Inject constructor() : NumberCombinationUseCase {

    override operator fun invoke(query: String?): List<String> {
        val trimmed = query?.trim().orEmpty()

        if (trimmed.isEmpty()) {
            // Return empty list when no query
            return emptyList()
        }

        if (trimmed.length != 4 || !trimmed.all { it.isDigit() }) {
            // Only accept exactly 4 digits
            return emptyList()
        }

        // Generate all unique permutations of the 4-digit number
        return generatePermutations(trimmed).distinct().sorted()
    }

    private fun generatePermutations(input: String): List<String> {
        val result = mutableListOf<String>()
        permute(input.toCharArray(), 0, input.length - 1, result)
        return result
    }

    private fun permute(str: CharArray, left: Int, right: Int, result: MutableList<String>) {
        if (left == right) {
            result.add(String(str))
        } else {
            for (i in left..right) {
                str.swap(left, i)
                permute(str, left + 1, right, result)
                str.swap(left, i) // backtrack
            }
        }
    }

    private fun CharArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}