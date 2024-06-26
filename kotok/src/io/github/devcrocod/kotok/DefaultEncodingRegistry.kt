package io.github.devcrocod.kotok

import io.github.devcrocod.kotok.api.EncodingType

public class DefaultEncodingRegistry : AbstractEncodingRegistry() {
    public fun initializeDefaultEncodings() = EncodingType.entries.forEach { type ->
        addEncoding(type)
    }
}