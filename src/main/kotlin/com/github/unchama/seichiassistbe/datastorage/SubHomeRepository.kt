package com.github.unchama.seichiassistbe.datastorage

import java.util.Optional
import java.util.UUID

object SubHomeRepository : Repository<UUID, HomeRecord> {
    private val delegate = hashMapOf<UUID, HomeRecord>()
    override fun set(key: UUID, value: HomeRecord) {
        delegate[key] = value
    }

    override fun get(key: UUID): Optional<HomeRecord> {
        return Optional.ofNullable(delegate[key])
    }

    override fun update(key: UUID, f: (UUID, Optional<HomeRecord>) -> HomeRecord) {
        delegate[key] = f(key, Optional.ofNullable(delegate[key]))
    }
}