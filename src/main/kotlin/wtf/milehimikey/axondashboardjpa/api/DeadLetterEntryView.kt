package wtf.milehimikey.axondashboardjpa.api

import java.time.LocalDateTime

data class DeadLetterEntryView(
    val deadLetterId: String,
    val queueId: String,
    val sequenceIdentifier: Long,
    val sequenceIndex: Long,
    val messageType: String,
    val messageId: String,
    val causeMessage: String?,
    val causeType: String?,
    val enqueuedAt: LocalDateTime,
    val lastTouched: LocalDateTime,
    val processingStarted: LocalDateTime?,
    val processingGroup: String
)
