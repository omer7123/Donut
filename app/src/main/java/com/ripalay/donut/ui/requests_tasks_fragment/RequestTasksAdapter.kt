package com.ripalay.donut.ui.requests_tasks_fragment

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ripalay.donut.core.models.Tasks
import com.ripalay.donut.databinding.ItemRequestBinding

class RequestTasksAdapter(
    private val clickListener: (task: Tasks, status: Int) -> Unit
) : RecyclerView.Adapter<RequestTasksAdapter.ViewHolder>() {
    private val list: ArrayList<Tasks> = ArrayList<Tasks>()

    inner class ViewHolder(private val binding: ItemRequestBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(tasks: Tasks) {
            Log.e("Ololo", tasks.task.toString())
            binding.authorTv.text = tasks.author
            binding.priceTv.text = tasks.price.toString()
            binding.taskTv.text = tasks.task

            binding.cancelTv.setOnClickListener {
                clickListener(tasks, 0)
            }
            binding.acceptTv.setOnClickListener {
                clickListener(tasks, 1)
            }
            binding.root.setOnClickListener {
                clickListener(tasks, 2)
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RequestTasksAdapter.ViewHolder {
        val binding =
            ItemRequestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RequestTasksAdapter.ViewHolder, position: Int) {
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
    fun removeItem(tasks: Tasks) {
        list.removeAt(list.indexOf(tasks))
        notifyDataSetChanged()
    }

    fun clearItems() {
        list.clear()
        notifyDataSetChanged()
    }


}