package com.rouge41.kmm.compose

@MustBeDocumented
@Retention(AnnotationRetention.BINARY)
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY, // (DEPRECATED)
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.TYPE
)
expect annotation class ComposableContract
