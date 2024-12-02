package com.example.customrecipe


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.customrecipe.Model.ListItem

class CustomRecyclerAdapter(
    private val context: Context,
    private val items: List<ListItem>
) : RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder>() {

    // ViewHolder to hold item views
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mount: TextView = itemView.findViewById(R.id.mount)
        val title: CheckBox = itemView.findViewById(R.id.title)
        val kcal: TextView = itemView.findViewById(R.id.kcal)
    }

    // Inflate item layout and return a ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false)
        return ViewHolder(view)
    }

    // Bind data to views
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.kcal.text = item.kcal
        holder.mount.text = item.mount

        // Example: Add a listener if needed
        holder.title.setOnCheckedChangeListener { _, isChecked ->
            // Handle checkbox state
            println("Item ${item.title} is checked: $isChecked")
        }
    }

    // Return total item count
    override fun getItemCount(): Int = items.size
}
