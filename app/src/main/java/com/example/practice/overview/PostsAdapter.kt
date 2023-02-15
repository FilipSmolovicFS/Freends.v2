package com.example.practice.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.databinding.PostsItemBinding
import com.example.practice.network.Content


class PostsAdapter(private  val listener: PostsAdapterInterface) :
    ListAdapter<Content, PostsAdapter.ContentPhotosViewHolder>(PhotoGridAdapter){

    class ContentPhotosViewHolder(
        private var binding: PostsItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(contentPhoto: Content) {
            binding.photo = contentPhoto
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Content>() {
        override fun areItemsTheSame(oldItem: Content, newItem: Content): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Content, newItem: Content): Boolean {
            return oldItem.imgSrcUrl == newItem.imgSrcUrl
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContentPhotosViewHolder {
        return ContentPhotosViewHolder(
            PostsItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ContentPhotosViewHolder, position: Int) {
        val contentPhoto = getItem(position)
        holder.itemView.setOnClickListener{
            listener.onImageClicked()
        }
        holder.bind(contentPhoto)
    }

    interface PostsAdapterInterface{
        fun onImageClicked()
    }


}