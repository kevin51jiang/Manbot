package com.manbot.user

/**
 * @author Pavan C. (pavan407)
 */
enum class UserType
{
    LEARNER, INTERMEDIATE, ADVANCED, MENTOR, ADMIN;

    fun greaterThan(other: UserType) = compareTo(other) > 0
    fun greaterThanOrEqualTo(other: UserType) = compareTo(other) >= 0

    fun lessThan(other: UserType) = compareTo(other) < 0
    fun lessThanOrEqualTo(other: UserType) = compareTo(other) <= 0
}
