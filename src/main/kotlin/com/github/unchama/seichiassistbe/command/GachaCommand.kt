package com.github.unchama.seichiassistbe.command

import cn.nukkit.command.Command
import cn.nukkit.command.CommandExecutor
import cn.nukkit.command.CommandSender

object GachaCommand : SafetyCommandExecutor {
    override fun onCommandExecuted(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        TODO("Not yet implemented")
    }

    override fun isAcceptable(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {
        TODO("Not yet implemented")
    }
}
