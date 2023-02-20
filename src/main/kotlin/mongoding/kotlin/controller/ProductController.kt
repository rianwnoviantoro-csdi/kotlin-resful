package mongoding.kotlin.controller

import mongoding.kotlin.model.*
import mongoding.kotlin.service.ProductService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ProductController(val productService: ProductService) {
    @PostMapping(
        value = ["/products"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody body: CreateProductRequest): WebResponse<ProductResponse> {
        val productResponse = productService.create(body)
        return WebResponse(
            code = 200,
            status = "Success",
            data = productResponse
        )
    }

    @GetMapping(
        value = ["/products/{idProduct}"],
        produces = ["application/json"]
    )
    fun getProduct(@PathVariable("idProduct") id: String): WebResponse<ProductResponse> {
        val productResponse = productService.get(id)
        return WebResponse(
            code = 200,
            status = "Success",
            data = productResponse
        )
    }

    @PutMapping(
        value = ["/products/{idProduct}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateProduct(@PathVariable("idProduct") id: String, @RequestBody body: UpdateProductRequest): WebResponse<ProductResponse> {
        val productResponse = productService.update(id, body)
        return WebResponse(
            code = 200,
            status = "Success",
            data = productResponse
        )
    }

    @DeleteMapping(
        value = ["/products/{idProduct}"],
        produces = ["application/json"]
    )
    fun deleteProduct(@PathVariable("idProduct") id: String): WebResponse<String> {
        productService.delete(id)

        return WebResponse(
            code = 200,
            status = "Success",
            data = id + "Deleted"
        )
    }

    @GetMapping(
        value = ["/products"],
        produces = ["application/json"]
    )
    fun listProducts(
        @RequestParam(value = "size", defaultValue = "10") size: Int,
        @RequestParam(value = "page", defaultValue = "1") page: Int
    ): WebPaginationResponse<List<ProductResponse>> {
        val productRequest = ListProductRequest(page - 1, size)
        val productResponse = productService.list(productRequest)

        return WebPaginationResponse(
            code = 200,
            status = "Success",
            page = page,
            perPage = size,
            data = productResponse
        )
    }
}