package net.crewco.IDCardPlugin

import net.crewco.common.CrewCoPlugin

class IDCardPlugin : CrewCoPlugin() {
	companion object{
		lateinit var plugin:IDCardPlugin
			private set
	}
	override suspend fun onEnableAsync() {
		super.onEnableAsync()

		//Inits
		plugin = this

		//Config
		plugin.config.options().copyDefaults()
		plugin.saveDefaultConfig()

	}

	override suspend fun onDisableAsync() {
		super.onDisableAsync()
	}
}