package wtf.milehimikey.axondashboardjpa

import org.springframework.data.jpa.repository.JpaRepository
import wtf.milehimikey.axondashboardjpa.model.DeadLetterEntry
import wtf.milehimikey.axondashboardjpa.model.DomainEventEntry
import wtf.milehimikey.axondashboardjpa.model.SagaEntry
import wtf.milehimikey.axondashboardjpa.model.SnapshotEventEntry
import wtf.milehimikey.axondashboardjpa.model.SnapshotEventEntryId
import wtf.milehimikey.axondashboardjpa.model.TokenEntry
import wtf.milehimikey.axondashboardjpa.model.TokenEntryId

interface DomainEventEntryRepository: JpaRepository<DomainEventEntry, Long> {
}

interface SnapshotEventEntryRepository: JpaRepository<SnapshotEventEntry, SnapshotEventEntryId> {
}

interface SagaEntryRepository: JpaRepository<SagaEntry, String> {
}

interface TokenEntryRepository: JpaRepository<TokenEntry, TokenEntryId> {
}

interface DeadLetterEntryRepository: JpaRepository<DeadLetterEntry, String> {
}
