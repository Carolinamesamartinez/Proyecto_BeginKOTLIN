package com.cmesamartinez.proyecto_beginkotlin.TODOApp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cmesamartinez.proyecto_beginkotlin.R
import com.cmesamartinez.proyecto_beginkotlin.TODOApp.TaskCategory.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TodoActivity : AppCompatActivity() {

    private lateinit var rvCategories:RecyclerView
    private lateinit var rvTasks:RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var fabAddTask: FloatingActionButton

    private val categories=listOf(
        Business,
        Personal,
        Other
    )
    private val tasks= mutableListOf(
        Task("pBusiness", Business,false),
        Task("PPersonal", Personal,false),
        Task("POther", Other,false)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponent()
        initUI()
        initListeners()
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener{
            showDialog()
        }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)
        val btndialogAddTask: Button =dialog.findViewById(R.id.btnAddTask)
        val etTask:EditText=dialog.findViewById(R.id.etTask)
        val rgCategories:RadioGroup=dialog.findViewById(R.id.rgCategory)
        btndialogAddTask.setOnClickListener {
            val currentTask=etTask.text.toString()
            if(currentTask.isNotEmpty()){
                val selectid=rgCategories.checkedRadioButtonId
                val selectedRadioButton:RadioButton=rgCategories.findViewById(selectid)
                val currentCategory:TaskCategory=when(selectedRadioButton.text){
                    getString(R.string.dialogbusiness)->Business
                    getString(R.string.dialogpersonal)->Personal
                    else -> Other
                }
                tasks.add(Task(etTask.text.toString(),currentCategory))
                updateTasks()
                dialog.hide()
            }

        }
        dialog.show()
    }

    private fun initComponent() {
        rvCategories=findViewById(R.id.rvCategories)
        rvTasks=findViewById(R.id.rvTasks)
        fabAddTask=findViewById(R.id.fabAddTask)
    }

    private fun initUI() {
        categoriesAdapter= CategoriesAdapter(categories){position -> updateCategories(position)}
        rvCategories.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvCategories.adapter=categoriesAdapter

        taskAdapter= TaskAdapter(tasks) { position -> onItemSelected(position) }
        rvTasks.layoutManager=LinearLayoutManager(this)
        rvTasks.adapter=taskAdapter

    }

    private fun onItemSelected(position:Int){
        tasks[position].isSelected=!tasks[position].isSelected
        updateTasks()
    }

    private fun updateCategories(position:Int){
        categories[position].isSelected=!categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTasks()

    }

    private fun updateTasks(){
        val selectedCategories:List<TaskCategory> = categories.filter{it.isSelected}
        val newTasks=tasks.filter{selectedCategories.contains(it.category)}
        taskAdapter.tasks=newTasks
        taskAdapter.notifyDataSetChanged()
    }
}