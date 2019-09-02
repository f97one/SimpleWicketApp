package net.formula97.webapps.dao

import org.sql2o.Connection
import org.sql2o.Sql2o
import java.util.*

open class DatabaseHelper {
    val database: Sql2o = Sql2o(String.format(Locale.getDefault(), "%s:%d/%s", DRIVER_URL, DRIVER_PORT, DATABASE_NAME), DB_USERNAME, DB_PASSWORD)

    companion object {
        const val DRIVER_URL : String = "jdbc:mysql://localhost"
        const val DRIVER_PORT : Int = 3306
        const val DATABASE_NAME : String = "generic_use_schema"
        const val DB_USERNAME : String = "general"
        const val DB_PASSWORD : String = "general"
    }

    val connection: Connection
        get() {
            return database.open()
        }

    val connectionWithTran: Connection
        get() {
            return database.beginTransaction()
        }

    fun getConnectionWithTran(isolationLevel: Int): Connection {
        return database.beginTransaction(isolationLevel)
    }
}