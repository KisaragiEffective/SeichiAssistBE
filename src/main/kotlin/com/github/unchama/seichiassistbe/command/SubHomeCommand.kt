package com.github.unchama.seichiassistbe.command

import cn.nukkit.Player
import cn.nukkit.command.Command
import cn.nukkit.command.CommandSender
import com.github.unchama.seichiassistbe.datastorage.HomeRecord
import com.github.unchama.seichiassistbe.datastorage.SubHomeRepository

object SubHomeCommand : SafetyCommandExecutor {
    override fun onCommandExecuted(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        sender as Player

        val idx = args[0].toIntOrNull()
        val pos = sender.location
        return if (idx != null && idx in 1..5) {
            SubHomeRepository[sender.uniqueId] = HomeRecord(
                    idx,
                    /* TODO: マルチワールド化する場合の対策 */"world",
                    pos.floorX,
                    pos.floorY,
                    pos.floorZ
            )
            true
        } else {
            sender.sendMessage("1..5")
            false
        }
    }

    override fun isAcceptable(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {
        return sender is Player && command != null && label != null && args != null && args.size == 1
    }
}