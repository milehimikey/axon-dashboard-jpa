package wtf.milehimikey.axondashboardjpa.api

data class SnapshotEventEntryView(
    val aggregateIdentifier: String,
    val sequenceNumber: Long,
    val type: String,
    val eventIdentifier: String,
    val payloadType: String,
    val timeStamp: String,
    val payloadRevision: String?
)
