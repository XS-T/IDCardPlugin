package net.crewco.IDCardPlugin.Utils

import net.crewco.IDCardPlugin.IDCardPlugin.Companion.SynidMsg
import net.crewco.IDCardPlugin.IDCardPlugin.Companion.cage
import net.crewco.IDCardPlugin.IDCardPlugin.Companion.cbio
import net.crewco.IDCardPlugin.IDCardPlugin.Companion.cname
import net.crewco.IDCardPlugin.IDCardPlugin.Companion.playerData
import net.crewco.IDCardPlugin.IDCardPlugin.Companion.promptCheck
import org.bukkit.entity.Player

class PromptManager {
	private var promptCount = 3
	private var list_count = 0
	//var isDone = false
	 fun promptUser(player: Player) {
		player.sendMessage("$SynidMsg Please fill out the following information:")

		// Start collecting information
		playerData[player] = mutableListOf(cname, cage, cbio)
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

	fun getPrompt(): String{
		val list = mutableListOf("Name", "Age", "Bio")
		return list[list_count++]

	}

	fun isDone(player: Player):Boolean{
		return promptCheck.containsKey(player)
	}

}