package com.github.unchama.seichiassistbe

import cn.nukkit.plugin.PluginBase
import com.github.unchama.seichiassistbe.listener.DebugListener
import com.github.unchama.seichiassistbe.listener.FormListener

@Suppress("unused")
class SeichiAssistBE : PluginBase() {

    override fun onEnable() {
        setOf(
                DebugListener,
                FormListener
        ).forEach { listener -> server.pluginManager.registerEvents(listener, this) }
    }

}