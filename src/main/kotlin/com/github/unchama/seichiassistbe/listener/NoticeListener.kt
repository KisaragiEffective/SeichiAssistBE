package com.github.unchama.seichiassistbe.listener

import cn.nukkit.event.EventHandler
import cn.nukkit.event.player.PlayerJoinEvent
import cn.nukkit.event.Listener;
import cn.nukkit.utils.TextFormat

@Suppress("unused")
object NoticeListener : Listener {

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        event.player.sendMessage("${TextFormat.RED}このサーバは現在デバッグ鯖として動いています, 急な仕様変更やデータ削除の可能性があります")
    }

}
