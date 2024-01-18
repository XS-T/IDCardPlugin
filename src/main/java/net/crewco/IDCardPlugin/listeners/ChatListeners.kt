package net.crewco.IDCardPlugin.listeners

import net.crewco.IDCardPlugin.IDCardPlugin.Companion.playerData
import net.crewco.IDCardPlugin.IDCardPlugin.Companion.promptManager
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack


class ChatListeners : Listener {
	@EventHandler
	fun onPlayerChat(event: AsyncPlayerChatEvent) {
		val player = event.player
		val prompts = playerData[player]

		if (!prompts.isNullOrEmpty()) {
			event.isCancelled = true // Cancel the normal chat behavior

			val prompt = prompts[0]
			val inputList = playerData.computeIfAbsent(player) { mutableListOf() }

			// Save the player's response
			inputList.add(event.message)

			// Move to the next prompt or generate the ID
			prompts.removeAt(0)
			if (prompts.isNotEmpty() && promptManager.countPromptsSent() != 0) {
				promptManager.askForInput(player)
			} else {
				// All information collected, generate ID
				generateAndGiveID(player)
				// Clean up the input map
				playerData.remove(player)
			}
		}
	}
	private fun generateAndGiveID(player: Player) {
		val idPaper = ItemStack(Material.PAPER)
		val meta = idPaper.itemMeta

		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&a&lID-Card"))

		// Add player information to the lore of the paper
		val lore: MutableList<String> = ArrayList()
		playerData[player]?.forEach { response ->
			lore.add("${ChatColor.translateAlternateColorCodes('&',"&7&l${promptManager.promptadd()}")}:$response")
		}

		meta.lore = lore
		meta.addEnchant(Enchantment.DURABILITY,5,true)
		meta.itemFlags.add(ItemFlag.HIDE_ENCHANTS)
		idPaper.itemMeta = meta

		// Give the paper to the player
		player.inventory.addItem(idPaper)
		player.sendMessage("Your ID paper has been created and added to your inventory.")
	}
}