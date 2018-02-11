package com.manbot.event

import kotlin.reflect.KClass

/**
 * @author Pavan C. (pavan407)
 */
interface EventProvider<E : Event>
{
    fun provideSubscriber(subscriber: EventSubscriber<out E>)
    fun provideSubscribers(vararg subscribers: EventSubscriber<out E>) =
            subscribers.forEach { subscriber -> provideSubscriber(subscriber) }

    fun depriveSubscriber(subscriber: EventSubscriber<E>)
    fun depriveSubscribers(vararg subscribers: EventSubscriber<E>) =
        subscribers.forEach { subscriber -> depriveSubscriber(subscriber) }

    fun pulseEvent(event: E)

    fun <T : E> getSubscribers(clazz: KClass<T>): Collection<EventSubscriber<T>>?
    fun <T : E> getSubscribers(clazz: Class<T>) = getSubscribers(clazz.kotlin)
}