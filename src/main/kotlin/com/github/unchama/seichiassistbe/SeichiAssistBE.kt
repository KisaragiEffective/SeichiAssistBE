package com.github.unchama.seichiassistbe

import cn.nukkit.command.PluginCommand
import cn.nukkit.plugin.PluginBase
import com.github.unchama.seichiassistbe.command.GachaCommand
import com.github.unchama.seichiassistbe.command.StickCommand
import com.github.unchama.seichiassistbe.command.SubHomeCommand

@Suppress("unused")
class SeichiAssistBE : PluginBase() {
    init {
        instance = this
    }

    override fun onEnable() {
        mapOf(
                "gacha" to GachaCommand,
                // map: Dynmapがないため実装不可能
                // ef
                // seichihaste
                // seichiassist
                // openpocket
                // lastquit
                "stick" to StickCommand,
                // rmp
                // shareinv
                // mebius
                // achievement
                // halfguard
                // event
                // contribute
                "subhome" to SubHomeCommand
                // gtfever
                // minehead
                // x-transfer: 保護プラグインがないため実装不可能

        ).forEach { (cmd, executor) ->
            // しかしこうしないとダメなのだ
            (getCommand(cmd) as? PluginCommand<*>)?.executor = executor
        }
    }

    companion object {
        lateinit var instance: SeichiAssistBE
    }
}
