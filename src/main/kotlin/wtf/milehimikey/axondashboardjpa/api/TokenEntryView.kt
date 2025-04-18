package wtf.milehimikey.axondashboardjpa.api

data class TokenEntryView(
    val processorName: String,
    val segment: Int,
    val tokenType: String?,
    val timestamp: String?,
    val owner: String?
)
