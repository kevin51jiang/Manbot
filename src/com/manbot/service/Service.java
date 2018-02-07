package com.manbot.service;

import java.util.concurrent.TimeUnit;

public abstract class Service implements Runnable
{
    public final long initialDelay;
    public final long intervalDelay;
    public final TimeUnit timeUnit;

    protected Service(long initialDelaySeconds, long intervalDelaySeconds)
    {
        this(initialDelaySeconds, intervalDelaySeconds, TimeUnit.SECONDS);
    }

    protected Service(long initialDelay, long intervalDelay, TimeUnit unit)
    {
        this.initialDelay = initialDelay;
        this.intervalDelay = intervalDelay;
        this.timeUnit = unit;
    }
}
