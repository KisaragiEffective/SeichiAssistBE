package com.github.unchama.seichiassistbe.util

import cn.nukkit.event.player.PlayerFormRespondedEvent
import cn.nukkit.form.element.ElementButton
import cn.nukkit.form.element.ElementButtonImageData

class ButtonWithCallback : ElementButton {
    val onClick: (PlayerFormRespondedEvent) -> Unit

    constructor(text: String, onClick: (PlayerFormRespondedEvent) -> Unit) : super(text) {
        this.onClick = onClick
    }

    constructor(text: String, image: ElementButtonImageData, onClick: (PlayerFormRespondedEvent) -> Unit) : super(text, image) {
        this.onClick = onClick
    }

}