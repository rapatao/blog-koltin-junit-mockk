package com.rapatao.blog

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SimpleTest {

    @Test
    fun `o resultado de 2+3 deve ser 5`() {
        val calculatorService = CalculatorService()
        val mainService = MainService(calculatorService)

        val result = mainService.execute(2, 3, OpType.SUM)

        assertEquals(5, result)
    }

    @Test
    fun `o resultado de 2*3 deve ser 6`() {
        val calculatorService = CalculatorService()
        val mainService = MainService(calculatorService)

        val result = mainService.execute(2, 3, OpType.MULTI)

        assertEquals(6, result)
    }

}