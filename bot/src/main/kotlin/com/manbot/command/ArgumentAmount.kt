package com.manbot.command

/**
 * @author Pavan C. (pavan407)
 */
object ArgumentAmount
{
    @JvmStatic fun anyLength() = { _: Int -> true }
    @JvmStatic fun fixed(vararg fixes: Int) = { len: Int -> fixes.any { fix -> len == fix }.or(false) }
    @JvmStatic fun inbetween(min: Int, max: Int) = { len: Int -> len in min + 1 until max }
    @JvmStatic fun inbetweenOrEqualTo(min: Int, max: Int) = { len: Int -> len in min..max }
    @JvmStatic fun greaterThan(min: Int) = { len: Int -> len > min }
    @JvmStatic fun greaterThanOrEqualTo(min: Int) = { len: Int -> len >= min }
    @JvmStatic fun lessThan(max: Int) = { len: Int -> len < max }
    @JvmStatic fun lessThanOrEqualTo(max: Int) = { len: Int -> len <= max }
}
