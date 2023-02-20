package mongoding.kotlin.repository

import mongoding.kotlin.entity.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

interface ApiKeyRepository: JpaRepository<ApiKey, String> {

}