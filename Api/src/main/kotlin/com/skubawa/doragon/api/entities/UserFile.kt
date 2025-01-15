package com.skubawa.doragon.api.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity
class UserFile {
    @Id
    val id: UUID = UUID.randomUUID()
    val bucketName: String = String()
    val objectId: String = String()
}