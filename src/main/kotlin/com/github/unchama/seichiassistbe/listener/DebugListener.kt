package com.github.unchama.seichiassistbe.listener

import cn.nukkit.event.EventHandler
import cn.nukkit.event.Listener
import cn.nukkit.event.player.PlayerInteractEvent
import cn.nukkit.form.window.FormWindowSimple
import cn.nukkit.item.Item
import com.github.unchama.seichiassistbe.util.ButtonWithCallback

object DebugListener : Listener {

    @EventHandler
    fun `show a menu with buttons on clicking a stick`(event: PlayerInteractEvent) {
        val player = event.player ?: return

        if (!player.isOp
                || event.action != PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK
                || event.item?.id != Item.STICK) return

        event.player.showFormWindow(
                FormWindowSimple(
                        "title",
                        "description",
                        ('A'..'Z').map { alphabet -> ButtonWithCallback("$alphabet") { it.player.sendMessage("You clicked '$alphabet' !") } }
                )
        )
    }

}