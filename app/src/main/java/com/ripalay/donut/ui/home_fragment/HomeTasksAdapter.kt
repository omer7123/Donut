package com.ripalay.donut.ui.home_fragment

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ripalay.donut.core.models.Tasks
import com.ripalay.donut.databinding.ItemHomeTasksBinding
import com.ripalay.donut.databinding.ItemHomeTasksDarkBinding
import com.ripalay.donut.databinding.ItemTasksBinding
import com.ripalay.donut.databinding.ItemTasksLightBinding
import com.ripalay.donut.ui.tasks_fragment.TasksAdapter

class HomeTasksAdapter(private val clickListener: (task: Tasks) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list: ArrayList<Tasks> = ArrayList<Tasks>()


    override fun getItemViewType(position: Int): Int {
        var i = 0
        if (position % 2 == 0) {
            i = 1
        } else {
            i = 0
        }

        return i
    }

    inner class ViewHolderLight(private val binding: ItemHomeTasksBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(tasks: Tasks) {
            binding.personTv.text = tasks.author
            binding.priceTv.text = tasks.price.toString()
            binding.tasksTv.text = tasks.task
            binding.root.setOnClickListener {
                clickListener(tasks)
            }
        }

    }

    inner class ViewHolderDark(private val binding: ItemHomeTasksDarkBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(tasks: Tasks) {
            binding.personTv.text = tasks.author
            binding.priceTv.text = tasks.price.toString()
            binding.tasksTv.text = tasks.task
            binding.root.setOnClickListener {
                clickListener(tasks)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1) {

            val binding =
                ItemHomeTasksDarkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ViewHolderDark(binding)
        } else {

            val binding =
                ItemHomeTasksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ViewHolderLight(binding)

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == 1) {
            (holder as HomeTasksAdapter.ViewHolderDark).onBind(list[position])
        } else {
            (holder as HomeTasksAdapter.ViewHolderLight).onBind(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addItems(baseList: ArrayList<Tasks>) {
        // list.sort(Comparator.comparing(NewsModel::getCreatedAt));
        // Collections.reverse(list);
        list.clear()
        list.addAll(baseList)
        Log.e("ololo", baseList.size.toString())
        notifyDataSetChanged()
    }
}