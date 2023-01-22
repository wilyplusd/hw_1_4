enum class KindPay {
    MASTERCARD, MAESTRO, VKPAY, VISA, MIR
}

fun takeTransferFee(
    amount: Double,
    previousTransfer: Double,
    kindPayTransfer: KindPay = KindPay.VKPAY,
): String {
    val percentTransfer: Double
    val minTransfer: Double
    val maxTransfer: Double
    val aboveTransfer: Double
    var transferFee: Double

    when (kindPayTransfer) {
        KindPay.VKPAY -> {
            percentTransfer = 0.00;
            minTransfer = 0.00;
            maxTransfer = 0.00;
            aboveTransfer = 0.00
        }

        KindPay.MAESTRO, KindPay.MASTERCARD -> {
            percentTransfer = 0.006;
            minTransfer = 0.00;
            maxTransfer = 75000.00
            aboveTransfer = 20.00
        }

        KindPay.VISA, KindPay.MIR -> {
            percentTransfer = 0.0075;
            minTransfer = 35.00;
            maxTransfer = 0.00
            aboveTransfer = 0.00
        }
    }

    transferFee = amount * percentTransfer + aboveTransfer

    if (kindPayTransfer == KindPay.MIR || kindPayTransfer == KindPay.VISA) {
        if (transferFee < minTransfer) {
            transferFee = minTransfer
        }
    }

    if (kindPayTransfer == KindPay.MAESTRO || kindPayTransfer == KindPay.MASTERCARD) {
        if (previousTransfer < maxTransfer) {
            transferFee = 0.00
        }
    }

    val transferAmount = amount - transferFee
    return "Ваша комиссия за перевод: $transferFee сумма перевода $transferAmount"
}

fun main() {
    //print(takeTransferFee(80000.00,  80000.00, KindPay.MIR))

}
