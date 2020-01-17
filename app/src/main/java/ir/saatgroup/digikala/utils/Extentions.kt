package ir.saatgroup.digikala.utils

fun Int.convertToPrice(): String {
    var out = ""
    var count = 0
    var price = this / 10
    while (price > 0) {
        if (count % 3 == 0 && count != 0) {
            out = ",$out"
        }
        count++
        when (price % 10) {
            0 -> out = "\u06f0" + out
            1 -> out = "\u06f1" + out
            2 -> out = "\u06f2" + out
            3 -> out = "\u06f3" + out
            4 -> out = "\u06f4" + out
            5 -> out = "\u06f5" + out
            6 -> out = "\u06f6" + out
            7 -> out = "\u06f7" + out
            8 -> out = "\u06f8" + out
            9 -> out = "\u06f9" + out
        }
        price /= 10

    }

    return "$out تومان "
}