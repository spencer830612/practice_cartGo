package com.example.application_05_04_card_revise.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.application_05_04_card_revise.R
import com.example.application_05_04_card_revise.model.CartGoItem
import java.time.LocalDateTime
/*控管購物車首頁的數據*/
/*此頁面有完整跑完*/
class CartViewModel : ViewModel() {
    private var itemList = mutableListOf<CartGoItem>()

    val items: MutableLiveData<MutableList<CartGoItem>> by lazy { MutableLiveData<MutableList<CartGoItem>>() }

    init {
        loadItems()
    }

    fun search(input: String?) {
        val searchList = if (input == null || input.isEmpty()) {
            itemList
        } else {
            itemList.filter { item ->
                searchItem(item, input.trim())
            }.toMutableList()
        }
        items.value = searchList
    }

    private fun searchItem(item: CartGoItem, searchText: String): Boolean {
        return item.coachName.contains(searchText, ignoreCase = true) ||
                item.className.contains(searchText, ignoreCase = true) ||
                item.classCategory.contains(searchText, ignoreCase = true)
    }
    // 這個函數置入需要搜尋的區域

    private fun loadItems() {
        val itemList = mutableListOf<CartGoItem>()
        itemList.add(
            CartGoItem(
                R.drawable.b003,
                "田小班",
                "突刺有氧",
                "你會覺得恐懼\n你會覺得興奮\n你會覺得累",
                "2023-05-01 10:20:00",
                "2023-05-01 12:20:00",
                "1000", "有氧", "2"
            )
        )
        itemList.add(
            CartGoItem(
                R.drawable.b004,
                "田聖潔",
                "口香糖有氧",
                "我叫你吹～～～～\n吹出大泡泡！",
                "2023-05-01 10:20:00",
               "2023-05-01 12:20:00",
                "400", "超級有氧", "999"
            )
        )
        itemList.add(
            CartGoItem(
                R.drawable.b002, "星野愛", "應援有氧", "我愛你們\n" +
                        "總算說出口了\n" +
                        "對不起\n" +
                        "這句教練說得太晚了\n" +
                        "太好了\n" +
                        "這句話絕對\n" +
                        "不是謊言",
                "2023-05-01 10:20:00",
                "2023-05-01 12:20:00",
                "8000", "有氧", "1000"
            )
        )
        itemList.add(
            CartGoItem(
                R.drawable.b001,
                "瑞克·艾斯里",
                "搖擺無氧",
                "永遠不會放棄你\n永遠不會讓你失望\n永遠不會跑來跑去，拋棄你\n永遠不會讓你哭泣\n永遠不會說再見\n不說謊話，不傷害你",
                "2023-05-02 10:20:00",
                "2023-05-02 12:20:00",
                "88681",
                "無氧",
                "83"
            )
        )
        itemList.add(
            CartGoItem(
                R.drawable.b005,
                "蒲田聖護士",
                "海螺有氧",
                "你知道嗎?\n吹海螺一小時，\n勝過跑步一分鐘",
                "2023-05-03 10:20:00",
                "2023-05-03 12:20:00",
                "23498", "有氧", "9"
            )
        )
        itemList.add(
            CartGoItem(
                R.drawable.b006,
                "斧頭狂護士",
                "斧頭有氧",
                "如果病人佔了你的床位\n那麼你就從床底爬出來\n讓病人看看你的厲害",
                "2023-05-04 22:20:00",
                "2023-05-05 00:20:00",
                "77498864", "有氧", "9000"
            )
        )
        this.itemList = itemList
        this.items.value = this.itemList
    }
}