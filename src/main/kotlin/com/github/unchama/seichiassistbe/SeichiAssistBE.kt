package com.github.unchama.seichiassistbe

import cn.nukkit.level.GameRule
import cn.nukkit.plugin.PluginBase
import com.github.unchama.seichiassistbe.listener.DebugListener
import com.github.unchama.seichiassistbe.listener.FormListener

@Suppress("unused")
class SeichiAssistBE : PluginBase() {

    override fun onEnable() {
        this.server.levels.forEach { (_, level) -> level.gameRules.setGameRule(GameRule.PVP, false) }

        setOf(
                DebugListener,
                FormListener
        ).forEach { listener -> server.pluginManager.registerEvents(listener, this) }
    }

}