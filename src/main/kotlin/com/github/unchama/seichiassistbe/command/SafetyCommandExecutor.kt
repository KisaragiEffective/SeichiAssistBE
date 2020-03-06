package com.github.unchama.seichiassistbe.command

import cn.nukkit.command.Command
import cn.nukkit.command.CommandExecutor
import cn.nukkit.command.CommandSender

interface SafetyCommandExecutor : CommandExecutor {
    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {
        return isAcceptable(sender, command, label, args) && onCommandExecuted(sender!!, command!!, label!!, args!!)
    }

    fun onCommandExecuted(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean

    fun isAcceptable(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean
}