package com.example.application_05_04_card_revise.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.application_05_04_card_revise.model.CartGoItem

/*控管單個卡面的部分，例如點入卡片後的詳細頁面、單張卡片上的東西等等*/
class CartItemViewModel  : ViewModel() {
    val item : MutableLiveData<CartGoItem> by lazy { MutableLiveData<CartGoItem>() }
}