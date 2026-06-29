package com.hunterteaser;

import com.google.inject.Provides;
import java.util.Random;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Hunter Teaser"
)
public class HunterTeaserPlugin extends Plugin
{
	@Inject
	private Client client;

	private static final String[] HUNTER_TEASING_INSULTS = {
			"Hey smelly!",
			"Hey stinky!",
			"You suck!",
			"Loser says what?",
			"You mad bro?"
	};

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked e)
	{
		if(e.getMenuOption().equals("Tease"))
		{
			Random rand = new Random();
			int randomIndex = rand.nextInt(HUNTER_TEASING_INSULTS.length);
			String insult = HUNTER_TEASING_INSULTS[randomIndex];

			client.getLocalPlayer().setOverheadCycle(100);
			client.getLocalPlayer().setOverheadText(insult);
		}
	}
}
