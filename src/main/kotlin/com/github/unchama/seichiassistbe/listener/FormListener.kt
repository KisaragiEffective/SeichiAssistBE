package com.github.unchama.seichiassistbe.listener

import cn.nukkit.event.EventHandler
import cn.nukkit.event.Listener
import cn.nukkit.event.player.PlayerFormRespondedEvent
import com.github.unchama.seichiassistbe.util.WindowWithCallbackResponse

@Suppress("unused")
object FormListener : Listener {

    @EventHandler
    fun onRespondForm(event: PlayerFormRespondedEvent) {
        (event.response as? WindowWithCallbackResponse)?.onClick?.invoke(event) ?: return
    }

}