package mnashat_dev.foodorder


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import mnashat_dev.foodorder.data.Category
import mnashat_dev.foodorder.databinding.ItemViewCategoriesBinding

class CategoryAdapter(private val clickListener: CategoryListener) :
    ListAdapter<Category, CategoryAdapter.CategoryViewHolder>(CategoryDiffUtil()) {


    class CategoryViewHolder private constructor(val binding: ItemViewCategoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            category: Category, clickListener: CategoryListener
        ) {

            binding.category = category
            binding.clickListener = clickListener
            binding.executePendingBindings()

        }

        companion object {
            fun from(parent: ViewGroup): CategoryViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemViewCategoriesBinding.inflate(layoutInflater, parent, false)

                return CategoryViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = getItem(position)
         holder.binding.apply {
             tvNameItem.text = item.name
             imgCategory.setImageResource(item.image)
         }

        holder.bind(item, clickListener)
    }
}


class CategoryDiffUtil() : DiffUtil.ItemCallback<Category>() {

    override fun areItemsTheSame(oldCategory: Category, newCategory: Category): Boolean {
        return oldCategory.image == newCategory.image
    }

    override fun areContentsTheSame(oldCategory: Category, newCategory: Category): Boolean {
        return oldCategory == newCategory
    }

}


class CategoryListener(private val clickListener: (category: Category) -> Unit) {

    fun onClick(category: Category) = clickListener(category)
}