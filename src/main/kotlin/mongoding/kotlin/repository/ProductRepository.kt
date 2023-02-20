package mongoding.kotlin.repository

import mongoding.kotlin.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, String> {

}