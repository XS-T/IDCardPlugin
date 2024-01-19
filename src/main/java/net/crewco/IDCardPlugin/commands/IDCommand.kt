package net.crewco.IDCardPlugin.commands

import cloud.commandframework.annotations.CommandDescription
import cloud.commandframework.annotations.CommandMethod
import cloud.commandframework.annotations.CommandPermission
import com.google.inject.Inject
import net.crewco.IDCardPlugin.IDCardPlugin
import net.crewco.IDCardPlugin.IDCardPlugin.Companion.playerData
import net.crewco.IDCardPlugin.IDCardPlugin.Companion.promptCheck
import net.crewco.IDCardPlugin.IDCardPlugin.Companion.promptManager
import org.bukkit.entity.Player

class IDCommand @Inject constructor(private val plugin: IDCardPlugin) {
	@CommandMethod("id")
	@CommandDescription("Template Command")
	@CommandPermission("id.command.use")
	fun onUses(player:Player){
		promptManager.promptUser(player)
		// Adds the player to promptCheck map
		promptCheck[player] = false

	}
}