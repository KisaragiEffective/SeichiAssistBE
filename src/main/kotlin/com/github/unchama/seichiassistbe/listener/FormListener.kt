package com.github.unchama.seichiassistbe.listener

import cn.nukkit.event.EventHandler
import cn.nukkit.event.Listener
import cn.nukkit.event.player.PlayerFormRespondedEvent
import cn.nukkit.form.response.FormResponseSimple
import com.github.unchama.seichiassistbe.util.ButtonWithCallback

object FormListener : Listener {

    @EventHandler
    fun onRespondForm(event: PlayerFormRespondedEvent) {
        val button = (event.response as? FormResponseSimple)?.clickedButton as? ButtonWithCallback ?: return
        button.onClick(event)
    }

}