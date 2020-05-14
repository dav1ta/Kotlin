package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ProductAdapter(getProducts())
        //recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.adapter = adapter

    }
    private fun getProducts(): List<Product> {

        val p1 = Product(1, "Apple", "1319$", R.drawable.apple)
        val p2 = Product(2, "Xiaomi", "359$", R.drawable.xiaomi)
        val p3 = Product(3, "Samsung", "599$", R.drawable.samsung)
        val p4 = Product(4, "Motorola", "439$", R.drawable.motorola)
        val p6 = Product(6, "Google", "1399$", R.drawable.google)
        val p7 = Product(7, "Oneplus", "534$", R.drawable.oneplus)
        val p8 = Product(8, "Motorola", "223$", R.drawable.motorola)
        val p9 = Product(9, "Nokia", "1324$", R.drawable.nokia)


        val returnList = ArrayList<Product>()

        returnList.add(p1)
        returnList.add(p2)
        returnList.add(p3)
        returnList.add(p4)
        returnList.add(p6)
        returnList.add(p7)
        returnList.add(p8)
        returnList.add(p9)


        return returnList

    }

}