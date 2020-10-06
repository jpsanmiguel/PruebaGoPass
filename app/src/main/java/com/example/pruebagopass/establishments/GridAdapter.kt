package com.example.pruebagopass.establishments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebagopass.databinding.GridItemBinding
import com.example.pruebagopass.models.EstablishmentInfo

class GridAdapter : androidx.recyclerview.widget.ListAdapter<EstablishmentInfo, GridAdapter.EstablishmentViewHolder>(DiffCallback) {
    class EstablishmentViewHolder(private var binding: GridItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(establishment: EstablishmentInfo) {
            binding.establishment = establishment
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<EstablishmentInfo>() {
        override fun areItemsTheSame(
            oldItem: EstablishmentInfo,
            newItem: EstablishmentInfo
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: EstablishmentInfo,
            newItem: EstablishmentInfo
        ): Boolean {
            return oldItem.idestablecimiento == newItem.idestablecimiento
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstablishmentViewHolder {
        return EstablishmentViewHolder(GridItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: EstablishmentViewHolder, position: Int) {
        val establishment = getItem(position)
        holder.bind(establishment)
    }
}