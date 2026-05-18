import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

data class Product(
    @SerializedName("product_id") 
    val productId: String,
    
    @SerializedName("product_name") 
    val productName: String,
    
    val price: Int,
    
    @SerializedName("is_available") 
    val isAvailable: Boolean
)

fun main() {
    val jsonString = """
        [
            {
                "product_id": "P001",
                "product_name": "Laptop Gaming X",
                "price": 15000000,
                "is_available": true
            },
            {
                "product_id": "P002",
                "product_name": "Mouse Wireless",
                "price": 250000,
                "is_available": false
            },
            {
                "product_id": "P003",
                "product_name": "Keyboard Mechanical",
                "price": 750000,
                "is_available": true
            }
        ]
    """.trimIndent()

    val gson = Gson()
    val listType = object : TypeToken<List<Product>>() {}.type
    val productList: List<Product> = gson.fromJson(jsonString, listType)

    productList.forEach { product ->
        if (product.isAvailable) {
            println("Produk Tersedia: [${product.productName}] dengan harga Rp [${product.price}]")
        }
    }
}
