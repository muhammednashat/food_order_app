package mnashat_dev.foodorder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import mnashat_dev.foodorder.data.Popular
import mnashat_dev.foodorder.databinding.ItemViewPopularBinding


class PopularAdapter(private val clickListener: PopularListener) :
    ListAdapter<Popular,PopularAdapter.PopularViewHolder>(PopularDiffUtil()) {


    class PopularViewHolder private constructor(val binding: ItemViewPopularBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            popular: Popular, clickListener: PopularListener
        ) {

            binding.popular = popular
            binding.clickListener = clickListener
            binding.executePendingBindings()

        }

        companion object {
            fun from(parent: ViewGroup): PopularViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemViewPopularBinding.inflate(layoutInflater, parent, false)

                return PopularViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {

        val item = getItem(position)
        holder.binding.apply {
            tvNameItem.text = item.name
            tvPrice.text = item.price.toString()
            imgItem.setImageResource(item.image)
        }

        holder.bind(getItem(position), clickListener)
    }
}


class PopularDiffUtil() : DiffUtil.ItemCallback<Popular>() {
    override fun areItemsTheSame(oldPopular: Popular, newPopular: Popular): Boolean {
        return oldPopular.image == newPopular.image
    }

    override fun areContentsTheSame(oldPopular: Popular, newPopular: Popular): Boolean {
        return oldPopular == newPopular
    }

}

class PopularListener(private val clickListener: (popular: Popular) -> Unit) {

    fun onClick(popular: Popular) = clickListener(popular)
}
