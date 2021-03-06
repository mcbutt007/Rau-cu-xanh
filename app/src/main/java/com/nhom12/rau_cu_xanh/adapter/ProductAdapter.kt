package com.nhom12.rau_cu_xanh.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nhom12.rau_cu_xanh.R
import com.nhom12.rau_cu_xanh.model.Product
import com.nhom12.rau_cu_xanh.network.getBaseUrl
import kotlin.coroutines.coroutineContext

// Adapter cho recyclerview ở home
// Đọc ở đây trước để hiểu : https://developer.android.com/guide/topics/ui/layout/recyclerview

class ProductAdapter(val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val hinh: ImageView = itemView.findViewById(R.id.hinh)
        private val ten: TextView = itemView.findViewById(R.id.ten)
        private val gia: TextView = itemView.findViewById(R.id.gia)

        fun bind(product: Product) {
            // Lấy URL hình ảnh trên server
            val imageUrl: String = getBaseUrl() + "raucu/" + product.RauCu_ID + ".png"
            //Đổ hình ảnh từ url trên vào imageview
            Glide.with(itemView)
                .load(imageUrl) // image url
                .centerCrop() // im
                .into(hinh);  // imageview object
            // đổ json vào view
            ten.text = product.Name
            gia.text = product.Price.toString() + " VNĐ"
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}