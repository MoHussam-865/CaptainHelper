package com.android_a865.captainhelper.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android_a865.captainhelper.databinding.AdapterDayViewBinding
import com.android_a865.captainhelper.feature_home.data.DayEntity

class DaysAdapter(
    private val listener: OnItemEventListener
) : ListAdapter<DayEntity, DaysAdapter.ViewHolder>(InvoiceDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            AdapterDayViewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class ViewHolder(private val binding: AdapterDayViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.edit.setOnClickListener() {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = getItem(position)
                    listener.onItemClicked(item)
                }
            }

        }

        fun bind(day: DayEntity) {
            binding.apply {

                edit.isVisible = !day.done

                dayView.text = day.day.toString()

                profit.text = day.profits.toString()

                val tax = day.made * 0.1
                val other = day.made - day.profits
                details.text = "${day.made}$ . ${day.km} Km . tax $tax$ . other $other$"

            }
        }
    }


    class InvoiceDiffCallback : DiffUtil.ItemCallback<DayEntity>() {
        override fun areItemsTheSame(oldItem: DayEntity, newItem: DayEntity): Boolean {
            return (oldItem.date == newItem.date)
        }

        override fun areContentsTheSame(oldItem: DayEntity, newItem: DayEntity): Boolean =
            oldItem == newItem
    }

    interface OnItemEventListener {
        fun onItemClicked(day: DayEntity)
    }

}