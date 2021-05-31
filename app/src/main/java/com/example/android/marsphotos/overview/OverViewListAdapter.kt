package com.example.android.marsphotos.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.databinding.GridViewItemBinding
import com.example.android.marsphotos.network.MarsPhoto

/*
Extend the PhotoGridAdapter class from ListAdapter with the constructor parameters
shown below. The PhotoGridAdapter class extends ListAdapter, whose constructor needs the list item type,
the view holder, and a DiffUtil.ItemCallback implementation.
 */
class OverViewListAdapter: ListAdapter<MarsPhoto, OverViewListAdapter.OverViewListViewHolder>(DiffCallBack) {

    class OverViewListViewHolder(private val binding : GridViewItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(MarsPhoto: MarsPhoto) {
            binding.photo = MarsPhoto
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverViewListViewHolder {
        return OverViewListViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: OverViewListViewHolder, position: Int) {
       val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<MarsPhoto>() {
        override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.imgSrcUrl == newItem.imgSrcUrl
        }

    }
}
/*
ListAdapter is a subclass of the RecyclerView.Adapter class for presenting List data in a
RecyclerView, including computing diffs between Lists on a background thread.

In this app you will use the DiffUtil implementation in the ListAdapter. The advantage of using
 DiffUtil is every time some item in the RecyclerView is added, removed or changed, the whole list
 doesn't get refreshed. Only the items that have been changed are refreshed.
 */