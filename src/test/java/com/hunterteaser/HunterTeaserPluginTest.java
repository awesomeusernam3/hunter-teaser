package com.hunterteaser;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class HunterTeaserPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(HunterTeaserPlugin.class);
		RuneLite.main(args);
	}
}