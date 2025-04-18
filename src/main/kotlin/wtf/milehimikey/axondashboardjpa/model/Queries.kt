package wtf.milehimikey.axondashboardjpa.model

import org.springframework.data.jpa.repository.JpaRepository

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
