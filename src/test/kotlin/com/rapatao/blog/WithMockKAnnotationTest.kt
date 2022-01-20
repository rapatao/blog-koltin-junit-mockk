package com.rapatao.blog

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class WithMockKAnnotationTest {

    @MockK
    private lateinit var calculatorService: CalculatorService

    @InjectMockKs
    private lateinit var mainService: MainService

    @BeforeEach
    fun setup() {
        MockKAnnotations.init(this)
    }

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
