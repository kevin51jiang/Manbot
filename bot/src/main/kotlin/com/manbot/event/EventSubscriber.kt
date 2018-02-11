package com.manbot.event

/**
 * @author Pavan C. (pavan407)
 */
@FunctionalInterface
interface EventSubscriber<E : Event>
{
    fun subscribe(event: E)
}