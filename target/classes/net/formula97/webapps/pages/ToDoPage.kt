package net.formula97.webapps.pages

import net.formula97.webapps.dao.ToDoDao
import net.formula97.webapps.entity.ToDo
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.form.TextArea
import org.apache.wicket.markup.html.list.ListItem
import org.apache.wicket.markup.html.list.ListView
import org.apache.wicket.model.CompoundPropertyModel
import org.apache.wicket.util.value.ValueMap

import java.util.*
import kotlin.collections.ArrayList

class ToDoPage() : WebPage() {

    private var todoList = Collections.synchronizedList(ArrayList<ToDo>())

    init {

        add(ToDoPostForm("todoPostForm"))

        // TODO: 2019/09/01 DBからレコードをとる処理を書く
        todoList = ToDoDao().getAllTodo()

        add(object : ListView<ToDo>("todoList", todoList) {
            override fun populateItem(item: ListItem<ToDo>?) {
                val todo = item!!.modelObject
                item.add(Label("createdAt", todo.createdAt!!.toString()))
                item.add(Label("todoTitle", todo.todoTitle!!))

                val f = if (todo.finished) "〇" else ""
                item.add(Label("finished", f))
            }
        })
    }

    inner class ToDoPostForm(id: String) : Form<ValueMap>(id, CompoundPropertyModel(ValueMap())) {

        init {
            markupId = "todoPostForm"
            add(TextArea<String>("todoTitle").setType(String::class.java))
        }

        override fun onSubmit() {
            super.onSubmit()

            val valueMap = modelObject

            val todo = ToDo(null)
            todo.todoTitle = valueMap["todoTitle"] as String
            todo.createdAt = Date()
            todo.finished = false

            // TODO: 2019/09/01 DBにレコードを追加する処理を書く
            ToDoDao().addToDo(todo)

            valueMap["todoTitle"] = ""

            todoList = ToDoDao().getAllTodo()
        }

    }

    companion object {
        private val serialVersionUID = 944675860908734695L
    }
}
