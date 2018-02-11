package com.manbot.event

import com.google.common.collect.ArrayListMultimap
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass

/**
 * @author Pavan C. (pavan407)
 */
class UniversalEventProvider<E : Event> : EventProvider<E>
{
    private val subscribers = ArrayListMultimap.create<KClass<out E>, EventSubscriber<out E>>()

    override fun provideSubscriber(subscriber: EventSubscriber<out E>)
    {
        subscribers.put(getSubscriberEventClass(subscriber), subscriber)
    }

    override fun depriveSubscriber(subscriber: EventSubscriber<E>)
    {
        subscribers.remove(getSubscriberEventClass(subscriber), subscriber)
    }

    private fun getSubscriberEventClass(subscriber: EventSubscriber<out E>): KClass<out E>
    {
        var clazz: Class<*> = subscriber::class.java
        var interIndex = -1

        while (clazz != Object::class && interIndex == -1)
        {
            interIndex = clazz.interfaces.indexOfFirst { inter -> inter == EventSubscriber::class.java }
            // If the interface was found
            if (interIndex != -1)
                break
            // Else repeat the check on the superclass, assuming it isn't Object
            else
                clazz = clazz.superclass
        }

        val type = clazz.genericInterfaces[interIndex] as ParameterizedType
        val eventClass = type.actualTypeArguments[0] as Class<out E>
        return eventClass.kotlin
    }

    override fun pulseEvent(event: E)
    {
        subscribers[event::class]?.forEach({ subscriber -> (subscriber as EventSubscriber<E>).subscribe(event) })
    }

    override fun <T : E> getSubscribers(clazz: KClass<T>) = subscribers[clazz] as Collection<EventSubscriber<T>>
}