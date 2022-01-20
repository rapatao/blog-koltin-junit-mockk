package com.rapatao.blog

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class WithMockKExtensionTest {

    @MockK
    private lateinit var calculatorService: CalculatorService

    @InjectMockKs
    private lateinit var mainService: MainService

    @Test
    fun `o resultado de 2+3 deve ser 5`() {
        every { calculatorService.sum(any(), any()) } returns 5

        val result = mainService.execute(2, 3, OpType.SUM)

        Assertions.assertEquals(5, result)
    }

    @Test
    fun `o resultado de 2*3 deve ser 6`() {
        every { calculatorService.multi(any(), any()) } returns 6

        val result = mainService.execute(2, 3, OpType.MULTI)

        Assertions.assertEquals(6, result)
    }
}
