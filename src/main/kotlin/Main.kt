
val feeVisaMir = 0.75

fun main() {
    println("Коммиссия составила: " +
            commissionCalculation("VKPay",45_000_00, 100_000_00) +
            " рублей")
    println("Коммиссия составила: " +
            commissionCalculation("VisaMir",45_000_00, 100_000_00) +
            " рублей")
    }

fun commissionCalculation (cardType: String = "VisaMir", transferSum: Int, transfer: Int): Int {
    var commission = 0
    when(cardType) {
        "MasterMaestro" -> {
            if(transfer <= 150_000_00 && transferSum <= 600_000_00){
                if (transferSum > 75_000_00) {
                commission = (transfer * 0.6 / 100 +20).toInt()
                }
            } else println("Привышен лимит перевода")
        }
        "VisaMir" -> {
            if (transfer <= 150_000_00 && transferSum <= 600_000_00) {
                val commisionAmount = (transfer * feeVisaMir / 100).toInt()
                if (commisionAmount <= 35_00) {
                    commission = 35_00
                } else {
                    commission = commisionAmount / 100
                }
            } else println("Привышен лимит перевода")
        }

        "VKPay" -> {
            if (transfer <= 15_000_00 && transferSum <= 40_000_00 ) {
                commission = 0
            } else println("Привышен лимит перевода")
        }
    }
    return commission
}