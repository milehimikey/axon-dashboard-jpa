package wtf.milehimikey.axondashboardjpa.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.Lob
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name = "snapshot_event_entry")
@IdClass(SnapshotEventEntryId::class)
data class SnapshotEventEntry(
    @Id
    @Column(name = "aggregate_identifier", nullable = false)
    val aggregateIdentifier: String,

    @Id
    @Column(name = "sequence_number", nullable = false)
    val sequenceNumber: Long,

    @Column(name = "type", nullable = false)
    val type: String,

    @Column(name = "event_identifier", nullable = false, unique = true)
    val eventIdentifier: String,

    @Lob
    @Column(name = "meta_data")
    val metaData: ByteArray? = null,

    @Lob
    @Column(name = "payload", nullable = false)
    val payload: ByteArray,

    @Column(name = "payload_revision")
    val payloadRevision: String? = null,

    @Column(name = "payload_type", nullable = false)
    val payloadType: String,

    @Column(name = "time_stamp", nullable = false)
    val timeStamp: String
) {
    // Override equals and hashCode because of ByteArray fields
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SnapshotEventEntry

        if (aggregateIdentifier != other.aggregateIdentifier) return false
        if (sequenceNumber != other.sequenceNumber) return false
        if (type != other.type) return false
        if (eventIdentifier != other.eventIdentifier) return false
        if (metaData != null) {
            if (other.metaData == null) return false
            if (!metaData.contentEquals(other.metaData)) return false
        } else if (other.metaData != null) return false
        if (!payload.contentEquals(other.payload)) return false
        if (payloadRevision != other.payloadRevision) return false
        if (payloadType != other.payloadType) return false
        if (timeStamp != other.timeStamp) return false

        return true
    }

    override fun hashCode(): Int {
        var result = aggregateIdentifier.hashCode()
        result = 31 * result + sequenceNumber.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + eventIdentifier.hashCode()
        result = 31 * result + (metaData?.contentHashCode() ?: 0)
        result = 31 * result + payload.contentHashCode()
        result = 31 * result + (payloadRevision?.hashCode() ?: 0)
        result = 31 * result + payloadType.hashCode()
        result = 31 * result + timeStamp.hashCode()
        return result
    }
}

// Composite key class for SnapshotEventEntry
data class SnapshotEventEntryId(
    val aggregateIdentifier: String = "",
    val sequenceNumber: Long = 0
) : Serializable
