package wtf.milehimikey.axondashboardjpa.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Lob
import jakarta.persistence.Table

@Entity
@Table(name = "saga_entry")
data class SagaEntry(
    @Id
    @Column(name = "saga_id", nullable = false)
    val sagaId: String,

    @Column(name = "revision")
    val revision: String? = null,

    @Column(name = "saga_type")
    val sagaType: String? = null,

    @Lob
    @Column(name = "serialized_saga")
    val serializedSaga: ByteArray? = null
) {
    // Override equals and hashCode because of ByteArray field
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SagaEntry

        if (sagaId != other.sagaId) return false
        if (revision != other.revision) return false
        if (sagaType != other.sagaType) return false
        if (serializedSaga != null) {
            if (other.serializedSaga == null) return false
            if (!serializedSaga.contentEquals(other.serializedSaga)) return false
        } else if (other.serializedSaga != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = sagaId.hashCode()
        result = 31 * result + (revision?.hashCode() ?: 0)
        result = 31 * result + (sagaType?.hashCode() ?: 0)
        result = 31 * result + (serializedSaga?.contentHashCode() ?: 0)
        return result
    }
}
