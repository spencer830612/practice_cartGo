package com.example.application_05_04_card_revise.controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.application_05_04_card_revise.databinding.FragmentCartItemBinding
import com.example.application_05_04_card_revise.model.CartGoItem
import com.example.application_05_04_card_revise.viewModel.CartItemViewModel

/*點擊卡片後的詳細頁面*/
class CartItemFragment : Fragment() {
    private lateinit var binding : FragmentCartItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as MainActivity).supportActionBar?.show()
        val viewModel : CartItemViewModel by viewModels()
        binding = FragmentCartItemBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner  = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let {bundle ->
            bundle.getSerializable("item")?.let{
                binding.viewModel?.item?.value = it as CartGoItem
            }
        }
        binding.BtCancel.setOnClickListener {
            Navigation.findNavController(it)
                .popBackStack()
        }
    }
}