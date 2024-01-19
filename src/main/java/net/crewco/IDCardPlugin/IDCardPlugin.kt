package net.crewco.IDCardPlugin

import net.crewco.IDCardPlugin.Utils.PromptManager
import net.crewco.IDCardPlugin.commands.IDCommand
import net.crewco.IDCardPlugin.listeners.ChatListeners
import net.crewco.common.CrewCoPlugin
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class IDCardPlugin : CrewCoPlugin() {
	companion object{
		lateinit var plugin:IDCardPlugin
			private set
		lateinit var playerData:MutableMap<Player, MutableList<String>>
		lateinit var promptManager: PromptManager
		lateinit var SynidMsg: String
		lateinit var promptCheck: MutableMap<Player,Boolean>
	}
	override suspend fun onEnableAsync() {
		super.onEnableAsync()

		//Inits
		plugin = this
		playerData = HashMap()
		promptManager = PromptManager()
		SynidMsg = ChatColor.translateAlternateColorCodes('&',"&7[&x&9&2&0&c&f&b&lS&x&8&8&1&6&d&d&ly&x&7&e&2&0&b&f&ln&x&7&4&2&a&a&1&ld&x&7&6&2&c&a&0&li&x&7&9&2&f&9&f&lC&x&7&b&3&1&9&e&lr&x&8&9&3&2&a&e&la&x&9&8&3&3&b&e&lf&x&a&6&3&4&c&e&lt&7]>")
		promptCheck = mutableMapOf()

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