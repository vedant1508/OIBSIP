package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import com.example.todo.Task

import com.google.android.gms.tasks.Tasks

class ToDo : AppCompatActivity() {

    private lateinit var txttask:EditText
    private lateinit var btnaddtask:Button
    private lateinit var listviewtask: ListView
    private lateinit var tasks: MutableList<Task>
    private lateinit var taskTitles: MutableList<String>
    private lateinit var adapter:ArrayAdapter<String>
    private var taskid=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)

        val name=intent.getStringExtra(Signin.KEY1)

        val welcome=findViewById<TextView>(R.id.txtWelcome)
        val exit=findViewById<TextView>(R.id.btnexit)
        welcome.text="Welcome $name"


        txttask=findViewById(R.id.txttask)
        btnaddtask=findViewById(R.id.btnaddtask)
        listviewtask=findViewById(R.id.listviewtask)

        tasks= mutableListOf()
        taskTitles= mutableListOf()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, taskTitles)
        listviewtask.adapter = adapter

        btnaddtask.setOnClickListener {
            val title = txttask.text.toString()
            val task = Task(taskid++, title, false)
            tasks.add(task)
            taskTitles.add(task.title)
            adapter.notifyDataSetChanged()
            txttask.text.clear()
        }

        listviewtask.setOnItemClickListener { _, _, position, _ ->
            val task = tasks[position]
            task. isCompleted = !task.isCompleted
            adapter.notifyDataSetChanged()
        }

        exit.setOnClickListener {
            finish()
        }
    }
}