package com.example.stockwise

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

class InventoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inventory)

        // Ensure your root layout in activity_inventory.xml has android:id="@+id/main"
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Setup Add Product Button
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
            // Here you can use:
            // bottomSheetView.findViewById<TextInputEditText>(R.id.etProductName).text.toString()
            // to get the values from the user.

            bottomSheetDialog.dismiss()
        }

        bottomSheetDialog.show()
    }
}