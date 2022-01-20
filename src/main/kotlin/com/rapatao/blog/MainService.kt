package com.rapatao.blog

class MainService(
    private val calculatorService: CalculatorService
) {
    fun execute(a: Int, b: Int, op: OpType) =
        when (op) {
            OpType.SUM -> calculatorService.sum(a, b)
            OpType.MULTI -> calculatorService.multi(a, b)
        }
}
