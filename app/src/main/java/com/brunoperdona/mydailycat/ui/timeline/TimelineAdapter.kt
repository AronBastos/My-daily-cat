package com.brunoperdona.mydailycat.ui.timeline

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.brunoperdona.mydailycat.databinding.DailyItemBinding


class TimelineAdapter(): RecyclerView.Adapter<TimelineAdapter.ViewHolder>(){

    private val asyncListDiffer: AsyncListDiffer<DailyItem> = AsyncListDiffer(this, DiffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DailyItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(asyncListDiffer.currentList[position])
    }

    override fun getItemCount(): Int {
        return asyncListDiffer.currentList.size
    }

    fun addDaily(dailyItem: DailyItem){
        asyncListDiffer.submitList(listOf(dailyItem))
    }

    class ViewHolder(
        private val binding: DailyItemBinding,
    ): RecyclerView.ViewHolder(binding.root){

        fun bind(dailyItem: DailyItem){
            binding.cardDay.text = dailyItem.day
            binding.dailyMessage.text = dailyItem.message
            binding.dispositionScore.text = dailyItem.disposition.toString()
            binding.dailyCard.setOnClickListener{
                Log.d("CardAdapter", "Click on card")
            }
        }
    }

    object DiffCallback: DiffUtil.ItemCallback<DailyItem>(){
        override fun areItemsTheSame(oldItem: DailyItem, newItem: DailyItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: DailyItem, newItem: DailyItem): Boolean {
            return oldItem.day == newItem.day
        }

    }
}