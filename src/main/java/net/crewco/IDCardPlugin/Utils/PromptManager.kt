package net.crewco.IDCardPlugin.Utils

import net.crewco.IDCardPlugin.IDCardPlugin.Companion.playerData
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class PromptManager {
	var promptCount = 3
	var listcount = 0
	 fun promptUser(player: Player) {
		player.sendMessage("Please fill out the following information:")

		// Start collecting information
		playerData[player] = mutableListOf("Name", "Age", "Bio")
		askForInput(player)
	}

	 fun askForInput(player: Player) {
		val prompts = playerData[player]
		 val prompt = prompts?.get(0)
		 player.sendMessage("$prompt:")
		 promptCount -=1
	}

	fun countPromptsSent():Int{
		return promptCount
	}

	fun promptadd(): String{
		val list = mutableListOf("Name", "Age", "Bio")
		return list[listcount++]

	}

}