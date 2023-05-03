package com.example.application_05_04_card_revise.controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.application_05_04_card_revise.R
import com.example.application_05_04_card_revise.databinding.ViewCartItemBinding
import com.example.application_05_04_card_revise.model.CartGoItem
import com.example.application_05_04_card_revise.viewModel.CartItemViewModel




class CartGoAdapter(private var items: List<CartGoItem>) :
    RecyclerView.Adapter<CartGoAdapter.CartGoViewHolder>() {





    fun updateCartGoItem(items: List<CartGoItem>) {
        this.items = items
        notifyDataSetChanged()
    }

    class CartGoViewHolder(val itemViewBinding: ViewCartItemBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root)

    override fun getItemCount(): Int {
        println("getItemCount:${items.size}")
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartGoViewHolder {
        val itemViewBinding = ViewCartItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        // 繼承卡面的 layout
        itemViewBinding.viewModel = CartItemViewModel()

        itemViewBinding.lifecycleOwner = parent.findViewTreeLifecycleOwner()

        return CartGoViewHolder(itemViewBinding)
    }

    override fun onBindViewHolder(holder: CartGoViewHolder, position: Int) {
        val item = items[position]
        with(holder) {
            itemViewBinding.viewModel?.item?.value = item
            val bundle = Bundle()
            bundle.putSerializable("item", item)
            itemView.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(R.id.action_cartFragment_to_cartItemFragment, bundle)
            }
        }
    }
}