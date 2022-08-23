package hello

import chisel3._

class HelloWorld extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(32.W))
    val out = Output(UInt(32.W))
  })

  val r1 = Reg(UInt(32.W))
  r1 := io.in
  io.out := r1

}

object HelloWorldApp extends App {
  val s = getVerilogString(new HelloWorld())
  println(s)
}
