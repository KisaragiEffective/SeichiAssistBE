package com.github.unchama.seichiassistbe.command

import cn.nukkit.Player
import cn.nukkit.command.Command
import cn.nukkit.command.CommandSender
import cn.nukkit.item.Item

object StickCommand : SafetyCommandExecutor {
    override fun onCommandExecuted(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val playerInv = (sender as Player).inventory
        val stick = Item.get(Item.STICK)
        val emptyIndex = playerInv.firstEmpty(stick)
        // there's empty slot
        if (emptyIndex != -1) {
            playerInv.setItem(emptyIndex, stick)
        }

        return true
    }

    override fun isAcceptable(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {
        return sender is Player && command != null && label != null && args != null
    }
}