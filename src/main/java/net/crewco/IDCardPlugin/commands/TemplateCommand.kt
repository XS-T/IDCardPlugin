package net.crewco.IDCardPlugin.commands

import cloud.commandframework.annotations.CommandDescription
import cloud.commandframework.annotations.CommandMethod
import cloud.commandframework.annotations.CommandPermission
import com.google.inject.Inject
import net.crewco.IDCardPlugin.IDCardPlugin
import org.bukkit.entity.Player

class TemplateCommand @Inject constructor(private val plugin: IDCardPlugin) {
	@CommandMethod("templatecommand")
	@CommandDescription("Template Command")
	@CommandPermission("templateplugin.command.templatecommand")
	suspend fun template(player: Player) {
	}
}