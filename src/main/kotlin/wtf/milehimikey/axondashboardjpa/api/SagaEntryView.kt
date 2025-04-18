package wtf.milehimikey.axondashboardjpa.api

data class SagaEntryView(
    val sagaId: String,
    val revision: String?,
    val sagaType: String?
)
