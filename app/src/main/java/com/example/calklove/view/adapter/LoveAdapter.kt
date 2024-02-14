package com.example.calklove.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calklove.databinding.ItemLoveBinding
import com.example.calklove.remote.LoveModel

class LoveAdapter(
    private val OnLongClick: (LoveModel) -> Unit
) :
    RecyclerView.Adapter<LoveAdapter.LoveViewHolder>() {

    val list = arrayListOf<LoveModel>()

    fun addlovs(lovs: List<LoveModel>) {
        list.clear()
        list.addAll(lovs)
        notifyDataSetChanged()
    }

    fun removeTask(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoveViewHolder {
        return LoveViewHolder(
            ItemLoveBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LoveViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class LoveViewHolder(private val binding: ItemLoveBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(loveModel: LoveModel) = with(binding) {
            tvFname.text = loveModel.firstName
            tvSecondname.text = loveModel.secondName
            tvPercentage.text = loveModel.percentage
            tvResult.text = loveModel.result


            itemView.setOnLongClickListener {
                OnLongClick(loveModel)
                false
            }
        }
    }
}