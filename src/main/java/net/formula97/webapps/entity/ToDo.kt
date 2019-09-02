package net.formula97.webapps.entity

import java.io.Serializable
import java.util.*

data class ToDo(var todoId: Int?) : Serializable {
    var todoTitle: String? = null
    var createdAt: Date? = null
    var finished: Boolean = false

    companion object {
        private const val serialVersionUid: Long = -1L
    }
}