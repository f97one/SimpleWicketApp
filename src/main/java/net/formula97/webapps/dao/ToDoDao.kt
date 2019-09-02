package net.formula97.webapps.dao

import net.formula97.webapps.entity.ToDo

class ToDoDao : DatabaseHelper() {
    fun getAllTodo() : MutableList<ToDo> {
        var ret: MutableList<ToDo> = mutableListOf()

        val sql = "select todo_id, todo_title, created_at, finished from todo"
        try {
           val conn = connection
            conn.use {
                val query = conn.createQuery(sql).setAutoDeriveColumnNames(true)
                ret = query.executeAndFetch(ToDo::class.java)
            }
        } catch(e: Exception) {

        }

        return ret
    }

    fun addToDo(todo: ToDo) {
        val sql = "insert into todo (todo_title, created_at, finished) values (:todoTitle, :createdAt, :finished)"

        val tran = connectionWithTran
        tran.use {
            val stmt = tran.createQuery(sql)
                    .addParameter("todoTitle", todo.todoTitle)
                    .addParameter("createdAt", todo.createdAt)
                    .addParameter("finished", todo.finished)

            stmt.executeUpdate()

            tran.commit()
        }
    }
}