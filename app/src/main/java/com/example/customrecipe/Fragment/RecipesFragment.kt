package com.example.customrecipe.Fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isGone
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.customrecipe.CustomRecyclerAdapter
import com.example.customrecipe.Model.ListItem
import com.example.customrecipe.R
import com.example.customrecipe.databinding.FragmentRecipesBinding
class RecipesFragment : Fragment() {

    lateinit var binding: FragmentRecipesBinding
    lateinit var adapter: CustomRecyclerAdapter
    private var count = 0
    val handler = Handler(Looper.getMainLooper())
    var progress = 51
    var progress1 = 35
    var progress2 = 80
    var progress3 = 10
    var progress4 = 65
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipesBinding.inflate(layoutInflater, container, false)

        // Sample data
        val listItems = listOf(
            ListItem("43", "Boneless, skinless chicken breast halves", "231 Kcal"),
            ListItem("1/2 cup", "Ranch salad dressing", "231 Kcal"),
            ListItem("43", "Boneless, skinless chicken breast halves", "231 Kcal"),
            ListItem("43", "Boneless, skinless chicken breast halves", "231 Kcal"),
            ListItem("43", "Boneless, skinless chicken breast halves", "231 Kcal"),
            ListItem("1/2 cup", "Ranch salad dressing", "231 Kcal"),
            ListItem("43", "Boneless, skinless chicken breast halves", "231 Kcal"),
            ListItem("43", "Boneless, skinless chicken breast halves", "231 Kcal")

        )
        // Set up the adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = CustomRecyclerAdapter(requireContext(), listItems)

        binding.showItem.setOnClickListener {
            Toast.makeText(context, "this is show",Toast.LENGTH_SHORT).show()
            if (binding.recyclerView.visibility == View.VISIBLE) {
                binding.recyclerView.visibility = View.GONE
            } else {
                binding.recyclerView.visibility = View.VISIBLE
            }
        }
        binding.add.setOnClickListener {
            count++
            binding.countShow.text = count.toString()
            binding.imageCount.text = count.toString()
        }
        binding.sub.setOnClickListener {
            if (count > 0){
                count--
            }
            binding.countShow.text = count.toString()
            binding.imageCount.text = count.toString()
        }
        binding.nestedScrollView.setOnTouchListener { v, event ->
            v.parent?.requestDisallowInterceptTouchEvent(true) // Prevent parent from intercepting touch
            v.onTouchEvent(event) // Pass the event to the nested ScrollView
            true
        }
        handler.post(object : Runnable {
            override fun run() {
                if (progress < 71) {
                    progress += 10
                    updateProgressBar1(binding.progressBar1, binding.textViewProgress1)
                }
                handler.postDelayed(this, 1000) // Increment every 1 second
            }
        })

        handler.post(object : Runnable {
            override fun run() {
                if (progress1 < 45) {
                    progress1 += 10
                    updateProgressBar2(binding.progressBar2, binding.textViewProgress2)
                }
                handler.postDelayed(this, 1000) // Increment every 1 second
            }
        })
        handler.post(object : Runnable {
            override fun run() {
                if (progress1 < 70) {
                    progress1 += 10
                    updateProgressBar3(binding.progressBar3, binding.textViewProgress3)
                }
                handler.postDelayed(this, 1000) // Increment every 1 second
            }
        })
        handler.post(object : Runnable {
            override fun run() {
                if (progress3 < 20) {
                    progress3 += 10
                    updateProgressBar4(binding.progressBar4, binding.textViewProgress4)
                }
                handler.postDelayed(this, 1000) // Increment every 1 second
            }
        })
        handler.post(object : Runnable {
            override fun run() {
                if (progress4 < 80) {
                    progress4 += 10
                    updateProgressBar5(binding.progressBar5, binding.textViewProgress5)
                }
                handler.postDelayed(this, 1000) // Increment every 1 second
            }
        })

        return binding.root

    }
    // Method to update ProgressBar and TextView
    private fun updateProgressBar1(progressBar: ProgressBar, progressTextView: TextView) {
        progressBar.progress = progress
        progressTextView.text = "$progress%"
    }
    private fun updateProgressBar2(progressBar: ProgressBar, progressTextView: TextView) {
        progressBar.progress = progress1
        progressTextView.text = "$progress1%"
    }
    private fun updateProgressBar3(progressBar: ProgressBar, progressTextView: TextView) {
        progressBar.progress = progress2
        progressTextView.text = "$progress2%"
    }
    private fun updateProgressBar4(progressBar: ProgressBar, progressTextView: TextView) {
        progressBar.progress = progress3
        progressTextView.text = "$progress3%"
    }
    private fun updateProgressBar5(progressBar: ProgressBar, progressTextView: TextView) {
        progressBar.progress = progress4
        progressTextView.text = "$progress4%"
    }
}
