package wtf.milehimikey.axondashboardjpa.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.Lob
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name = "token_entry")
@IdClass(TokenEntryId::class)
data class TokenEntry(
    @Id
    @Column(name = "processor_name", nullable = false)
    val processorName: String,

    @Id
    @Column(name = "segment", nullable = false)
    val segment: Int,

    @Lob
    @Column(name = "token")
    val token: ByteArray? = null,

    @Column(name = "token_type")
    val tokenType: String? = null,

    @Column(name = "timestamp")
    val timestamp: String? = null,

    @Column(name = "owner")
    val owner: String? = null
) {
    // Override equals and hashCode because of ByteArray field
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TokenEntry

        if (processorName != other.processorName) return false
        if (segment != other.segment) return false
        if (token != null) {
            if (other.token == null) return false
            if (!token.contentEquals(other.token)) return false
        } else if (other.token != null) return false
        if (tokenType != other.tokenType) return false
        if (timestamp != other.timestamp) return false
        if (owner != other.owner) return false

        return true
    }

    override fun hashCode(): Int {
        var result = processorName.hashCode()
        result = 31 * result + segment
        result = 31 * result + (token?.contentHashCode() ?: 0)
        result = 31 * result + (tokenType?.hashCode() ?: 0)
        result = 31 * result + (timestamp?.hashCode() ?: 0)
        result = 31 * result + (owner?.hashCode() ?: 0)
        return result
    }
}

// Composite key class for TokenEntry
data class TokenEntryId(
    val processorName: String = "",
    val segment: Int = 0
) : Serializable
