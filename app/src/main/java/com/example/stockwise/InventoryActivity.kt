package com.example.stockwise

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

class InventoryActivity : AppCompatActivity() {

    // Define data class and list here
    data class Product(val name: String, val qty: String, val price: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inventory)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Setup RecyclerView
        val dummyList = listOf(
            Product("Sample Item 1", "Qty: 5", "$10.00"),
            Product("Sample Item 2", "Qty: 12", "$25.50"),
                    Product("Sample Item 3", "Qty: 5", "$10.00"),
         Product("Sample Item 4", "Qty: 12", "$25.50"),
        Product("Sample Item 5", "Qty: 5", "$10.00"),
        Product("Sample Item 6", "Qty: 12", "$25.50")

        )

        val recyclerView = findViewById<RecyclerView>(R.id.rvInventoryList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProductAdapter(dummyList) // Ensure you created this class

        // 2. Setup Add Product Button
        val btnAddProduct = findViewById<MaterialCardView>(R.id.btnAddProduct)
        btnAddProduct.setOnClickListener {
            showAddProductDialog()
        }
    }

    private fun showAddProductDialog() {
        val bottomSheetView = layoutInflater.inflate(R.layout.dialog_add_product, null)
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(bottomSheetView)

        val btnSave = bottomSheetView.findViewById<MaterialButton>(R.id.btnSaveProduct)
        btnSave.setOnClickListener {
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.show()
    }
}