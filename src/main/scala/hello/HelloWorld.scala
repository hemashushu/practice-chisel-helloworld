package hello

import chisel3._

class HelloWorld extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(32.W))
    val b = Input(UInt(32.W))
    val out = Output(UInt(32.W))
    val delay_a = Output(UInt(32.W))
    val div_out = Output(UInt(1.W))
  })

  // through register
  val delay_reg = Reg(UInt(32.W))
  delay_reg := io.a
  io.delay_a := delay_reg

  // logic AND
  io.out := io.a & io.b

  // counter
  val count_reg = RegInit(0.U(32.W))
  count_reg := Mux(count_reg === 4.U, 0.U, count_reg + 1.U)

  io.div_out := count_reg === 0.U

}

object HelloWorldApp extends App {
  val s = getVerilogString(new HelloWorld())
  println(s)
}

object HelloVerilog extends App {
  emitVerilog(new HelloWorld(), Array("--target-dir", "generated"))
}
