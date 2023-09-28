package com.example.farmtech.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.farmtech.models.Product
import com.example.farmtech.navigation.ROUTE_LOGIN
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProductRepository(navController:NavHostController,var context: Context) {
    var authRepository:AuthRepository
    var progress:ProgressDialog
    var products:ArrayList<Product>
    init {
        authRepository = AuthRepository(navController, context)
        if (!authRepository.isloggedin()){
            navController.navigate(ROUTE_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Kindly wait..")
        products = mutableListOf<Product>() as  ArrayList<Product>
    }
    fun saveProduct(name : String, quantity : String, price : String, description :String, id: String){
        var id = System.currentTimeMillis().toString()
        var productData = Product(name, price, quantity, description, id)
        var productRef = FirebaseDatabase.getInstance().getReference()
            .child("Products/$id")
        progress.show()
        productRef.setValue(productData).addOnCompleteListener { 
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context, "Saved Successfully", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "Error, Try Again", Toast.LENGTH_SHORT).show()
            }
        }
        
    }

    fun deleteProduct(id: String) {
        val delRef = FirebaseDatabase.getInstance().getReference().child("Products/$id")
        progress.show()
        delRef.removeValue().addOnCompleteListener { 
            progress.show()
            if (it.isSuccessful){
                Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun viewProducts(
        emptyProductState: MutableState<Product>,
        emptyProductsListState: SnapshotStateList<Product>
    ): ArrayList<Product> {
        var ref = FirebaseDatabase.getInstance().getReference().child("Products")
        progress.show()
        ref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                progress.dismiss()
                products.clear()
                for (snap in snapshot.children){
                    var product = snap.getValue(Product::class.java)
                    products.add(product!!)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                progress.dismiss()
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return products

    }

    fun saveProductWithImage(name: String, quantity: String, price: String, imageUri: Any) {

    }

    fun updateProduct(name : String, quantity : String, price : String, description :String, id: String){
        var id = System.currentTimeMillis().toString()
        var productData = Product(name, price, quantity, description, id)
        var productRef = FirebaseDatabase.getInstance().getReference()
            .child("Products/$id")
        progress.show()
        productRef.setValue(productData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context, "Saved Successfully", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "Error, Try Again", Toast.LENGTH_SHORT).show()
            }
        }

    }





}