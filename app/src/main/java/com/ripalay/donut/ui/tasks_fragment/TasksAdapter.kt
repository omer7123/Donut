package com.ripalay.donut.ui.tasks_fragment

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.ripalay.donut.core.models.Tasks
import com.ripalay.donut.databinding.ItemTasksBinding
import com.ripalay.donut.databinding.ItemTasksLightBinding

class TasksAdapter(
    private val clickListener: (task: Tasks) -> Unit
) : RecyclerView.Adapter<TasksAdapter.ViewHolder>() {
    private val list: ArrayList<Tasks> = ArrayList<Tasks>()

    inner class ViewHolder(private val binding: ItemTasksBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(tasks: Tasks) {
            Log.e("Ololo", tasks.task.toString())

            binding.authorTv.text = tasks.author
            binding.priceTv.text = tasks.price.toString()
            binding.taskTv.text = tasks.task
            if (tasks.describe != null) {
                binding.describeTv.isVisible = true
                binding.describeTv.text = tasks.describe
            } else {
                binding.describeTv.isVisible = false
            }
            binding.root.setOnClickListener {
                clickListener(tasks)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksAdapter.ViewHolder {
            val binding =
                ItemTasksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return(ViewHolder(binding))


    }

    override fun onBindViewHolder(holder: TasksAdapter.ViewHolder, position: Int) {
         holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addItems(baseList: ArrayList<Tasks>) {
        list.clear()
        list.addAll(baseList)
        Log.e("ololo", baseList.size.toString())
        notifyDataSetChanged()
    }

}