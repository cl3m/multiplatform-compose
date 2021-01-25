package com.rouge41.kmm.compose.runtime

@MustBeDocumented
@Retention(AnnotationRetention.BINARY)
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY, // (DEPRECATED)
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.TYPE
)
actual annotation class ComposableContract