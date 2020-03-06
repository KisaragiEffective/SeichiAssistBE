package com.github.unchama.seichiassistbe.datastorage

import java.util.Optional

interface Repository<K : Any, V : Any> {
    operator fun set(key: K, value: V)

    operator fun get(key: K): Optional<V>

    fun update(key: K, f: (K, Optional<V>) -> V)
}