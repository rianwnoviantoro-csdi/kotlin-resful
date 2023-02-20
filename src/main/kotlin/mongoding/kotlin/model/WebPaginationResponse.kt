package mongoding.kotlin.model

class WebPaginationResponse<T>(
    val code: Int,
    val status: String,
    val page: Int,
    val perPage: Int,
    val data: T
)