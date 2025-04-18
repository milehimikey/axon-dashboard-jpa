package wtf.milehimikey.axondashboardjpa.api

data class DomainEventEntryView(
    val globalIndex: Long = 0,
    val aggregateIdentifier: String,
    val sequenceNumber: Long,
    val type: String? = null,
    val eventIdentifier: String,
    val metaData: ByteArray? = null,
    val payload: ByteArray,
    val payloadRevision: String? = null,
    val payloadType: String,
    val timeStamp: String
)

