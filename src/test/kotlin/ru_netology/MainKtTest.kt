package ru_netology

import org.junit.jupiter.api.Test
import takeTransferFee
import kotlin.test.assertEquals

class MainKtTest {

    @Test
    fun takeTransferFee() {
        val test1 = takeTransferFee(100.00,  74000.00, KindPay.VISA)
        val test2 = takeTransferFee(76000.00,  80000.00, KindPay.MAESTRO)
        val test3 = takeTransferFee(2000.00,  74000.00, KindPay.MASTERCARD)
        val test4 = takeTransferFee(80000.00,  80000.00, KindPay.MIR)
        val test5 = takeTransferFee(100.00,  74000.00, KindPay.VKPAY)
        val test6 = takeTransferFee(72000.00,  76000.00, KindPay.MASTERCARD)
        val test7 = takeTransferFee(100.00, 74000.00)
        val reference1 = "Ваша комиссия за перевод: 35.0 сумма перевода 65.0"
        val reference2 = "Ваша комиссия за перевод: 476.0 сумма перевода 75524.0"
        val reference3 = "Ваша комиссия за перевод: 0.0 сумма перевода 2000.0"
        val reference4 = "Ваша комиссия за перевод: 600.0 сумма перевода 79400.0"
        val reference5 = "Ваша комиссия за перевод: 0.0 сумма перевода 100.0"
        val reference6 = "Ваша комиссия за перевод: 452.0 сумма перевода 71548.0"
        val reference7 = "Ваша комиссия за перевод: 0.0 сумма перевода 0.0"

        assertEquals(expected = reference1, actual = test1)
        assertEquals(expected = reference2, actual = test2)
        assertEquals(expected = reference3, actual = test3)
        assertEquals(expected = reference4, actual = test4)
        assertEquals(expected = reference5, actual = test5)
        assertEquals(expected = reference6, actual = test6)
        assertEquals(expected = reference7, actual = test7)

    }
}