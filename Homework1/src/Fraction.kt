import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class Fraction (private var x: Int, private var y: Int) {



    override fun toString(): String {


        return "${this.x}/${this.y}"

    }


    private fun gcd(x: Int, y: Int): Int {
        if (y == 0) {
            return x
        } else {
            return gcd(y, x % y)
        }

    }

    fun scale(): String {
        val gcd = gcd(this.x, this.y)
        val a = x / gcd
        val b = y / gcd
        return "${a}/${b}"


    }



    fun multiplication(obj: Fraction ): Fraction {
       obj.x = obj.x * this.x
        obj.y = obj.y * this.y
        return obj


    }

}



fun main() {
    val fraction = Fraction(5,10)

    val newObject=fraction.multiplication(fraction)
    println(newObject.toString())


}