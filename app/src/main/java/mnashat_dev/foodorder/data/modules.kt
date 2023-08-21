package mnashat_dev.foodorder.data

data class Category(
    val name:String,
    val image:Int,
)

data class Popular(
    val name:String,
    val image:Int,
    val price : Double
)
data class Cart(
    val name:String,
    val image:Int,
    val price : Double,
    val totalPrice : Double,
    val amount: Int,

    )
