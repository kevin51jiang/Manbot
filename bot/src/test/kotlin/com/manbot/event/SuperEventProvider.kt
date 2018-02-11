package com.manbot.event

/**
 * @author Pavan C. (pavan407)
 */
open class SuperEventProvider : EventSubscriber<TestEvent>
{
    override fun subscribe(event: TestEvent)
    {
        println("Received subscription!")
    }
}