package net.crewco.IDCardPlugin

import net.crewco.IDCardPlugin.Utils.PromptManager
import net.crewco.IDCardPlugin.commands.IDCommand
import net.crewco.IDCardPlugin.listeners.ChatListeners
import net.crewco.common.CrewCoPlugin
import org.bukkit.entity.Player

class IDCardPlugin : CrewCoPlugin() {
	companion object{
		lateinit var plugin:IDCardPlugin
			private set
		lateinit var playerData:MutableMap<Player, MutableList<String>>
		lateinit var promptManager: PromptManager
	}
	override suspend fun onEnableAsync() {
		super.onEnableAsync()

		//Inits
		plugin = this
		playerData = HashMap()
		promptManager = PromptManager()

		//Config
		plugin.config.options().copyDefaults()
		plugin.saveDefaultConfig()
		registerCommands(IDCommand::class)
		registerListeners(ChatListeners::class)

	}

	override suspend fun onDisableAsync() {
		super.onDisableAsync()
	}
}