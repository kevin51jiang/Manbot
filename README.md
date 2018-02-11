# Manbot
An easily extensible [Discord](https://discordapp.com/ "Discord") bot.

### Plugin support
Currently, Manbot searches for plugins (class files) contained in the *plugins* project build output.

#### Creating a plugin
You can easily create a plugin class that will be dynamically loaded upon runtime by implementing the ```Plugin``` interface like so:
```java
public class MyPlugin implements MyPlugin
{
	@Override
	public void onInit()
	{
		System.out.println("I've been given life!");
	}
}
```
You can also extend off some wrapper classes for a solving a particular problem, which is often more convenient. Handling commands for example:
```java
public class MyCommandHandler extends CommandHandler
{
    public MyCommandHandler()
    {
        super("mycmd", "Description here", ArgumentAmount.anyLength(), UserType.LEARNER, "Usage here");
    }

    @Override
    public void handle(CommandEvent event) throws CommandException
    {
        event.getChannel().sendMessage(event.getUser().getAsMention() + " Hello world.").queue();
    }
}
```
Or performing a task every so often:
```java
import java.util.concurrent.TimeUnit

public class TickTock extends Service
{
	public TickTock()
	{
		super(1, TimeUnit.MINUTES);
	}

	@Override
	public void run()
	{
		// This will be executed once every minute
		System.out.println("Tick tock...");
	}
}
```

### Small Note for Developers
Since plugins are contained in their own Gradle module, you first need to build it before running the bot order for you to see your changes.
