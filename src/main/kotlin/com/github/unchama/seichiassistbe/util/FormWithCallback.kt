package com.github.unchama.seichiassistbe.util

import cn.nukkit.event.player.PlayerFormRespondedEvent
import cn.nukkit.form.element.ElementButton
import cn.nukkit.form.response.FormResponse
import cn.nukkit.form.window.FormWindow
import cn.nukkit.form.window.FormWindowSimple

@Suppress("CanBeParameter", "unused")
class WindowWithCallback(
        private val title: String, // due to Nukkit
        private val content: String, // due to Nukkit
        buttonsWithCallback: List<Pair<ElementButton, (PlayerFormRespondedEvent) -> Unit>>) : FormWindow() {
    private val simpleWindow = FormWindowSimple(title, content).apply {
        buttonsWithCallback.forEach { (button, _) -> addButton(button) }
    }
    private val callbacks = buttonsWithCallback.map { it.second }

    // due to Nukkit
    private val type = "form"
    private val buttons = buttonsWithCallback.map { it.first }
    private var callback: (PlayerFormRespondedEvent) -> Unit = {}

    override fun wasClosed(): Boolean = simpleWindow.wasClosed()
    override fun getResponse(): WindowWithCallbackResponse? {
        val simpleResponse = simpleWindow.response ?: return null

        return WindowWithCallbackResponse(simpleResponse.clickedButtonId, simpleResponse.clickedButton, callback)
    }

    override fun setResponse(data: String?) {
        simpleWindow.setResponse(data)
        callback = if (wasClosed()) {
            {}
        } else {
            data?.toIntOrNull()?.let { callbacks.getOrNull(it) } ?: return
        }
    }
}

data class WindowWithCallbackResponse(
        val clickedButtonId: Int,
        val clickedButton: ElementButton,
        val onClick: (PlayerFormRespondedEvent) -> Unit) : FormResponse()