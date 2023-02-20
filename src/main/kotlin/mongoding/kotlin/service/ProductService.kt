package mongoding.kotlin.service

import mongoding.kotlin.model.CreateProductRequest
import mongoding.kotlin.model.ListProductRequest
import mongoding.kotlin.model.ProductResponse
import mongoding.kotlin.model.UpdateProductRequest

interface ProductService {
    fun create(createProductRequest: CreateProductRequest): ProductResponse

    fun get(id: String): ProductResponse

    fun update(id: String, updateProductRequest: UpdateProductRequest) : ProductResponse

    fun delete(id: String)

    fun list(listProductRequest: ListProductRequest): List<ProductResponse>
}