import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun main() {
    // 1. Definisikan string JSON sesuai soal
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

    // 2. Inisialisasi Gson
    val gson = Gson()
    
    // 3. Tentukan tipe target pengubahan (List dari objek Product)
    val itemType = object : TypeToken<List<Product>>() {}.type
    val productList: List<Product> = gson.fromJson(jsonString, itemType)

    // 4. Perulangan untuk cetak produk yang isAvailable == true
    println("--- DAFTAR PRODUK TERSEDIA ---")
    productList.forEach { product ->
        if (product.isAvailable) {
            // Format output sesuai instruksi soal
            println("Produk Tersedia: ${product.productName} dengan harga Rp ${product.price}")
        }
    }
}
